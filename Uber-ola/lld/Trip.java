package lld;

public class Trip {
    private Rider rider;
    private Driver driver;
    private Location srcLoc;
    private Location dstLoc;
    private TRIP_STATUS status;
    private int tripId;
    private double price;
    private PricingStrategy pricingStrategy;
    private DriverMatchingStrategy driverMatchingStrategy;

    private static int nextTripId = 1;

    public Trip(Rider rider, Driver driver, Location srcLoc, Location dstLoc, double price,
                PricingStrategy pricingStrategy, DriverMatchingStrategy driverMatchingStrategy) {
        this.rider = rider;
        this.driver = driver;
        this.srcLoc = srcLoc;
        this.dstLoc = dstLoc;
        this.price = price;
        this.pricingStrategy = pricingStrategy;
        this.driverMatchingStrategy = driverMatchingStrategy;
        this.status = TRIP_STATUS.DRIVER_ON_THE_WAY;
        this.tripId = nextTripId;
        nextTripId++;
    }

    public int getTripId() {
        return tripId;
    }

    public void displayTripDetails() {
        System.out.println();
        System.out.println("lld.Trip id - " + tripId);
        System.out.println("lld.Rider - " + rider.getRiderName());
        System.out.println("lld.Driver - " + driver.getDriverName());
        System.out.println("Price - " + price);
        System.out.println("Locations - " + srcLoc.getLatitude() + "," + srcLoc.getLongitude() +
                " and " + dstLoc.getLatitude() + "," + dstLoc.getLongitude());
    }
}
