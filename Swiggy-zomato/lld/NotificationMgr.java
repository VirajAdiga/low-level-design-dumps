package lld;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import Pair;
import java.util.concurrent.locks.ReentrantLock;

public class NotificationMgr {
    private static NotificationMgr notificationMgrInstance = null;
    private static ReentrantLock mtx = new ReentrantLock();
    private Map<String, List<Pair<String, INotificationSender>>> notificationSendersMap;

    private NotificationMgr() {
        notificationSendersMap = new HashMap<>();
    }

    public static NotificationMgr getNotificationMgr() {
        if (notificationMgrInstance == null) {
            mtx.lock();
            if (notificationMgrInstance == null) {
                notificationMgrInstance = new NotificationMgr();
            }
            mtx.unlock();
        }
        return notificationMgrInstance;
    }

    public void addNotificationSender(String orderId, String userId, INotificationSender notificationSender) {
        if (!notificationSendersMap.containsKey(orderId)) {
            notificationSendersMap.put(orderId, new ArrayList<>());
        }
        if (!notificationSendersMap.get(orderId).contains(new Pair<>(userId, notificationSender))) {
            notificationSendersMap.get(orderId).add(new Pair<>(userId, notificationSender));
        }
    }

    public void removeNotificationSender(String orderId, String userId, INotificationSender notificationSender) {
        if (notificationSendersMap.containsKey(orderId)) {
            notificationSendersMap.get(orderId).remove(new Pair<>(userId, notificationSender));
        }
    }

    public void notify(String orderId, String msg) {
        if (notificationSendersMap.containsKey(orderId)) {
            for (Pair<String, INotificationSender> sender : notificationSendersMap.get(orderId)) {
                sender.getValue().sendNotification(sender.getKey(), msg);
            }
        }
    }

    public void notifyParticularUser(String userId, String msg, INotificationSender sender) {
        sender.sendNotification(userId, msg);
    }
}
