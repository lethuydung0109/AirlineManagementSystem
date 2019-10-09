package Interface;
import Enum.SeatClass;
import Class.SeatID;
import Class.Seat;

import java.util.ArrayList;

public interface IFlightSection {
    public SeatClass getSeatClass();
    public ArrayList<Seat> getAvailableSeatList();
    public ArrayList<Seat> getBookedSeatList();
    public boolean hasAvailableSeats();
    public boolean bookSeat();
    //Book the Seat identified by sID
    boolean bookSeat(SeatID sID);
}
