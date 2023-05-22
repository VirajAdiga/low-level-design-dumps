package lld;

public class StrategyMgr {
    private static StrategyMgr strategyMgrInstance = null;
    private static Object lock = new Object();

    private StrategyMgr() {}

    public static StrategyMgr getStrategyMgr() {
        if (strategyMgrInstance == null) {
            synchronized(lock) {
                if (strategyMgrInstance == null) {
                    strategyMgrInstance = new StrategyMgr();
                }
            }
        }
        return strategyMgrInstance;
    }

    public PricingStrategy determinePricingStrategy(TripMetadata metaData) {
        System.out.println("Based on location and other factors, setting pricing strategy");
        return new DefaultPricingStrategy();
    }

    public DriverMatchingStrategy determineMatchingStrategy(TripMetadata metaData) {
        System.out.println("Based on location and other factors, setting matching strategy");
        return new LeastTimeBasedMatchingStrategy();
    }
}
