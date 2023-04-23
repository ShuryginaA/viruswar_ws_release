package com.viruswar.client;

import com.viruswar.webservice.ServerResponseDto;
import com.viruswar.webservice.ServerService;
import com.viruswar.webservice.ServerServiceService;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class CommandsSender {

    JTextArea Logs;

    public static final String url = "http://localhost:8081/viruswar";

    ServerService serverService = new ServerServiceService(new URL(url)).getServerServicePort();


    public CommandsSender(JTextArea _Logs) throws MalformedURLException {
        Logs = _Logs;
    }

    private ServerResponseDto sendGameCommand(String command) {
        return serverService.handleMoves(command);
    }

    public ServerResponseDto SendCommand(String command) {
        return sendGameCommand(command);
    }
}
