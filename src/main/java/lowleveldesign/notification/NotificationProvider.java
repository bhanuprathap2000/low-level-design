package lowleveldesign.notification;

public interface NotificationProvider {

    void sendNotification(Notification notification) throws Exception;
}
