package factory;

public class NotificationSimpleFactory {

    public static Notification createNotification(String notificationType) {

        return switch (notificationType.toLowerCase()) {
            case "email" -> EmailNotification.create();
            case "sms" -> SmsNotification.create();
            case "phonenotification" -> PhoneNotification.create();
            default ->
                    throw new RuntimeException("No , notification type found for given %s".formatted(notificationType));
        };
    }
}
