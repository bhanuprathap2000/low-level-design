package lowleveldesign.notification;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NotificationService {

    private final ExecutorService executorService;

    public NotificationService(int threadPoolSize) {
        this.executorService = Executors.newFixedThreadPool(threadPoolSize);
    }

    public void sendNotification(Notification notification) {

        executorService.submit(() -> {

            NotificationProvider notificationProvider = new RetryableNotificationProviderDecorator(
                    NotificationProviderFactory.createNotificationProvider(
                            notification.getType()
                    ),
                    3,
                    1000
            );
            try {
                notificationProvider.sendNotification(
                        notification
                );
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
    }

    public void shutdown() {
        executorService.shutdown();
    }

}
