// src/ocp/MainOCP.java
package ocp.notification;

import ocp.notification.*;

public class MainOCP {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.sendNotification(new EmailNotification(), "Hello via Email!");
        service.sendNotification(new SMSNotification(),   "Hello via SMS!");
        service.sendNotification(new PushNotification(),  "Hello via Push Notification!");
    }
}
