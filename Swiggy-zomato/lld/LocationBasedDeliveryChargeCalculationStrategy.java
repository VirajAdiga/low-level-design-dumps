package lld;

public class LocationBasedDeliveryChargeCalculationStrategy implements DeliveryChargeCalculationStrategy {
    public double calculateDeliveryCharge(DeliveryMetadata pDeliveryMetaData) {
        System.out.println("Delivery charge is decided based on location. Setting to 20 as default value for now");
        return 20.0;
    }
}

