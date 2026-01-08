package singleton;

public class EagerLoggerSingleton {

    private static final EagerLoggerSingleton INSTANCE = new EagerLoggerSingleton();

    private EagerLoggerSingleton(){}

    public static EagerLoggerSingleton getInstance(){
        return INSTANCE;
    }



}
