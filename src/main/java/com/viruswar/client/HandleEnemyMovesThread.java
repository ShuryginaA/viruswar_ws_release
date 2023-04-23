package com.viruswar.client;

import com.viruswar.server.util.GameFieldService;
import com.viruswar.webservice.MadeCommandsDto;
import com.viruswar.webservice.ServerResponseDto;
import com.viruswar.webservice.ServerService;
import com.viruswar.webservice.ServerServiceService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.viruswar.client.ClientForm.url;
import static com.viruswar.server.Server.CROSS_VIRUS;
import static com.viruswar.server.Server.ROUND_VIRUS;

public class HandleEnemyMovesThread extends Thread {

    List<MadeCommandsDto> madeMovesForClient = new ArrayList<>();

    ServerService serverService = new ServerServiceService(new URL(url)).getServerServicePort();

    public HandleEnemyMovesThread() throws MalformedURLException {
    }

    private String findRealTurn(){
        if(serverService.findWhoseTurn().equals(ROUND_VIRUS)){
            if (GameFieldService.trickyCellCoordCross.contains(madeMovesForClient.size())) {
                return CROSS_VIRUS;
            }
            return ROUND_VIRUS;
        }
        if(serverService.findWhoseTurn().equals(CROSS_VIRUS)){
            if (GameFieldService.trickyCellCoordRound.contains(madeMovesForClient.size())) {
                return ROUND_VIRUS;
            }
            return CROSS_VIRUS;
        }
        return serverService.findWhoseTurn();
    }

    @Override
    public void run() {
        boolean firstMoveFlag = true;
        while (true) {
            List<MadeCommandsDto> movesForClient = serverService.getMadeGameMoves();
            if(movesForClient.size() == 1 && firstMoveFlag) {
                madeMovesForClient.add(movesForClient.get(0));
                MadeCommandsDto firstMove = movesForClient.get(0);
                ServerResponseDto serverResponseDto = new ServerResponseDto();
                serverResponseDto.setInfoTurn(firstMove.getMyMovesForClientInfoTurn());
                serverResponseDto.setCommandCoord(firstMove.getMyMovesForClientCommandCoord());
                serverResponseDto.setCommand(firstMove.getMyMovesForClientCommand());
                ClientForm.commandsHandler.handleEnemyCommand(serverResponseDto, findRealTurn());
                firstMoveFlag = false;
            }
            if(madeMovesForClient.size() > 0 ) {
                System.out.println(madeMovesForClient.size() + " " + movesForClient.size());
                MadeCommandsDto lastMove = movesForClient.get(movesForClient.size() - 1);
                if (madeMovesForClient.size() < movesForClient.size()) {
                    ServerResponseDto serverResponseDto = new ServerResponseDto();
                    serverResponseDto.setInfoTurn(lastMove.getMyMovesForClientInfoTurn());
                    serverResponseDto.setCommandCoord(lastMove.getMyMovesForClientCommandCoord());
                    serverResponseDto.setCommand(lastMove.getMyMovesForClientCommand());
                    madeMovesForClient.add(movesForClient.get(movesForClient.size()-1));
                    ClientForm.commandsHandler.handleEnemyCommand(serverResponseDto, findRealTurn());
                }}
        }

    }
}
