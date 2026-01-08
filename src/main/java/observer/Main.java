package observer;

public class Main {

    public static void main(String[] args) {

        // Create a YouTube channel
        YoutubeChannelImpl channel = new YoutubeChannelImpl();

        // Create subscribers
        YoutubeSubscriber alice = new YoutubeSubscriber("Alice");
        YoutubeSubscriber bob = new YoutubeSubscriber("Bob");

        // Subscribe users
        channel.addSubscriber(alice);
        channel.addSubscriber(bob);

        // Upload a new video
        channel.uploadNewVideo("Java Design Patterns Tutorial");

        // Remove one subscriber
        channel.removeSubscriber(bob);

        // Upload another video
        channel.uploadNewVideo("Observer Pattern in Action");
    }
}
