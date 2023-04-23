package com.viruswar.server.communication;

import com.viruswar.server.dto.ClientGameCommandDto;
import com.viruswar.server.dto.MadeCommandsDto;
import com.viruswar.server.util.GameFieldService;
import com.viruswar.server.util.GameRulesService;
import com.viruswar.server.util.MovePermitChecker;
import com.viruswar.webservice.ServerResponseDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.viruswar.server.Server.CROSS_VIRUS;
import static com.viruswar.server.Server.ROUND_VIRUS;
import static com.viruswar.server.util.GameRulesService.num_turn;

@WebService
public class ServerService {

    Socket cs;
    String group_name = "";
    
    OutputStream cos = null;
    private Map<String, Map<String, GameFieldService.CELL_STATE>> GameState = GameFieldService.GAME_STATE_INIT;

    int num_rounds = 1; // Current number of toes in game
    int num_cross = 1; // -//- tics

    ClientGameCommandDto CGC;

    ClientGameCommandDto CGC_cross = new ClientGameCommandDto();
    ClientGameCommandDto CGC_round = new ClientGameCommandDto();

    ClientGameCommandDto MyMoves[] = new ClientGameCommandDto[3];
    List<MadeCommandsDto> madeMovesForClient = new ArrayList<>();

    int count_turn_cross = 1;
    int count_turn_round = 1;

    int countfornemysend_cross = 1; // delete_me
    int countfornemysend_round = 1; // delete_me

    boolean isCrossPicked = false;
    boolean isRoundPicked = false;

    boolean IsInit = true;

    boolean IsFirstMoveRound = true;

    public ServerService() {
        for(int i = 0; i < 3; i++) {
            MyMoves[i] = new ClientGameCommandDto();
        }

        num_turn = 1;
    }

    @WebMethod
    public void sendCommand(String command, String groupName) {
        if (groupName.equals(CROSS_VIRUS)) {
            sendCommandToCross(command);
        } else if(groupName.equals(ROUND_VIRUS)) {
            sendCommandToRound(command);
        }
    }

    @WebMethod
    public String getClientGroup() {
       if(!isCrossPicked){
           isCrossPicked =true;
           return "cross";
       }
       else return "round";
    }

    @WebMethod
    public boolean isMovePermit(String groupName) {
        return MovePermitChecker.isMovePermit(groupName);
    }

    @WebMethod
    public void changeMovesPermitFlags(boolean isPermitForCross, boolean isPermitForRounds) {
        MovePermitChecker.isMovePermitForCross = isPermitForCross;
        MovePermitChecker.isMovePermitForRounds = isPermitForRounds;
    }

    @WebMethod
    public void sendCommandToCross(String command) {
        if (cs != null) {
            DataOutputStream cdos = new DataOutputStream(cos);
            try {
                cdos.writeUTF(command);
                String info = "Game command " + command + " send to cross";
            } catch (IOException ex) {
                Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @WebMethod
    public void sendCommandToRound(String command) {
        if (cs != null) {
            DataOutputStream cdos = new DataOutputStream(cos);
            try {
                cdos.writeUTF(command);
                String info = "Game command " + command + " send to toes";
            } catch (IOException ex) {
                Logger.getLogger(ServerService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    @WebMethod
    public ServerResponseDto run(String command) {
        if (!GameRulesService.checkGameEnded(num_cross, num_rounds)) {
            if (GameRulesService.findWhoseTurn().equals(CROSS_VIRUS)) {
                count_turn_round = 0;
                IsInit = false;
                CGC_cross.command=command;
                CGC_cross.group_name = "cross";
                return handleCrossMoves();
            } else if (GameRulesService.findWhoseTurn().equals(ROUND_VIRUS)) {

                count_turn_cross = 0;

                if(IsFirstMoveRound) {
                    num_turn = 1;
                    count_turn_round = 1;
                }

                IsFirstMoveRound = false;
                IsInit = false;
                CGC_round.command=command;
                CGC_round.group_name = "round";
                return handleRoundMoves();
            }
               return Draw();

        }
       return null;
    }

    @WebMethod
    public List<MadeCommandsDto> getMadeGameMoves() {
        return madeMovesForClient;
    }

    @WebMethod
    public void handlerOfClient(String command_info, String command, String group_name) {
        if(command_info.equals("GI")) {
            HandleGameCommand(command);
        }
    }
    @WebMethod
    public boolean checkGameEnded() {
       return GameRulesService.checkGameEnded(num_cross, num_rounds);
    }

    @WebMethod
    public String findWhoseTurn() {
        return GameRulesService.findWhoseTurn();
    }


    private String getSubstringOfGameCommand(String command, String delimeter, int action) {
        // если в строке command есть delimeter и он не является первым символом в строке command и action == 1 (берем то, что после delimeter стоит)
        if (command.lastIndexOf(delimeter) != -1 && command.lastIndexOf(delimeter) != 0 && action == 1) // то вырезаем все знаки после delimeter в command, то есть <first_part><delimeter><second_part> -> <second_part>
        {
            return command.substring(command.lastIndexOf(delimeter) + 1);
        } // -//- action == 0 (берем то, что перед delimeter стоит)
        else if (command.lastIndexOf(delimeter) != -1 && command.lastIndexOf(delimeter) != 0 && action == 0) { // то вырезаем все знаки после delimeter в command, то есть <first_part><delimeter><second_part> -> <first_part>
            return command.substring(0, command.lastIndexOf(delimeter));
        }

        return ""; // Bad case
    }

    public ServerResponseDto handleCrossMoves() {
        String myMovesForClientCommandCoord=null;
        String myMovesForClientInfoTurn;
        String myMovesForClientCommand = null;
        ServerResponseDto serverResponseDto = new ServerResponseDto();
        String row = getSubstringOfGameCommand(CGC_cross.command, ":", 0);
        String col = getSubstringOfGameCommand(CGC_cross.command, ":", 1);

        if (GameRulesService.isCellAccessible(CGC_cross.group_name, row, col, GameState)) {
            GameFieldService.CELL_STATE state = GameRulesService.getValue(row, col, GameState);
            MyMoves[count_turn_cross].command = CGC_cross.command;
            count_turn_cross++;

            if (state.equals(GameFieldService.CELL_STATE.CELL_EMPTY)) {
                num_turn++;

                if (num_cross == -1) {
                    num_cross += 2;
                } else {
                    num_cross++;
                }

                GameRulesService.occupyCell(row, col, GameState, CROSS_VIRUS);
                serverResponseDto.setCommand("CA");
                serverResponseDto.setCommandCoord(CGC_cross.command);
                myMovesForClientCommandCoord = CGC_cross.command;
                myMovesForClientCommand = "CA";
                MyMoves[count_turn_cross - 1].status = "X";
            } else if (state.equals(GameFieldService.CELL_STATE.ROUND_HERE)) {
                num_turn++;

                GameRulesService.killRound(row, col, GameState);
                num_rounds--;

                serverResponseDto.setCommand("KTO");
                serverResponseDto.setCommandCoord(CGC_cross.command);
                myMovesForClientCommand = "KTO";
                myMovesForClientCommandCoord = CGC_cross.command;
                serverResponseDto.setCommandCoord(CGC_cross.command);
                MyMoves[count_turn_cross - 1].status = "KO";
            }

            if (count_turn_cross < 3) {
                serverResponseDto.setInfoTurn("YT");
                myMovesForClientInfoTurn="YT";
            } else {
                serverResponseDto.setInfoTurn("ET");
                myMovesForClientInfoTurn="ET";
            }
            if(Objects.nonNull(myMovesForClientCommandCoord)) {
                madeMovesForClient.add(new MadeCommandsDto(myMovesForClientCommandCoord,
                                                           myMovesForClientInfoTurn,
                                                           myMovesForClientCommand));
            }
            return serverResponseDto;
        }
            ServerResponseDto responseDto = new ServerResponseDto();
            responseDto.setCommand("CN");
            return responseDto;

    }

    private ServerResponseDto handleRoundMoves() {
        String myMovesForClientCommandCoord=null;
        String myMovesForClientInfoTurn;
        String myMovesForClientCommand = null;
        ServerResponseDto serverResponseDto = new ServerResponseDto();
        String row = getSubstringOfGameCommand(CGC_round.command, ":", 0);
        String col = getSubstringOfGameCommand(CGC_round.command, ":", 1);

        if (GameRulesService.isCellAccessible(CGC_round.group_name, row, col, GameState)) {
            GameFieldService.CELL_STATE state = GameRulesService.getValue(row, col, GameState);
            MyMoves[count_turn_round].command = CGC_round.command;
            count_turn_round++;

            if (state.equals(GameFieldService.CELL_STATE.CELL_EMPTY)) {
                num_turn++;

                if (num_rounds == -1) {
                    num_rounds += 2;
                } else {
                    num_rounds++;
                }

                GameRulesService.occupyCell(row, col, GameState, ROUND_VIRUS);
                serverResponseDto.setCommand("CA");
                serverResponseDto.setCommandCoord(CGC_round.command);
                myMovesForClientCommandCoord = CGC_round.command;
                myMovesForClientCommand = "CA";
                MyMoves[count_turn_round - 1].status = "O";
            } else if (state.equals(GameFieldService.CELL_STATE.CROSS_HERE)) {
                num_turn++;

                GameRulesService.killCross(row, col, GameState);
                num_cross--;
                serverResponseDto.setCommand("KTI");
                myMovesForClientCommand = "KTI";
                myMovesForClientCommandCoord = CGC_round.command;
                serverResponseDto.setCommandCoord(CGC_round.command);
                MyMoves[count_turn_round - 1].status = "KX";
            }

            if (count_turn_round < 3) {
                serverResponseDto.setInfoTurn("YT");
                myMovesForClientInfoTurn="YT";
            } else {
                serverResponseDto.setInfoTurn("ET");
                myMovesForClientInfoTurn="ET";
            }
            if(Objects.nonNull(myMovesForClientCommandCoord)) {
                madeMovesForClient.add(new MadeCommandsDto(myMovesForClientCommandCoord,
                        myMovesForClientInfoTurn,
                        myMovesForClientCommand));
            }
            return serverResponseDto;
        }
            ServerResponseDto responseDto = new ServerResponseDto();
            responseDto.setCommand("CN");
            return responseDto;
    }

    private ServerResponseDto Draw() {
        ServerResponseDto responseDto = new ServerResponseDto();
        responseDto.setCommand("DRAW");
        return responseDto;
    }

    private void Deliverance(String _winner) {
        if (_winner.equals(CROSS_VIRUS)) {
            sendCommand("WIN", CGC_cross.group_name);
            sendCommand("LOSE", CGC_round.group_name);
        } else {
            sendCommand("LOSE", CGC_cross.group_name);
            sendCommand("WIN", CGC_round.group_name);
        }
    }

    private void SendEnemyMoves(String enemy) {
        if (enemy.equals(CROSS_VIRUS)) {
            if (count_turn_cross > 0) {
                sendCommand("EM", CGC_round.group_name);
                sendCommand(Integer.toString(count_turn_cross - countfornemysend_cross), CGC_round.group_name);
                for (int i = countfornemysend_cross; i < count_turn_cross; i++) {
                    sendCommand(MyMoves[i].command, CGC_round.group_name);
                    sendCommand(MyMoves[i].status, CGC_round.group_name);
                }

                countfornemysend_round = 0;
            }
        } else {
            if (count_turn_round > 0) {
                sendCommand("EM",CGC_cross.group_name);
                sendCommand(Integer.toString(count_turn_round - countfornemysend_cross),CGC_cross.group_name);

                for (int i = countfornemysend_cross; i < count_turn_round; i++) {
                    sendCommand(MyMoves[i].command, CGC_cross.group_name);
                    sendCommand(MyMoves[i].status, CGC_cross.group_name);
                }

                countfornemysend_cross = 0;
            }
        }
    }
    private void HandleGameCommand(String command) {
        CGC.command = command;
        CGC.group_name = group_name;
    }

}
