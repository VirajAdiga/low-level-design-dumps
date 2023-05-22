package lld;

import java.util.Map;

public class LeastTimeBasedMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver matchDriver(TripMetadata pMetaData) {
        DriverMgr driverMgr = DriverMgr.getDriverMgr();
        Map<String, Driver> driversMap = driverMgr.getDriversMap();

        if (driversMap.size() == 0) {
            System.out.println("No drivers! What service is this huh?");
        }
        System.out.println("Using quadtree to see nearest cabs, using driver manager to get details of drivers and send notifications");
        Driver driver = driversMap.values().iterator().next(); // here we can call quadtree algo to get nearest cabs
        System.out.println("Setting " + driver.getDriverName() + " as driver");
        pMetaData.setDriverRating(driver.getRating());
        return driver;
    }
}
