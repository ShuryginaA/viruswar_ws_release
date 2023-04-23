package com.viruswar.server;

import com.viruswar.server.communication.ServerService;

import javax.xml.ws.Endpoint;

public class Server {

    public enum ServerCommand {
        YOUR_TURN("YT"),
        ENEMY_TURN("ET"),
        CELL_ACCESSIBLE("CA"),
        CELL_NOT_ACCESSIBLE("CN"),
        CELL_NOT_ACCESSIBLE_A("CNA"),
        WIN("YOU WIN"),
        LOSE("YOU LOSE"),
        DRAW("DRAW"),
        KILL_ROUND("KTO"),
        KILL_CROSS("KTI"),
        SERVER_NOT_AVAILABLE("SC"),
        INVALID_COMMAND("WC"),
        GAME_INFO("GI"),
        SERVICE_INFO("SI"),
        CREATE_NEW_GAME("CNG"),
        JOIN_GAME("JG"),
        LEAVE_GAME("DG"),
        WROND_INFO("WRONG_INFO"),
        DEFAULT(" ");

        private final String commandName;

        ServerCommand(String name) {
            commandName = name;
        }
        public String getCommandName(){
            return commandName;
        }
    }

    public static final String CROSS_VIRUS = "cross";
    public static final String ROUND_VIRUS = "round";

    public static final String url = "http://localhost:8081/viruswar";

    public static void main(String[] args) {
        ServerService serverService = new ServerService();
        Endpoint.publish(url, serverService);
    }
}
