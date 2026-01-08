package factory;

public class EmailNotification implements Notification{

    private EmailNotification(){

    }
    @Override
    public void send(String message) {
        System.out.printf("Sent EmailNotification message: %s%n", message);
    }

    public static EmailNotification create(){

        return EmailNotificationSingletonHelper.INSTANCE;

    }

    private static class EmailNotificationSingletonHelper{
        private final static EmailNotification INSTANCE = new EmailNotification();

    }


}
