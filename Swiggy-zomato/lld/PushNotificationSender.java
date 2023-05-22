package lld;

public class PushNotificationSender implements INotificationSender {
    public void sendNotification(String pUserId, String pMsg) {
        System.out.println("Push Notification for " + pUserId + " is " + pMsg);
    }
}

