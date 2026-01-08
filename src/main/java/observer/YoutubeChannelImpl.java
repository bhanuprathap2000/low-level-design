package observer;

import java.util.ArrayList;
import java.util.List;

public class YoutubeChannelImpl implements YoutubeChannel{

    private final List<Subscriber> subscribers = new ArrayList<>();

    private final List<String> videos = new ArrayList<>();

    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void removeSubscriber(Subscriber subscriber) {

        subscribers.remove(subscriber);
    }

    @Override
    public void notifyAllSubscribers() {

        for (Subscriber subscriber : subscribers) {
            subscriber.update(videos.get(videos.size()-1));
        }

    }

    public void uploadNewVideo(String video){
        videos.add(video);
        notifyAllSubscribers();
    }
}
