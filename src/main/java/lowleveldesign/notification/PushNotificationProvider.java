package lowleveldesign.notification;

public class PushNotificationProvider implements NotificationProvider {
    @Override
    public void sendNotification(Notification notification) {

        String token = notification.getRecipient().getPushToken()
                .orElseThrow(() -> new IllegalArgumentException("Push token is required for PUSH notification."));
        System.out.println("--- Sending PUSH Notification ---");
        System.out.println("To Device Token: " + token);
        System.out.println("Title: " + notification.getSubject()); // Re-using subject for title
        System.out.println("Body: " + notification.getMessage());
        System.out.println("---------------------------------\n");
    }
}
