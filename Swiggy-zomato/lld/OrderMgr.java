package lld;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderMgr {
    private static OrderMgr orderMgrInstance = null;
    private static Lock mtx = new ReentrantLock();
    private Map<String, Order> ordersMap = new HashMap<>();
    private DeliveryMgr deliveryMgr;
    private FoodMgr foodMgr;

    private OrderMgr() {
        deliveryMgr = DeliveryMgr.getDeliveryMgr();
        foodMgr = FoodMgr.getFoodMgr();
    }

    public static OrderMgr getOrderMgr() {
        if (orderMgrInstance == null) {
            mtx.lock();
            try {
                if (orderMgrInstance == null) {
                    orderMgrInstance = new OrderMgr();
                }
            } finally {
                mtx.unlock();
            }
        }
        return orderMgrInstance;
    }

    public void createOrder(String pOrderId, Order pOrder) throws InterruptedException {
        addUserForNotificationUpdates(pOrderId, pOrder);
        manageFood(pOrderId, pOrder);
        manageDelivery(pOrderId, pOrder);
    }

    private void addUserForNotificationUpdates(String pOrderId, Order pOrder) {
        NotificationMgr notificationMgr = NotificationMgr.getNotificationMgr();
        notificationMgr.addNotificationSender(pOrderId, pOrder.getUserId(), new SMSNotificationSender());
    }

    private void manageDelivery(String pOrderId, Order pOrder) {
        DeliveryMetadata metaData = new DeliveryMetadata(pOrderId, pOrder.getUserLocation(), pOrder.getRestaurantLocation());
        deliveryMgr.manageDelivery(pOrderId, metaData);
    }

    private void manageFood(String pOrderId, Order pOrder) throws InterruptedException {
        foodMgr.prepareFood(pOrderId, pOrder.getRestaurantId(), (HashMap<Dish, Integer>) pOrder.getDishes());
    }

    public Order getOrder(String pOrderName) {
        return ordersMap.get(pOrderName);
    }
}

