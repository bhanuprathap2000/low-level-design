package factory;

abstract class NotificationFactory {

    public abstract Notification createNotification();

    public void send(String msg){

        Notification notification = createNotification();
        notification.send(msg);
    }
}
