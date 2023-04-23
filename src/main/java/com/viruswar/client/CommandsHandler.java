package com.viruswar.client;

import com.viruswar.logging.LoggingService;
import com.viruswar.server.util.GameFieldService;
import com.viruswar.server.util.MovePermitChecker;
import com.viruswar.webservice.ServerResponseDto;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.viruswar.client.ClientForm.serverService;
import static com.viruswar.server.Server.CROSS_VIRUS;

public class CommandsHandler {
    final String MY_NAME = "";

    JTextArea Logs = null;
    boolean IsConnect = true;
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

    private String getSubstringOfGameCommand(String command, String delimeter, int action) {
        if (command.lastIndexOf(delimeter) != -1 && command.lastIndexOf(delimeter) != 0 && action == 1) // то вырезаем все знаки после delimeter в command, то есть <first_part><delimeter><second_part> -> <second_part>
        {
            return command.substring(command.lastIndexOf(delimeter) + 1);
        } else if (command.lastIndexOf(delimeter) != -1 && command.lastIndexOf(delimeter) != 0 && action == 0) { // то вырезаем все знаки после delimeter в command, то есть <first_part><delimeter><second_part> -> <first_part>
            return command.substring(0, command.lastIndexOf(delimeter));
        }

        return "";
    }

    public static int letterToNumber(String column) {
        for (int i = 0; i < GameFieldService.NUM_OF_COLUMNS; i++)
            if (GameFieldService.colums[i].equals(column)) {
                return i + 1;
            }

        return 0;
    }

    public void handleCommandServer(ServerResponseDto serverResponseDto) {

        String command = "";
        String info_turn = serverResponseDto.getInfoTurn();

        try {
            command = serverResponseDto.getCommand();

            if (command.equals("CA") || command.equals("KTI") || command.equals("KTO")) {
                String command_coord = serverResponseDto.getCommandCoord();
                String row = getSubstringOfGameCommand(command_coord, ":", 0);
                String col = getSubstringOfGameCommand(command_coord, ":", 1);

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                if (command.equals("CA")) {
                    if (group_name.equals(CROSS_VIRUS)) {
                        model.setValueAt("X", Integer.valueOf(row) - 1, letterToNumber(col));
                        LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                    } else {
                        model.setValueAt("O", Integer.valueOf(row) - 1, letterToNumber(col));
                        LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                    }
                } else if (command.equals("KTI")) {
                    model.setValueAt("KillX", Integer.valueOf(row) - 1, letterToNumber(col));
                    LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                } else {
                    model.setValueAt("KillO", Integer.valueOf(row) - 1, letterToNumber(col));
                    LoggingService.logging("Ход выполнен", Logs, MY_NAME);
                }
                table.setModel(model);
                if (info_turn.equals("YT")) {
                    if (group_name.equals(CROSS_VIRUS)) {
                        serverService.changeMovesPermitFlags(true, false);
                    }
                    else {
                        serverService.changeMovesPermitFlags(false, true);
                    }
                } else if (info_turn.equals("ET")) {
                    if (group_name.equals(CROSS_VIRUS)) {
                        serverService.changeMovesPermitFlags(false, true);
                    }
                    else {
                        serverService.changeMovesPermitFlags(true, false);
                    }
                }
            } else if (command.equals("YT")) {
                if (group_name.equals(CROSS_VIRUS)) {
                    serverService.changeMovesPermitFlags(true, false);
                }
                else {
                    serverService.changeMovesPermitFlags(false, true);
                }
            } else if (command.equals("CN")) {
                LoggingService.logging("Клетка недоступна!", Logs, MY_NAME);
            } else if (command.equals("EM")) {
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
                    model.setValueAt(status, Integer.valueOf(row) - 1, letterToNumber(col));
                }
            } else if (command.equals("WIN")) {
                LoggingService.logging("Вы выиграли!", Logs, MY_NAME);
                IsConnect = false;
            } else if (command.equals("LOSE")) {
                LoggingService.logging("Вы проиграли!", Logs, MY_NAME);
                IsConnect = false;
            } else if (command.equals("DRAW")) {
                LoggingService.logging("Ничья!", Logs, MY_NAME);
                IsConnect = false;
            } else if (command.equals("SC")) {
                LoggingService.logging("Сервер недоступен", Logs, MY_NAME);
                IsConnect = false; // как то нужно сообщить об этом классу выше
            } else if (command.equals("WC")) {
                LoggingService.logging("Невалидная команда!", Logs, MY_NAME);
            }
        } catch (Exception ex) {
            Logger.getLogger(CommandsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void handleEnemyCommand(ServerResponseDto serverResponseDto, String whoseTurn) {

        String command = "";
        command = serverResponseDto.getCommand();

        if (command.equals("CA") || command.equals("KTI") || command.equals("KTO")) {
            String command_coord = serverResponseDto.getCommandCoord();
            String row = getSubstringOfGameCommand(command_coord, ":", 0);
            String col = getSubstringOfGameCommand(command_coord, ":", 1);

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            if (command.equals("CA")) {
                if (whoseTurn.equals(CROSS_VIRUS)) {
                    model.setValueAt("X", Integer.valueOf(row) - 1, letterToNumber(col));
                } else {
                    model.setValueAt("O", Integer.valueOf(row) - 1, letterToNumber(col));
                }
            } else if (command.equals("KTI")) {
                model.setValueAt("KillX", Integer.valueOf(row) - 1, letterToNumber(col));
            } else {
                model.setValueAt("KillO", Integer.valueOf(row) - 1, letterToNumber(col));
            }
        }
    }
}
