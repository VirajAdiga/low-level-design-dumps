package lld;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Restaurant {
    private String name;
    private boolean isAvail;
    private Location location;
    private Menu menu;
    private RestaurantOwner owner;

    public Restaurant(String pName, RestaurantOwner pOwner, Location pLoc) {
        name = pName;
        owner = pOwner;
        location = pLoc;
        isAvail = false;
        menu = null;
    }

    public void addMenu(Menu pMenu) {
        menu = pMenu;
    }

    public String getId() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public boolean prepareFood(String pOrderId, HashMap<Dish, Integer> dishes) throws InterruptedException {
        System.out.println("lld.Restaurant accepting the order and starting to prepare it");

        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();

        notificationMgr.notify(pOrderId, "Food is being prepared in restaurant");

        TimeUnit.SECONDS.sleep(5);

        notificationMgr.notify(pOrderId, "Food is ready and can be picked up from restaurant");

        return true;
    }
}

