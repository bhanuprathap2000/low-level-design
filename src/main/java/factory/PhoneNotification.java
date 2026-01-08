package factory;

public class PhoneNotification implements Notification{

    private PhoneNotification(){

    }
    @Override
    public void send(String message) {
        System.out.printf("Sent PhoneNotification message: %s%n", message);
    }

    public static PhoneNotification create(){
        return PhoneNotificationSingletonHelper.INSTANCE;
    }


    private static class PhoneNotificationSingletonHelper{
        private static final PhoneNotification INSTANCE = new PhoneNotification();
    }
}
