package Class;


import Interface.ISeat;

public class Seat implements ISeat {
    private SeatID seatNum;
    private Boolean isBooked;

    public void Seat(SeatID seatNum){
        this.seatNum = seatNum;
        this.isBooked = false;
    }
    @Override
    public SeatID getSeatNum() {
        return seatNum;
    }

    @Override
    public Boolean getStatus() {
        return null;
    }

    @Override
    public void setStatus(boolean status) {
        isBooked = true;
    }
}
