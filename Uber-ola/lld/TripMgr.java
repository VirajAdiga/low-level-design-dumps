package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TripMgr {
    private static volatile TripMgr tripMgrInstance = null;
    private static Lock mtx = new ReentrantLock();
    private RiderMgr riderMgr;
    private DriverMgr driverMgr;
    private Map<Integer, TripMetadata> tripsMetaDataInfo;
    private Map<Integer, Trip> tripsInfo;

    private TripMgr() {
        riderMgr = RiderMgr.getRiderMgr();
        driverMgr = DriverMgr.getDriverMgr();
        tripsMetaDataInfo = new HashMap<Integer, TripMetadata>();
        tripsInfo = new HashMap<Integer, Trip>();
    }

    public static TripMgr getTripMgr() {
        if (tripMgrInstance == null) {
            mtx.lock();
            if (tripMgrInstance == null) {
                tripMgrInstance = new TripMgr();
            }
            mtx.unlock();
        }
        return tripMgrInstance;
    }

    public void CreateTrip(Rider pRider, Location pSrcLoc, Location pDstLoc) {
        TripMetadata metaData = new TripMetadata(pSrcLoc, pDstLoc, pRider.getRating());
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        PricingStrategy pricingStrategy = strategyMgr.determinePricingStrategy(metaData);
        DriverMatchingStrategy driverMatchingStrategy = strategyMgr.determineMatchingStrategy(metaData);

        Driver driver = driverMatchingStrategy.matchDriver(metaData);
        double tripPrice = pricingStrategy.calculatePrice(metaData);

        Trip trip = new Trip(pRider, driver, pSrcLoc, pDstLoc, tripPrice, pricingStrategy, driverMatchingStrategy);
        int tripId = trip.getTripId();
        tripsInfo.put(tripId, trip);
        tripsMetaDataInfo.put(tripId, metaData);
    }

    public Map<Integer, Trip> getTripsMap() {
        return tripsInfo;
    }
}

