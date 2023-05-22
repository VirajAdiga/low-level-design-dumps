package lld;

import java.util.List;

public interface IDeliveryPartnerMatchingStrategy {
    List<DeliveryPartner> matchDeliveryPartners(DeliveryMetadata pDeliveryMetaData);
}

