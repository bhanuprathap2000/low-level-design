package factory;

public class PhoneNotificationFactory extends NotificationFactory{
    @Override
    public Notification createNotification() {
        return PhoneNotification.create();
    }
}
