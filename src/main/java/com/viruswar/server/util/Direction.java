package com.viruswar.server.util;

public class Direction {
    public boolean isDiscovered;
    public int row;
    public int column;

    public Direction() {
        this.row = -1;
        this.column = -1;
    }
    public void clearDirect() {
        this.isDiscovered = false;
        this.row = -1;
        this.column = -1;
    }
}
