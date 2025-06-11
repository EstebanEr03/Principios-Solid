package ocp.notification;

public class NotificationService {
    public void sendNotification(Notification notifier, String message) {
        notifier.send(message);
    }
}
