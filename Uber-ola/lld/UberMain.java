package lld;

import java.util.*;

public class UberMain {
    public static void main(String[] args) {

        //---------------Creating Riders and Drivers--------------------------------
        Rider keertiRider = new Rider("Keerti", RATING.FIVE_STARS);
        Rider gauravRider = new Rider("Gaurav", RATING.FIVE_STARS);
        RiderMgr riderMgr = RiderMgr.getRiderMgr();
        riderMgr.addRider("keerti", keertiRider);
        riderMgr.addRider("gaurav", gauravRider);

        Driver yogitaDriver = new Driver("Yogita", RATING.THREE_STARS);
        Driver riddhiDriver = new Driver("Riddhi", RATING.FOUR_STARS);
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        driverMgr.addDriver("yogita", yogitaDriver);
        driverMgr.addDriver("riddhi", riddhiDriver);

        //These details in turn will be stored in database
        //-------------------------------------------------------------------------

        TripMgr tripMgr = TripMgr.getTripMgr();

        System.out.println("\nCreating lld.Trip for Keerti from location (10,10) to (30,30)\n");
        tripMgr.CreateTrip(keertiRider, new Location(10, 10), new Location(30, 30));

        System.out.println("\nCreating lld.Trip for Gaurav from location (200,200) to (500,500)\n");
        tripMgr.CreateTrip(gauravRider, new Location(200, 200), new Location(500, 500));

        //-------------------Display all the trips created--------------------------
        HashMap<Integer, Trip> tripsMap = (HashMap<Integer, Trip>) tripMgr.getTripsMap();
        for (Map.Entry<Integer, Trip> mapVal : tripsMap.entrySet()) {
            mapVal.getValue().displayTripDetails();
        }
    }
}

