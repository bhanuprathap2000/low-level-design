package iterator;

public class PlaylistIterator implements Iterator<String>{

    private final Playlist playlist;
    int index;

    PlaylistIterator(Playlist playlist){
        this.playlist = playlist;
    }

    @Override
    public boolean hasNext() {
        return index < playlist.getSize();
    }

    @Override
    public String next() {
        return playlist.getSongAt(index++);
    }
}
