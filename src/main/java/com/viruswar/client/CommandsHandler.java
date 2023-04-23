package com.viruswar.client;

import com.viruswar.logging.LoggingService;
import com.viruswar.server.util.GameFieldService;
import com.viruswar.webservice.ServerResponseDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static com.viruswar.client.ClientForm.serverService;
import static com.viruswar.server.Server.CROSS_VIRUS;

public class CommandsHandler {
    final String MY_NAME = "";

    String crossSign = "X";
    String roundSign = "O";

    JTextArea Logs = null;
    JTable table;
    String group_name;

    public CommandsHandler(
            JTextArea _Logs,
            JTable _table,
            String _group_name) {

        Logs = _Logs;
        table = _table;
        group_name = _group_name;
    }

    int firstActionType = 0;
    int secondActionType = 1;

    int cutFirstPart = -1;
    int cutLastPart = 0;

    private String getSubstringOfGameCommand(String command, String delimeter, int action) {
        if (action == secondActionType && command.lastIndexOf(":") != cutFirstPart && command.lastIndexOf(":") != cutLastPart) {
            return command.substring(command.lastIndexOf(":") + 1);
        } else if (action == firstActionType && command.lastIndexOf(":") != cutFirstPart && command.lastIndexOf(":") != cutLastPart) {
            return command.substring(0, command.lastIndexOf(":"));
        }
        throw new UnsupportedOperationException("Невалидная команда");
    }

    public static int letterToNumber(String column) {
        for (int i = 0; i < GameFieldService.NUM_OF_COLUMNS; i++)
            if (GameFieldService.colums[i].equals(column)) {
                return i + 1;
            }

        return 0;
    }

    private void handleKillEnemyOrEmptyCell(ServerResponseDto serverResponseDto){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String command_coord = serverResponseDto.getCommandCoord();
        String row = getSubstringOfGameCommand(command_coord, ":", 0);
        String col = getSubstringOfGameCommand(command_coord, ":", 1);
        switch (serverResponseDto.getCommand()) {
            case "CA" -> {
                if (group_name.equals(CROSS_VIRUS)) {
                    model.setValueAt(crossSign, Integer.parseInt(row) - 1, letterToNumber(col));
                    LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                } else {
                    model.setValueAt(roundSign, Integer.parseInt(row) - 1, letterToNumber(col));
                    LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                }
            }
            case "KTI"->  {
                model.setValueAt("KillX", Integer.parseInt(row) - 1, letterToNumber(col));
                LoggingService.logging("Ход выполнен", Logs, MY_NAME);
            }
            case "KTO"-> {
                model.setValueAt("KillO", Integer.parseInt(row) - 1, letterToNumber(col));
                LoggingService.logging("Ход выполнен", Logs, MY_NAME);
            }
        }
        table.setModel(model);
        if (serverResponseDto.getInfoTurn().equals("YT")) {
            if (group_name.equals(CROSS_VIRUS)) {
                serverService.changeMovesPermitFlags(true, false);
            }
            else {
                serverService.changeMovesPermitFlags(false, true);
            }
        } else if (serverResponseDto.getInfoTurn().equals("ET")) {
            if (group_name.equals(CROSS_VIRUS)) {
                serverService.changeMovesPermitFlags(false, true);
            }
            else {
                serverService.changeMovesPermitFlags(true, false);
            }
        }
    }

    public void handleCommandServer(ServerResponseDto serverResponseDto) {
        switch (serverResponseDto.getCommand()) {
            case "CA", "KTI", "KTO" -> handleKillEnemyOrEmptyCell(serverResponseDto);
            case "YT" -> {
                if (group_name.equals(CROSS_VIRUS)) {
                    serverService.changeMovesPermitFlags(true, false);
                }
                else {
                    serverService.changeMovesPermitFlags(false, true);
                }
            }
            case "CN" -> LoggingService.logging("Клетка недоступна!", Logs, MY_NAME);
            case "ET" -> {
                int num_commands = serverResponseDto.getNumCommands();
                System.out.println(num_commands);

                for (int i = 0; i < num_commands; i++) {
                    String comm = serverResponseDto.getComm();
                    String status = serverResponseDto.getStatus();

                    System.out.println(comm);
                    System.out.println(status);

                    String row = getSubstringOfGameCommand(comm, ":", 0);
                    String col = getSubstringOfGameCommand(comm, ":", 1);

                    DefaultTableModel model = (DefaultTableModel) table.getModel();
                    model.setValueAt(status, Integer.parseInt(row) - 1, letterToNumber(col));
                }
            }
            case "WIN" -> LoggingService.logging("Вы выиграли!", Logs, MY_NAME);
            case "LOSE" -> LoggingService.logging("Вы проиграли!", Logs, MY_NAME);
            case "DRAW" -> LoggingService.logging("Ничья!", Logs, MY_NAME);
        }
    }

    public void handleEnemyCommand(ServerResponseDto serverResponseDto, String whoseTurn) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        String command_coord = serverResponseDto.getCommandCoord();
        String row = getSubstringOfGameCommand(command_coord, ":", 0);
        String col = getSubstringOfGameCommand(command_coord, ":", 1);
        switch (serverResponseDto.getCommand()) {
            case "CA" -> {
                if (whoseTurn.equals(CROSS_VIRUS)) {
                    model.setValueAt(crossSign, Integer.parseInt(row) - 1, letterToNumber(col));
                    LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                } else {
                    model.setValueAt(roundSign, Integer.parseInt(row) - 1, letterToNumber(col));
                    LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                }
            }
            case "KTI" ->  {
                model.setValueAt("KillX", Integer.parseInt(row) - 1, letterToNumber(col));
                LoggingService.logging("Ход выполнен", Logs, MY_NAME);
            }
            default -> {
                model.setValueAt("KillO", Integer.parseInt(row) - 1, letterToNumber(col));
                LoggingService.logging("Ход выполнен", Logs, MY_NAME);
            }
        }
    }
}
