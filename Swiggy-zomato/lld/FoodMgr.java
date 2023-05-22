package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FoodMgr {
    private static FoodMgr foodMgrInstance = null;
    private static Lock mtx = new ReentrantLock();

    private FoodMgr() {}

    public static FoodMgr getFoodMgr() {
        if (foodMgrInstance == null) {
            mtx.lock();
            if (foodMgrInstance == null) {
                foodMgrInstance = new FoodMgr();
            }
            mtx.unlock();
        }
        return foodMgrInstance;
    }

    public void addRestaurantForNotificationUpdates(String pOrderId, String pRestaurantId) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        //we can add push or whatsapp notifications in same way. Basically, we are keeping all notifications customisable
        notificationMgr.addNotificationSender(pOrderId, pRestaurantId, new PushNotificationSender());
    }

    public void prepareFood(String pOrderId, String pRestaurantId, HashMap<Dish, Integer> pDishes) throws InterruptedException {
        RestaurantMgr restaurantMgr = RestaurantMgr.getRestaurantMgr();
        Restaurant restaurant = restaurantMgr.getRestaurant(pRestaurantId);
        restaurant.prepareFood(pOrderId, pDishes);

        //lld.Restaurant should receive the delivery partner's notifications.
        //The order in which the restaurant, user & delivery partner are added to the notification mgr
        //will decide which notifications they receive
        //For interviews, This is too much detailing though, we can just mention to interviewer and move forward
        addRestaurantForNotificationUpdates(pOrderId, pRestaurantId);
    }
}

