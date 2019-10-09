package Interface;

import java.util.ArrayList;
import java.util.Calendar;
import Enum.SeatClass;
import Class.Flight;
import Class.Airport;

public interface IAirline {

    public Flight createFlight(String orig, String dest, Calendar date, String id);

    public Flight findFlight(String n);

    public ArrayList<Flight> getAvailableFlights(Airport orig, Airport dest);
    public boolean bookFlight(String fl, SeatClass s, int row, char cols);

    public void createSection(String flID, int rows, int cols, SeatClass s);
}
