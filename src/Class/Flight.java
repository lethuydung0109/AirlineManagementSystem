package Class;

import Interface.IFlight;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import Enum.SeatClass;

public class Flight implements IFlight {
    private Calendar flightDate;
    private String flightID;
    private String orig;
    private String dest;
    private ArrayList<FlightSection> sectionList;

    public Flight(String orig, String dest, int year, int month, int day, String flightID){
        this.flightDate = new GregorianCalendar(year, month, day);
        this.flightID = flightID;
        this.orig = orig;
        this.dest = dest;
        this.sectionList = new ArrayList<FlightSection>();
    }

    public Flight(String orig, String dest, Calendar date, String id) {
        this.flightDate = date;
        this.flightID = id;
        this.orig = orig;
        this.dest = dest;
    }


    @Override
    public String getID() {
        return flightID;
    }

    @Override
    public String getOrig() {
        return orig;
    }

    @Override
    public String getDest() {
        return dest;
    }

    @Override
    public Calendar getDate() {
        return flightDate;
    }

    @Override
    //Check if a flight has a section
    public boolean hasSection(SeatClass s) {
        //Search if a section exists
        for (int i = 0; i < sectionList.size(); i++){
            if (sectionList.get(i).getSeatClass() == s){
                return true;
            }
        }
        return false;
    }

    @Override
    //Check if a flight has available seats
    public boolean hasSeats() {
        //Check if a section has any available seat
        for (int i = 0; i < sectionList.size(); i++){
            if (sectionList.get(i).hasAvailableSeats()){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean createSection(int nbRows, int nbCols, SeatClass s) {
        //Check if section exists
        if (hasSection(s)){
            //If yes, print the message
            System.out.println("Section already existed");
            return false;
        } else{
            //If no, create the flight
            FlightSection section =  new FlightSection(nbRows, nbCols, s);
            sectionList.add(section);
        }
        return true;
    }

    @Override
    //Return a flight section if it exists
    public FlightSection findSection(SeatClass s) {
        for (int i = 0; i < sectionList.size(); i++){
            if (sectionList.get(i).getSeatClass() == s){
                return sectionList.get(i);
            }
        }
        System.out.println("Section not found");
        return null;
    }

    @Override
    //Book a specific seat
    public boolean bookSeat(SeatClass s, int row, char col){
        for (int i = 0; i < sectionList.size(); i++){
            if (sectionList.get(i).getSeatClass() == s){
                sectionList.get(i).bookSeat();
            }
        }
        System.out.println("Section not found");
        return false;
    }
}
