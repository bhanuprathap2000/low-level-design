package factory;

public class SmsNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return SmsNotification.create();
    }
}
