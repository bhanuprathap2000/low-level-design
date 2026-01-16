package lowleveldesign.notification;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NotificationProviderFactory {

    private static final Map<NotificationType, NotificationProvider> notificationProviderMap = new ConcurrentHashMap<>();

    public static NotificationProvider createNotificationProvider(NotificationType notificationType) {


        if (notificationProviderMap.containsKey(notificationType)) {
            return notificationProviderMap.get(notificationType);
        }

        NotificationProvider notificationProvider = switch (notificationType) {

            case SMS -> new SmsNotificationProvider();
            case EMAIL -> new EmailNotificationProvider();
            case PUSH -> new PushNotificationProvider();
            default ->
                    throw new IllegalArgumentException("Notification type %s not supported".formatted(notificationType));
        };

        notificationProviderMap.put(notificationType, notificationProvider);

        return notificationProvider;

    }

}
