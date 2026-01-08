package factory;

public class SmsNotification implements Notification{


    private SmsNotification(){

    }
    @Override
    public void send(String message) {
        System.out.printf("Sent SmsNotification message: %s%n", message);
    }


    public static SmsNotification create(){

        return SmsNotificationSingletonHelper.INSTANCE;
    }

    private static class SmsNotificationSingletonHelper{

        private static final SmsNotification INSTANCE = new SmsNotification();
    }
}
