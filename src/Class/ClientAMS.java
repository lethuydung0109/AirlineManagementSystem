package Class;
import Exception.InvalidName;
import Exception.AirportExisted;

public class ClientAMS {
    public static void main(String[] args) {
        SystemManager res = new SystemManager();

        //Airport

        res.createAirport("DEN");
        res.createAirport("DFW");
        res.createAirport("LON");
        res.createAirport("DEN");
        res.createAirport("CDG");
        res.createAirport("JPN");
        res.createAirport("DEN");
        res.createAirport("DE");
        res.createAirport("DEH");
        res.createAirport("DRIdrn3");

        //Airline

        res.createAirline("DELTA");
        res.createAirline("AIRFR");
        res.createAirline("AMER");
        res.createAirline("JET");
        res.createAirline("DELTA");
        res.createAirline("SWEST");
        res.createAirline("FRONTIER");

        res.displaySystemDetails();

    }

}

