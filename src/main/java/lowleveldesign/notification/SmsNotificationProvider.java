package lowleveldesign.notification;

public class SmsNotificationProvider implements NotificationProvider {
    @Override
    public void sendNotification(Notification notification) {

        String phoneNumber = notification.getRecipient().getPhoneNumber().orElseThrow(
                () -> new RuntimeException("Phone Number not present")
        );

        System.out.println("--- Sending SMS ---");
        System.out.println("To: " + phoneNumber);
        System.out.println("Message: " + notification.getMessage());
        System.out.println("-------------------\n");
    }
}
