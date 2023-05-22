package lld;

public class DeliveryMetadata {
    private Location userLoc;
    private Location restaurantLoc;
    private String orderId;
    // weather conditions

    public DeliveryMetadata(String pOrderId, Location pUserLoc, Location pRestaurantLoc) {
        orderId = pOrderId;
        userLoc = pUserLoc;
        restaurantLoc = pRestaurantLoc;
    }

    public Location getUserLoc() {
        return userLoc;
    }

    public Location getRestaurantLoc() {
        return restaurantLoc;
    }
}

