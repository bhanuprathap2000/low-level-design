package lowleveldesign.notification;

public class EmailNotificationProvider implements NotificationProvider {
    @Override
    public void sendNotification(Notification notification) {

        String email = notification.getRecipient().getEmail()
                .orElseThrow(() -> new IllegalArgumentException("Email Id Not present"));


        System.out.println("--- Sending EMAIL ---");
        System.out.println("To: " + email);
        System.out.println("Subject: " + notification.getSubject());
        System.out.println("Body: " + notification.getMessage());
        System.out.println("---------------------\n");

    }
}
