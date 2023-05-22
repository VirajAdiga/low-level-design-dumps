package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RiderMgr {
    private static RiderMgr riderMgrInstance;
    private static final Lock mtx = new ReentrantLock();
    private final Map<String, Rider> ridersMap;

    private RiderMgr() {
        ridersMap = new HashMap<>();
    }

    public static RiderMgr getRiderMgr() {
        if (riderMgrInstance == null) {
            mtx.lock();
            if (riderMgrInstance == null) {
                riderMgrInstance = new RiderMgr();
            }
            mtx.unlock();
        }
        return riderMgrInstance;
    }

    public void addRider(String pRiderName, Rider pRider) {
        ridersMap.put(pRiderName, pRider);
    }

    public Rider getRider(String pRiderName) {
        return ridersMap.get(pRiderName);
    }
}
