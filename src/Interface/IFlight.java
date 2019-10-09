package Interface;

import java.util.Calendar;
import Enum.SeatClass;
import Class.FlightSection;

public interface IFlight {


    public String getID();
    public String getOrig();
    public String getDest();
    public Calendar getDate();


    public boolean hasSection(SeatClass s);
    public boolean hasSeats();
    public boolean createSection(int nbRows, int nbCols, SeatClass s);
    public FlightSection findSection(SeatClass s);

    //Book a specific seat
    boolean bookSeat(SeatClass s, int row, char col);
}
