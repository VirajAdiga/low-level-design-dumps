package lld;

import java.util.List;

public class DeliveryMgr {
    private static DeliveryMgr deliveryMgrInstance = null;
    private static final Object mtx = new Object();

    private DeliveryMgr() {}

    public static DeliveryMgr getDeliveryMgr() {
        if (deliveryMgrInstance == null) {
            synchronized (mtx) {
                if (deliveryMgrInstance == null) {
                    deliveryMgrInstance = new DeliveryMgr();
                }
            }
        }
        return deliveryMgrInstance;
    }

    public void manageDelivery(String pOrderId, DeliveryMetadata pDeliveryMetaData) {
        StrategyMgr strategyMgr = StrategyMgr.getStrategyMgr();
        IDeliveryPartnerMatchingStrategy partnerMatchingStrategy = strategyMgr.determineDeliveryPartnerMatchingStrategy(pDeliveryMetaData);
        List<DeliveryPartner> deliveryPartners = partnerMatchingStrategy.matchDeliveryPartners(pDeliveryMetaData);

        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        //Send push notifications to the nearest delivery partners
        for (DeliveryPartner deliveryPartner : deliveryPartners) {
            notificationMgr.notifyParticularUser(deliveryPartner.getName(), "Delivery Request", new PushNotificationSender());
        }

        DeliveryPartner assignedDeliveryPartner = deliveryPartners.get(0);

        //Assume first delivery partner accepted it
        notificationMgr.notify(pOrderId, "Delivery Partner " + assignedDeliveryPartner.getName() + " assigned for the order " + pOrderId);

        assignedDeliveryPartner.performDelivery(pOrderId, pDeliveryMetaData);
    }
}

