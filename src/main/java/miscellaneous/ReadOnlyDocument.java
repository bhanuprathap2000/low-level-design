package miscellaneous;

public class ReadOnlyDocument implements Document{
    @Override
    public void open() {
        System.out.println("Opened ReadOnlyDocument");
    }

    @Override
    public String getData() {
        return null;
    }
}
