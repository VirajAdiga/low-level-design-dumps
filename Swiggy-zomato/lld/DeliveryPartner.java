package lld;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;

public class DeliveryPartner extends IPartner {
    public DeliveryPartner(String pName) {
        super(pName);
    }

    public void performDelivery(String pOrderId, DeliveryMetadata pDeliveryMetaData) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();

        double restaurantLocLatitude = pDeliveryMetaData.getRestaurantLoc().getLatitude();
        double restaurantLocLongitude = pDeliveryMetaData.getRestaurantLoc().getLongitude();
        notificationMgr.notify(pOrderId, name + " going to pick up delivery from location " 
                        + Double.toString(restaurantLocLatitude) + "," + Double.toString(restaurantLocLongitude));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        notificationMgr.notify(pOrderId, name + " picked up delivery!");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        notificationMgr.notify(pOrderId, name + " on the way to deliver!");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        double userLocLatitude = pDeliveryMetaData.getUserLoc().getLatitude();
        double userLocLongitude = pDeliveryMetaData.getUserLoc().getLongitude();
        notificationMgr.notify(pOrderId, name + " reached the location " + Double.toString(userLocLatitude) + "," + Double.toString(userLocLongitude));

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }

        notificationMgr.notify(pOrderId, name + " delivered the order. CONGRATULATIONS!!");
    }
}

