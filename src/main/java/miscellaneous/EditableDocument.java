package miscellaneous;

public class EditableDocument implements Document , Editable{

    private String data;
    @Override
    public void open() {
        System.out.println("Opened Editable Document");
    }

    @Override
    public String getData() {
        return "This is a editable document "+ data;
    }

    @Override
    public void save(String newData) {

        this.data = newData;

    }
}
