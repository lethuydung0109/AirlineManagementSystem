package Class;

import Interface.ISeatID;

public class SeatID implements ISeatID {
    private int row;
    private char column;

    public SeatID(int row, char column){
        this.row = row;
        this.column = column;
    }
}
