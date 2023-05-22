package lld;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private User user;
    private Restaurant restaurant;
    private Map<Dish, Integer> dishes; //quantity for each dish
    private String discountCode;
    private String paymentId;
    private OrderStatus status;

    public Order(User pUser, Restaurant pRestaurant, Map<Dish, Integer> pDishes) {
        user = pUser;
        restaurant = pRestaurant;
        dishes = new HashMap<Dish, Integer>(pDishes);
        status = OrderStatus.PLACED;
    }

    public String getUserId() {
        return user.getId();
    }

    public String getRestaurantId() {
        return restaurant.getId();
    }

    public Map<Dish, Integer> getDishes() {
        return dishes;
    }

    public Location getUserLocation() {
        return user.getLocation();
    }

    public Location getRestaurantLocation() {
        return restaurant.getLocation();
    }
}

