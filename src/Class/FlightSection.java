package Class;

import Enum.SeatClass;
import Interface.IFlightSection;

import java.util.ArrayList;

public class FlightSection implements IFlightSection {

    private int nbRows;
    private int nbCols;
    private SeatClass s;
    private ArrayList<Seat> availableSeatList;
    private ArrayList<Seat> bookedSeatList;

    public FlightSection(int nbRows, int nbCols, SeatClass s){
        this.s = s;
        this.nbRows = nbRows;
        this.nbCols = nbCols;
        this.availableSeatList = new ArrayList<Seat>();
        this.bookedSeatList = new ArrayList<Seat>();
    }

    public int getNbSeats(int nbRows, int nbCols){
        return nbRows*nbCols;
    }

    @Override
    public SeatClass getSeatClass() {
        return s;
    }

    @Override
    public ArrayList<Seat> getAvailableSeatList() {
        return this.availableSeatList;
    }

    @Override
    public ArrayList<Seat> getBookedSeatList() {
        return this.bookedSeatList;
    }


    @Override
    public boolean hasAvailableSeats() {
        if (availableSeatList.size() > 0)
            return true;
        else
            return false;
    }

    @Override
    //Book the first available seat
    public boolean bookSeat() {
        //Check if there is any available seat
        if (hasAvailableSeats()){
            //If yes, reserve the first available one
            //Change the status of the seat
            availableSeatList.get(1).setStatus(true);
            //Add the seat tto the booked list
            bookedSeatList.add(availableSeatList.get(1));
            //Remove the seat from the available list
            availableSeatList.remove(1);
            return true;
        } else {
            // If no, print the message
            System.out.println("No available seat");
            return false;
        }
    }

    @Override
    //Book the Seat identified by sID
    public boolean bookSeat(SeatID sID){
        boolean booked = false;
        //Search for the sID
        for (int i = 0; i < availableSeatList.size(); i++){
            if (availableSeatList.get(i).getSeatNum() == sID){
                //If the Seat was not booked
                if (!availableSeatList.get(i).getStatus()){
                    //Book the seat
                    availableSeatList.get(i).setStatus(true);
                    //Add the seat to the booked list
                    bookedSeatList.add(availableSeatList.get(i));
                    //Remove the seat from the available list
                    availableSeatList.remove(i);
                    booked = true;
                    break;
                } else{
                    //If the seat is booked, print the message
                    System.out.println("Seat already booked");
                }
            }
        }
        //If the seat is not found, print the message
        System.out.println("Seat not found");
        return booked;
    }
}
