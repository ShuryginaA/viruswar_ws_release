package com.viruswar.server.util;

import java.util.*;

import static com.viruswar.server.Server.CROSS_VIRUS;
import static com.viruswar.server.Server.ROUND_VIRUS;

public class GameFieldService {

    public enum CELL_STATE {
        CELL_EMPTY,
        CROSS_HERE,
        ROUND_HERE,
        CROSS_KILLED,
        ROUND_KILLED;

        CELL_STATE() {
        }
    }

    public static final String[] rows = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    public static final String[] colums = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "k"};
    public static final ArrayList<Integer> trickyCellCoordCross
            = new ArrayList<>(Arrays.asList(2, 7, 13, 16, 22, 27));
    public static final ArrayList<Integer> trickyCellCoordRound
            = new ArrayList<>(Arrays.asList(4, 10, 13, 19, 24, 29, 34));
    public static final int NUM_OF_COLUMNS = 10;
    public static final Map<String, Map<String, CELL_STATE>> GAME_STATE_INIT;
    public static CellDirects[][] directions;

    public GameFieldService() {
    }

    public static void clearDirects() {
        int j=0;
        for (int i = 0; i < 10; ++i) {
            while(j<10){
                directions[i][j].clearCellDirects();
                j++;
            }
        }
    }

    public static void pourDirectsForCell(String group_name, int row, int col, Map<String, Map<String, GameFieldService.CELL_STATE>> game_state) {
        int iterator = -1;
        int i, j;
        if (group_name.equalsIgnoreCase(CROSS_VIRUS)) {
            for (i = row - 1; i <= row + 1; ++i) {
                for (j = col - 1; j <= col + 1; ++j) {
                    if (i != row || j != col) {
                        iterator++;
                    }

                    if ((i != row || j != col) && i > 0 && i <= 10 && j >= 0 && j < 10 && (((Map) game_state.get(Integer.toString(i))).get(colums[j])).equals(GameFieldService.CELL_STATE.ROUND_KILLED)) {
                        directions[row - 1][col].directions[iterator].row = i;
                        directions[row - 1][col].directions[iterator].column = j;
                    }
                }
            }
        } else if (group_name.equalsIgnoreCase(ROUND_VIRUS)) {
            for (i = row - 1; i <= row + 1; ++i) {
                for (j = col - 1; j <= col + 1; ++j) {
                    if (i != row || j != col) {
                        iterator++;
                    }
                }
            }
        }

        directions[row - 1][col].DirectedWasCalced = true;
    }

    public static boolean isDirectExist(int row, int col) {
        for (int i = 0; i < 8; ++i) {
            if (directions[row - 1][col].directions[i].row > 0 && directions[row - 1][col].directions[i].column > 0 && !directions[row - 1][col].directions[i].isDiscovered) {
                return true;
            }
        }

        directions[row - 1][col].AllDirectsDiscovered = true;
        return false;
    }

    public static Direction getExistDirect(int row, int col) {
        for (int i = 0; i < 8; ++i) {
            if (directions[row - 1][col].directions[i].row > 0 && directions[row - 1][col].directions[i].column > 0 && !directions[row - 1][col].directions[i].isDiscovered) {
                directions[row - 1][col].directions[i].isDiscovered = true;
                return directions[row - 1][col].directions[i];
            }
        }

        return new Direction();
    }

    static {
        Map<String, Map<String, GameFieldService.CELL_STATE>> duplicate_GAME_STATE_INIT = new HashMap();
        for (int i = 0; i < 10; ++i) {
            Map<String, GameFieldService.CELL_STATE> itemOfGameStateInit = new HashMap();

            for (int j = 0; j < 10; ++j) {
                itemOfGameStateInit.put(colums[j], GameFieldService.CELL_STATE.CELL_EMPTY);
            }

            duplicate_GAME_STATE_INIT.put(rows[i], itemOfGameStateInit);
        }

        ((Map) duplicate_GAME_STATE_INIT.get("1")).replace("a", GameFieldService.CELL_STATE.CROSS_HERE);
        ((Map) duplicate_GAME_STATE_INIT.get("10")).replace("k", GameFieldService.CELL_STATE.ROUND_HERE);
        GAME_STATE_INIT = Collections.unmodifiableMap(duplicate_GAME_STATE_INIT);
        directions = new CellDirects[10][10];

        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < 10; ++j) {
                CellDirects c = new CellDirects();
                directions[i][j] = c;
            }
        }

    }
}

