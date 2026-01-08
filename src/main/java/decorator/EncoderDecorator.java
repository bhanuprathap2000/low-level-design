package decorator;

import java.util.Base64;

public class EncoderDecorator extends DataSourceDecorator{

    public EncoderDecorator(DataSource dataSource){
        super(dataSource);
    }

    @Override
    public void writeData(String data){
        super.writeData(encode(data));
    }

    @Override
    public String readData(){
        return decode(super.readData());
    }

    // These methods are the new functionality to the decorator
    private String encode(String data){
       return Base64.getEncoder().encodeToString(data.getBytes());
    }

    private String decode(String data){
        return new String(Base64.getDecoder().decode(data));
    }
}
