package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DriverMgr {
    private static DriverMgr driverMgrInstance = null;
    private static Lock mtx = new ReentrantLock();
    private Map<String, Driver> driversMap;

    private DriverMgr() {
        driversMap = new HashMap<>();
    }

    public static DriverMgr getDriverMgr() {
        if (driverMgrInstance == null) {
            mtx.lock();
            if (driverMgrInstance == null) {
                driverMgrInstance = new DriverMgr();
            }
            mtx.unlock();
        }
        return driverMgrInstance;
    }

    public void addDriver(String pDriverName, Driver pDriver) {
        driversMap.put(pDriverName, pDriver);
    }

    public Driver getDriver(String pDriverName) {
        return driversMap.get(pDriverName);
    }

    public Map<String, Driver> getDriversMap() {
        return driversMap;
    }
}
