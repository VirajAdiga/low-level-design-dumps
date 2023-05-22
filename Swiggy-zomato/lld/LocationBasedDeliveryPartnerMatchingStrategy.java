package lld;

import java.util.ArrayList;
import java.util.List;

public class LocationBasedDeliveryPartnerMatchingStrategy implements IDeliveryPartnerMatchingStrategy {
    public List<DeliveryPartner> matchDeliveryPartners(DeliveryMetadata pMetaData) {
        DeliveryPartnerMgr deliveryPartnerMgr = DeliveryPartnerMgr.getDeliveryPartnerMgr();

        System.out.println("Quadtrees can be used to get nearest delivery partners, " +
                "Delivery partner manager can be used to get details of partners. " +
                "Returning all delivery partners for demo purposes for now.");

        ArrayList<DeliveryPartner> nearestDeliveryPartners = new ArrayList<>();
        for (DeliveryPartner deliveryPartner : deliveryPartnerMgr.getDeliveryPartnersMap().values()) {
            nearestDeliveryPartners.add(deliveryPartner);
        }
        return nearestDeliveryPartners;
    }
}

