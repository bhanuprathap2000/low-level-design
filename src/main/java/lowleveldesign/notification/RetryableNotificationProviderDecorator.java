package lowleveldesign.notification;

public class RetryableNotificationProviderDecorator implements NotificationProvider {

    private final NotificationProvider wrappedNotificationProvider;

    private final int maxRetries;

    private final int retryDelayMilliseconds;

    public RetryableNotificationProviderDecorator(NotificationProvider notificationProvider, int maxRetries, int retryDelayMilliseconds) {
        this.wrappedNotificationProvider = notificationProvider;
        this.maxRetries = maxRetries;
        this.retryDelayMilliseconds = retryDelayMilliseconds;
    }

    @Override
    public void sendNotification(Notification notification) throws Exception {

        int attempts = 0;

        while (attempts < maxRetries) {

            try {
                wrappedNotificationProvider.sendNotification(notification);
                return;
            } catch (Exception ex) {
                System.out.println("Error: Attempt " + attempts + " failed for notification " + notification.getId() + ". Retrying...");
                attempts++;

                if (attempts > maxRetries) {
                    System.out.println(ex.getMessage());
                    throw new Exception("Failed to send notification after " + maxRetries + " attempts.", ex);

                }
                Thread.sleep(retryDelayMilliseconds);

            }
        }
    }
}
