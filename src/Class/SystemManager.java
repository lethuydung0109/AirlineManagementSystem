package Class;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import Enum.SeatClass;
import Interface.ISystemManager;
import com.sun.source.tree.IfTree;
import Exception.AirportExisted;
import Exception.InvalidName;

public class SystemManager implements ISystemManager {

    private ArrayList<Airline> airlinesList;
    private ArrayList<Airport> airportsList;

    public SystemManager(){

        this.airlinesList= new ArrayList<Airline>();
        this.airportsList = new ArrayList<Airport>();
    }

    @Override
    public void createAirport(String code) {
        boolean found = false;
        if (code.length() != 3) {
            System.out.println(code + " est invalid name");
        } else {
            if (airportsList.size() == 0){
                airportsList.add(new Airport(code));
            } else{
                for (int i = 0; i < airportsList.size(); i++){
                    if (airportsList.get(i).getName() == code){
                        System.out.println(airportsList.get(i).getName() + " existed");
                        found = true;
                        break;
                    }
                }
                if (found == false){
                    airportsList.add(new Airport(code));
                }
            }
        }
    }

    @Override
    public void createAirline(String name){
        boolean found = false;
        if (airlinesList.size() == 0){
            airlinesList.add(new Airline(name));
        } else{
            for (int i = 0; i < airlinesList.size(); i++){
                if (airlinesList.get(i).getName() == name){
                    System.out.println(name + "existed");
                    found = true;
                    break;
                }
            }
            if (found == false){
                airlinesList.add(new Airline(name));
            }
        }
    }

    @Override
    public void createFlight(String n, String orig, String dest, int year, int month, int day, String flightID) {
        boolean origFound = false;
        for (int i = 0; i < airportsList.size(); i++) {
            if (airportsList.get(i).getName() == orig) {
                origFound = true;
                break;
            }
        }

        boolean destFound = false;
        for (int i = 0; i < airportsList.size(); i++) {
            if (airportsList.get(i).getName() == orig) {
                destFound = true;
                break;
            }
        }

        boolean airlineFound = false;
        if (origFound == true && destFound == true) {
            for (int i = 0; i < airlinesList.size(); i++) {
                if (airlinesList.get(i).getName() == n) {
                    Calendar calendartmp = new GregorianCalendar(year, month - 1, day);
                    Flight newFlight = airlinesList.get(i).createFlight(orig, dest, calendartmp, flightID);
                    airlineFound = true;
                    break;
                }
            }
            if (airlineFound == false) {
                System.out.println("Airline not found");
            }
        } else {
            System.out.println("Orig or Dest airport not found");
        }
    }


    @Override
    public void createSection(String air, String flID, int rows, int cols, SeatClass s) {
        boolean found = false;
        for (int i = 0; i < airlinesList.size(); i++){
            if (airlinesList.get(i).getName() == air){
                airlinesList.get(i).createSection(flID, rows, cols, s);
                found = true;
                break;
            }
        }
        if (found == false){
            System.out.println("Airline not found");
        }
    }

    @Override
    public ArrayList<Flight> findAvailableFlights(Airport orig, Airport dest) {
        ArrayList<Flight> availableFlightList = new ArrayList<Flight>();
        for (int i = 0; i < airlinesList.size(); i++){
            ArrayList<Flight> availableFlightsListTmp = airlinesList.get(i).getAvailableFlights(orig, dest);
            for (int j = 0; j < availableFlightsListTmp.size(); j++){
                availableFlightList.add(availableFlightsListTmp.get(j));
            }
        }
        return availableFlightList;
    }

    @Override
    public boolean bookSeat(String air, String fl, SeatClass s, int row, char col) {
        boolean booked = false;
        for (int i = 0; i < airlinesList.size(); i++){
            if (airlinesList.get(i).getName() == air){
                booked = airlinesList.get(i).bookFlight(fl, s, row, col);
                break;
            }
        }
        return booked;
    }

    @Override
    public void displaySystemDetails() {
        System.out.println("List of airlines:");
        for (int i = 0; i < airlinesList.size(); i++){
            System.out.println(airlinesList.get(i).getName());
        }
        System.out.println("List of airport:");
        for (int i = 0; i < airportsList.size(); i++){
            System.out.println(airportsList.get(i).getName());
        }
    }
}
