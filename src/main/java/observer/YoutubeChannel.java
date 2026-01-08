package observer;

public interface YoutubeChannel {

     void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);

    void notifyAllSubscribers();

}
