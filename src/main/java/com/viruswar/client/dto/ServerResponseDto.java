package com.viruswar.client.dto;

public class ServerResponseDto {

    public String command;
    public String info_turn;
    public String command_coord;

    public ServerResponseDto() {
    }

    public ServerResponseDto(String command, String info_turn, String command_coord) {
        this.command = command;
        this.info_turn = info_turn;
        this.command_coord = command_coord;
    }
}
