package Interface;

import java.util.ArrayList;

import  Enum.SeatClass;
import Class.Airport;
import Class.Flight;
import Exception.AirportExisted;
import Exception.InvalidName;

public interface ISystemManager {
    public void createAirport(String code) throws AirportExisted, InvalidName;
    public void createAirline(String n);
    public void createFlight(String n, String orig, String dest, int year, int month, int day, String flightID);

    public void createSection(String air, String flID, int row, int cols, SeatClass s);


    public ArrayList<Flight> findAvailableFlights(Airport orig, Airport dest);

    public boolean bookSeat(String air, String fl, SeatClass s, int row, char col);
    public void displaySystemDetails();
}
