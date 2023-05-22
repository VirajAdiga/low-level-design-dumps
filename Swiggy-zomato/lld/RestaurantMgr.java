package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class RestaurantMgr {
    private static RestaurantMgr restaurantMgrInstance = null;
    private static ReentrantLock mtx = new ReentrantLock();
    private Map<String, Restaurant> restaurantsMap;

    private RestaurantMgr() {
        restaurantsMap = new HashMap<>();
    }

    public static RestaurantMgr getRestaurantMgr() {
        if (restaurantMgrInstance == null) {
            mtx.lock();
            if (restaurantMgrInstance == null) {
                restaurantMgrInstance = new RestaurantMgr();
            }
            mtx.unlock();
        }
        return restaurantMgrInstance;
    }

    public void addRestaurant(String pRestaurantName, Restaurant pRestaurant) {
        restaurantsMap.put(pRestaurantName, pRestaurant);
    }

    public Restaurant getRestaurant(String pRestaurantName) {
        return restaurantsMap.get(pRestaurantName);
    }
}

