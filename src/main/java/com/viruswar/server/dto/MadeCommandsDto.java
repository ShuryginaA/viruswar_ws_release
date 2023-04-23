package com.viruswar.server.dto;

public class MadeCommandsDto {

    public String myMovesForClientCommandCoord;
    public String myMovesForClientInfoTurn;
    public String myMovesForClientCommand;

    public MadeCommandsDto(String myMovesForClientCommandCoord, String myMovesForClientInfoTurn,
                           String myMovesForClientCommand) {
        this.myMovesForClientCommandCoord = myMovesForClientCommandCoord;
        this.myMovesForClientInfoTurn = myMovesForClientInfoTurn;
        this.myMovesForClientCommand = myMovesForClientCommand;
    }
}
