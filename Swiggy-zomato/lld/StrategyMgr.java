package lld;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance = null;
    private static Lock mtx = new ReentrantLock();

    private StrategyMgr() {}

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null) {
            mtx.lock();
            if (strategyMgrInstance == null) {
                strategyMgrInstance = new StrategyMgr();
            }
            mtx.unlock();
        }
        return strategyMgrInstance;
    }

    public IDeliveryPartnerMatchingStrategy determineDeliveryPartnerMatchingStrategy(DeliveryMetadata metaData) {
        System.out.println("Based on location, weather and other factors, setting partner strategy");
        return new LocationBasedDeliveryPartnerMatchingStrategy();
    }
}

