package com.viruswar.server.communication;

import com.viruswar.server.dto.ClientGameCommandDto;
import com.viruswar.server.dto.MadeCommandsDto;
import com.viruswar.server.util.GameFieldService;
import com.viruswar.server.util.GameRulesService;
import com.viruswar.server.util.MovePermitChecker;
import com.viruswar.webservice.ServerResponseDto;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;

import static com.viruswar.server.Server.CROSS_VIRUS;
import static com.viruswar.server.Server.ROUND_VIRUS;
import static com.viruswar.server.util.GameRulesService.num_turn;

@WebService
public class ServerService {
    private Map<String, Map<String, GameFieldService.CELL_STATE>> GameState = GameFieldService.GAME_STATE_INIT;

    int num_rounds = 1;
    int num_cross = 1;

    ClientGameCommandDto clientGameCommandDtoCross = new ClientGameCommandDto();
    ClientGameCommandDto clientGameCommandDtoRound = new ClientGameCommandDto();

    ClientGameCommandDto moves[] = new ClientGameCommandDto[3];
    List<MadeCommandsDto> madeMovesForClient = new ArrayList<>();

    int count_turn_cross = 1;
    int count_turn_round = 1;

    boolean isCrossPicked = false;
    boolean isRoundPicked = false;

    boolean IsInit = true;

    boolean IsFirstMoveRound = true;

    public ServerService() {
        for(int i = 0; i < 3; i++) {
            moves[i] = new ClientGameCommandDto();
        }

        num_turn = 1;
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
    public ServerResponseDto handleMoves(String command) {
        if (!GameRulesService.checkGameEnded(num_cross, num_rounds)) {
            if (GameRulesService.findWhoseTurn().equals(CROSS_VIRUS)) {
                count_turn_round = 0;
                IsInit = false;
                clientGameCommandDtoCross.command=command;
                clientGameCommandDtoCross.group_name = "cross";
                return handleCrossMoves();
            } else if (GameRulesService.findWhoseTurn().equals(ROUND_VIRUS)) {

                count_turn_cross = 0;

                if(IsFirstMoveRound) {
                    num_turn = 1;
                    count_turn_round = 1;
                }

                IsFirstMoveRound = false;
                IsInit = false;
                clientGameCommandDtoRound.command=command;
                clientGameCommandDtoRound.group_name = "round";
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
        String row = getSubstringOfGameCommand(clientGameCommandDtoCross.command, ":", 0);
        String col = getSubstringOfGameCommand(clientGameCommandDtoCross.command, ":", 1);

        if (GameRulesService.isCellAccessible(clientGameCommandDtoCross.group_name, row, col, GameState)) {
            GameFieldService.CELL_STATE state = GameRulesService.getValue(row, col, GameState);
            moves[count_turn_cross].command = clientGameCommandDtoCross.command;
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
                serverResponseDto.setCommandCoord(clientGameCommandDtoCross.command);
                myMovesForClientCommandCoord = clientGameCommandDtoCross.command;
                myMovesForClientCommand = "CA";
                moves[count_turn_cross - 1].status = "X";
            } else if (state.equals(GameFieldService.CELL_STATE.ROUND_HERE)) {
                num_turn++;

                GameRulesService.killRound(row, col, GameState);
                num_rounds--;

                serverResponseDto.setCommand("KTO");
                serverResponseDto.setCommandCoord(clientGameCommandDtoCross.command);
                myMovesForClientCommand = "KTO";
                myMovesForClientCommandCoord = clientGameCommandDtoCross.command;
                serverResponseDto.setCommandCoord(clientGameCommandDtoCross.command);
                moves[count_turn_cross - 1].status = "KO";
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
        String row = getSubstringOfGameCommand(clientGameCommandDtoRound.command, ":", 0);
        String col = getSubstringOfGameCommand(clientGameCommandDtoRound.command, ":", 1);

        if (GameRulesService.isCellAccessible(clientGameCommandDtoRound.group_name, row, col, GameState)) {
            GameFieldService.CELL_STATE state = GameRulesService.getValue(row, col, GameState);
            moves[count_turn_round].command = clientGameCommandDtoRound.command;
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
                serverResponseDto.setCommandCoord(clientGameCommandDtoRound.command);
                myMovesForClientCommandCoord = clientGameCommandDtoRound.command;
                myMovesForClientCommand = "CA";
                moves[count_turn_round - 1].status = "O";
            } else if (state.equals(GameFieldService.CELL_STATE.CROSS_HERE)) {
                num_turn++;

                GameRulesService.killCross(row, col, GameState);
                num_cross--;
                serverResponseDto.setCommand("KTI");
                myMovesForClientCommand = "KTI";
                myMovesForClientCommandCoord = clientGameCommandDtoRound.command;
                serverResponseDto.setCommandCoord(clientGameCommandDtoRound.command);
                moves[count_turn_round - 1].status = "KX";
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

}
