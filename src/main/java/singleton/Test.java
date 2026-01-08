package singleton;

public class Test {

    public static void main(String[] args) {

        EagerLoggerSingleton eagerLoggerSingleton = EagerLoggerSingleton.getInstance();

        System.out.println(eagerLoggerSingleton);
        System.out.println(eagerLoggerSingleton);




    }
}
