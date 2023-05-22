package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeliveryPartnerMgr {
    private static volatile DeliveryPartnerMgr deliveryPartnerMgrInstance;
    private static Lock mtx = new ReentrantLock();
    private Map<String, DeliveryPartner> deliveryPartnersMap = new HashMap<>();

    private DeliveryPartnerMgr() {}

    public static DeliveryPartnerMgr getDeliveryPartnerMgr() {
        if (deliveryPartnerMgrInstance == null) {
            mtx.lock();
            if (deliveryPartnerMgrInstance == null) {
                deliveryPartnerMgrInstance = new DeliveryPartnerMgr();
            }
            mtx.unlock();
        }
        return deliveryPartnerMgrInstance;
    }

    public void addDeliveryPartner(String pDeliveryPartnerName, DeliveryPartner pDeliveryPartner) {
        deliveryPartnersMap.put(pDeliveryPartnerName, pDeliveryPartner);
    }

    public DeliveryPartner getDeliveryPartner(String pDeliveryPartnerName) {
        return deliveryPartnersMap.get(pDeliveryPartnerName);
    }

    public Map<String, DeliveryPartner> getDeliveryPartnersMap() {
        return deliveryPartnersMap;
    }
}

