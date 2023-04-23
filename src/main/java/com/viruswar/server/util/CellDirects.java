package com.viruswar.server.util;

public class CellDirects {
    public Direction[] directions = new Direction[8];
    public boolean AllDirectsDiscovered = false;
    public boolean DirectedWasCalced = false;

    CellDirects() {
        for(int i = 0; i < 8; ++i) {
            this.directions[i] = new Direction();
        }

    }

    public void clearCellDirects() {
        for(int i = 0; i < 8; ++i) {
            this.directions[i].clearDirect();
        }

        this.AllDirectsDiscovered = false;
        this.DirectedWasCalced = false;
    }
}
