package factory;

public class Test {


    public static void main(String[] args) {


        Notification smsNotification = NotificationSimpleFactory.createNotification("sms");
        Notification emailNotification = NotificationSimpleFactory.createNotification("email");

        smsNotification.send("Hello How are you");

        emailNotification.send("Hello, This is email from me");

        Notification notification = EmailNotificationFactory.getInstance().createNotification();

        notification.send("This is a email from bhanu");
    }
}
