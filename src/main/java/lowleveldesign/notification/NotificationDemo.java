package lowleveldesign.notification;

public class NotificationDemo {

    public static void main(String[] args) throws InterruptedException {
        // 1. Setup the notification service
        NotificationService notificationService = new NotificationService(10);

        // 2. Define recipients
        Recipient recipient1 = new Recipient("user123",  null,"john.doe@example.com", "pushToken123");
        Recipient recipient2 = new Recipient("user456", "+15551234567",null,  null);

        // 3. Send various notifications using the Facade (NotificationService)

        // Scenario 1: Send a welcome email
        Notification welcomeEmail = new Notification.Builder(NotificationType.EMAIL,recipient1)
                .withSubject("Welcome!")
                .withMessage("Welcome to notification system")
                .build();
        notificationService.sendNotification(welcomeEmail);

        // Scenario 2: Send a direct push notification
        Notification pushNotification = new Notification.Builder(NotificationType.PUSH,recipient1)
                .withSubject("New Message")
                .withMessage("You have a new message from Jane.")
                .build();
        notificationService.sendNotification(pushNotification);

        // Scenario 3: Send order confirmation SMS
        Notification orderSms = new Notification.Builder(NotificationType.SMS,recipient2)
                .withMessage("Your order for Digital Clock is confirmed")
                .build();
        notificationService.sendNotification(orderSms);

        // Wait for a moment to allow the queue processor to work
        Thread.sleep(1000);

        // 4. Shutdown the system
        System.out.println("\nShutting down the notification system...");
        notificationService.shutdown();
        System.out.println("System shut down successfully.");

    }
}
