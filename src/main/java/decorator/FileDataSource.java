package decorator;

import java.io.*;

public class FileDataSource implements DataSource{

    private String name;


    public FileDataSource(String name){
        this.name = name;
    }

    @Override
    public void writeData(String data) {
        File file = new File(name);

        try(OutputStream os = new FileOutputStream(file)){
            os.write(data.getBytes());
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String readData() {

        File file = new File(name);
        StringBuilder result = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return result.toString();
    }

}
