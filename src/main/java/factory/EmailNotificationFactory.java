package factory;

public class EmailNotificationFactory extends NotificationFactory{

    private EmailNotificationFactory(){

    }
    @Override
    public Notification createNotification() {
        return EmailNotification.create();
    }

    public static EmailNotificationFactory getInstance(){
        return EmailNotificationFactorySingletonHelper.INSTANCE;
    }

    private static class EmailNotificationFactorySingletonHelper{
        private static final EmailNotificationFactory INSTANCE = new EmailNotificationFactory();
    }
}
