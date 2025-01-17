package com.viruswar.server.util;

import java.util.Map;
import java.util.Stack;

import static com.viruswar.server.Server.CROSS_VIRUS;
import static com.viruswar.server.Server.ROUND_VIRUS;

public class GameRulesService {
    public static int num_turn = 0;
    private static Stack<CellCoordinates> cells_bypass = new Stack();
    private static String group_active = CROSS_VIRUS;

    public GameRulesService() {
    }

    public static GameFieldService.CELL_STATE getValue(String row, String col, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        return (GameFieldService.CELL_STATE)((Map)GameState.get(row)).get(col);
    }

    public static void killCross(String row, String col, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        processKill(row, col, GameState, GameFieldService.CELL_STATE.CROSS_KILLED);
    }

    public static void killRound(String row, String col, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        processKill(row, col, GameState, GameFieldService.CELL_STATE.ROUND_KILLED);
    }

    public static void occupyCell(String row, String col, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState, String group_name) {
        if (group_name.equals(CROSS_VIRUS)) {
            processKill(row, col, GameState,GameFieldService.CELL_STATE.CROSS_HERE);
        } else {
            processKill(row, col, GameState,GameFieldService.CELL_STATE.ROUND_HERE);
        }

    }

    public static void processKill(String row, String col, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState, GameFieldService.CELL_STATE cellState){
        ((Map)GameState.get(row)).replace(col, cellState);

    }

    private static String InvertGroup(String _group_name) {
        return _group_name.equals(CROSS_VIRUS) ? ROUND_VIRUS : CROSS_VIRUS;
    }

    private static boolean AccesibleCellExist() {
        return true;
    }

    public static boolean checkGameEnded(Integer num_cross, Integer num_rounds) {
        return num_cross == 0 || num_rounds == 0;
    }

    public static boolean isCellAccessible(String group_name, String row, String column, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        if (group_name.equals(CROSS_VIRUS)) {
            return isCellAccessibleForCross(row, column, GameState);
        } else {
            return group_name.equals(ROUND_VIRUS) && isCellAccessibleForRound(row, column, GameState);
        }
    }

    public static boolean isCellAccessibleForCross(String row, String column, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        int row_int = Integer.parseInt(row);
        int column_int = letterToNumber(column);

        for(int i = row_int - 1; i <= row_int + 1; ++i) {
            for(int j = column_int - 1; j <= column_int + 1; ++j) {
                if ((i != row_int || j != column_int) && i > 0 && i <= 10 && j >= 0 && j < 10) {
                    String curr_row = Integer.toString(i);
                    String curr_column = numberToLetter(j);
                    if ((((Map)GameState.get(curr_row)).get(curr_column)).equals(GameFieldService.CELL_STATE.CROSS_HERE) && (((GameFieldService.CELL_STATE)((Map)GameState.get(row)).get(column)).equals(GameFieldService.CELL_STATE.CELL_EMPTY) || ((GameFieldService.CELL_STATE)((Map)GameState.get(row)).get(column)).equals(GameFieldService.CELL_STATE.ROUND_HERE))) {
                        return true;
                    }
                }
            }
        }

        return moveOverKilledRound(row, column, GameState);
    }

    public static boolean isCellAccessibleForRound(String row, String column, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        int row_int = Integer.parseInt(row);
        int column_int = letterToNumber(column);

        for(int i = row_int - 1; i <= row_int + 1; ++i) {
            for(int j = column_int - 1; j <= column_int + 1; ++j) {
                if ((i != row_int || j != column_int) && i > 0 && i <= 10 && j >= 0 && j < 10) {
                    String curr_row = Integer.toString(i);
                    String curr_column = numberToLetter(j);
                    if ((((Map)GameState.get(curr_row)).get(curr_column)).equals(GameFieldService.CELL_STATE.ROUND_HERE) && (((GameFieldService.CELL_STATE)((Map)GameState.get(row)).get(column)).equals(GameFieldService.CELL_STATE.CELL_EMPTY) || ((GameFieldService.CELL_STATE)((Map)GameState.get(row)).get(column)).equals(GameFieldService.CELL_STATE.CROSS_HERE))) {
                        return true;
                    }
                }
            }
        }

        return moveOverKilledCross(row, column, GameState);
    }

    public static boolean checkCross(String row, String column, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        int row_int = Integer.parseInt(row);
        int column_int = letterToNumber(column);

        for(int i = row_int - 1; i <= row_int + 1; ++i) {
            for(int j = column_int - 1; j <= column_int + 1; ++j) {
                if ((i != row_int || j != column_int) && i > 0 && i <= 10 && j >= 0 && j < 10) {
                    String currentRow = Integer.toString(i);
                    String currentColumn = numberToLetter(j);
                    if ((((Map)GameState.get(currentRow)).get(currentColumn)).equals(GameFieldService.CELL_STATE.CROSS_HERE)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean checkRound(String row, String column, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        int rowInt = Integer.parseInt(row);
        int columnInt = letterToNumber(column);
        for(int i = rowInt - 1; i <= rowInt + 1; i++) {
            for(int j = columnInt - 1; j <= columnInt + 1; j++) {
                boolean condition = (i != rowInt || j != columnInt) && i > 0 && i <= 10 && j >= 0 && j < 10;
                if (condition) {
                    String currColumn = numberToLetter(j);
                    String currRow = Integer.toString(i);
                    boolean secondCondition = ((GameState.get(currRow)).get(currColumn)).equals(GameFieldService.CELL_STATE.ROUND_HERE);
                    if (secondCondition) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static boolean moveOverKilledRound(String row, String column, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        int rowInt = Integer.parseInt(row);
        int columnInt = letterToNumber(column);
        CellCoordinates CC = new CellCoordinates();
        cells_bypass.push(CC);

        CC.row = rowInt;
        CC.col = columnInt;

        while(!cells_bypass.empty()) {
            CC = cells_bypass.peek();
            rowInt = CC.row;
            columnInt = CC.col;
            if (!GameFieldService.directions[rowInt - 1][columnInt].DirectedWasCalced) {
                GameFieldService.pourDirectsForCell(CROSS_VIRUS, rowInt, columnInt, GameState);
            }

            if (GameFieldService.isDirectExist(rowInt, columnInt)) {
                Direction curr_direction = GameFieldService.getExistDirect(rowInt, columnInt);
                if (checkCross(Integer.toString(curr_direction.row), numberToLetter(curr_direction.column), GameState)) {
                    GameFieldService.clearDirects();
                    return true;
                }
                CellCoordinates C = new CellCoordinates();
                C.col = curr_direction.column;
                C.row = curr_direction.row;
                cells_bypass.push(C);
            } else {
                cells_bypass.remove(CC);
            }
        }
        GameFieldService.clearDirects();
        return false;
    }

    public static boolean moveOverKilledCross(String row, String column, Map<String, Map<String, GameFieldService.CELL_STATE>> GameState) {
        CellCoordinates cellCoordinates = new CellCoordinates();
        int column_int = letterToNumber(column);
        int row_int = Integer.parseInt(row);
        cellCoordinates.col = column_int;
        cellCoordinates.row = row_int;
        cells_bypass.push(cellCoordinates);

        while(!cells_bypass.empty()) {
            cellCoordinates = cells_bypass.peek();
            row_int = cellCoordinates.row;
            column_int = cellCoordinates.col;
            if (!GameFieldService.directions[row_int - 1][column_int].DirectedWasCalced) {
                GameFieldService.pourDirectsForCell(ROUND_VIRUS, row_int, column_int, GameState);
            }

            if (GameFieldService.isDirectExist(row_int, column_int)) {
                Direction curr_direction = GameFieldService.getExistDirect(row_int, column_int);
                System.out.println(curr_direction.row);
                System.out.println(curr_direction.column);
                if (checkRound(Integer.toString(curr_direction.row), numberToLetter(curr_direction.column), GameState)) {
                    GameFieldService.clearDirects();
                    return true;
                }

                CellCoordinates C = new CellCoordinates();
                C.row = curr_direction.row;
                C.col = curr_direction.column;
                cells_bypass.push(C);
            } else {
                cells_bypass.remove(cellCoordinates);
            }
        }

        GameFieldService.clearDirects();
        return false;
    }

    public static int letterToNumber(String column) {
        int i =0;
        while (i < 10){
            if (GameFieldService.colums[i].equals(column)) {
                return i;
            }
            i++;
        }
        return 0;
    }

    public static String numberToLetter(int num) {
        System.out.println(num);
        System.out.println(GameFieldService.colums[num]);
        return GameFieldService.colums[num];
    }

    public static String findWhoseTurn() {
        if (num_turn < 3 && AccesibleCellExist()) {
            return group_active;
        } else if (AccesibleCellExist()) {
            num_turn = 0;
            group_active = InvertGroup(group_active);
            return group_active;
        } else {
            return "DRAW";
        }
    }
}

