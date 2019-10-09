package Class;


import java.util.ArrayList;
import java.util.Calendar;
import Enum.SeatClass;
import Interface.IAirline;

public class Airline implements IAirline {
    private String name;
    private ArrayList<Flight> flightList;
    private ArrayList<FlightSection> sectionList;

    public Airline(String name) {
        this.name = name;
        flightList = new ArrayList<Flight>();
        sectionList = new ArrayList<FlightSection>();
    }

    public String getName(){
        return name;
    }

    public ArrayList<Flight> getFlightList(){
        return flightList;
    }

    @Override
    public Flight createFlight(String orig, String dest, Calendar date, String id) {
        Flight flight = new Flight(orig, dest, date, id);
        flightList.add(flight);
        return flight;
    }

    @Override
    public Flight findFlight(String n) {
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getID() == n) {
                return flightList.get(i);
            }
        }
        System.out.println("Flight not found");
        return null;
    }
    @Override
    //Get available flights between 2 airports
    public ArrayList<Flight> getAvailableFlights(Airport orig, Airport dest) {
        ArrayList<Flight> availableFlightList = new ArrayList<Flight>();
        for (int i = 0; i < flightList.size(); i++) {
            if (flightList.get(i).getOrig() == orig.getName() && flightList.get(i).getDest() == dest.getName() && flightList.get(i).hasSeats()) {
                availableFlightList.add(flightList.get(i));
            }
        }
        return availableFlightList;
    }

    @Override
    public boolean bookFlight(String fl, SeatClass s, int row, char col) {
        for (int i = 0; i < flightList.size(); i++ ){
            if (flightList.get(i).getID() == fl){
                flightList.get(i).bookSeat(s, row, col);
            }
        }
        System.out.println("FlightID not found");
        return false;
    }

    @Override
    public void createSection(String flID, int rows, int cols, SeatClass s) {
        boolean found = false;
        for (int i = 0; i < flightList.size(); i++){
            if (flightList.get(i).getID() == flID ){
                found = true;
                flightList.get(i).createSection(rows, cols, s);
            }
        }
        if (found = false){
            System.out.println("FlightID not found");
        }

}
}




