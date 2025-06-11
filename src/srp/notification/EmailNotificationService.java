package srp.notification;

public class EmailNotificationService implements NotificationService {
    @Override
    public void sendWelcomeMessage(String email) {
        System.out.println("Sending welcome email to " + email);
    }
}
