package singleton;

public class LazyLoggerSingleton {

    private static volatile LazyLoggerSingleton INSTANCE;

    private LazyLoggerSingleton(){}


    public static LazyLoggerSingleton getInstance(){

        if(INSTANCE == null) {
            INSTANCE = new LazyLoggerSingleton();
        }

        return INSTANCE;
    }

    public static synchronized LazyLoggerSingleton getThreadSafeInstance(){
        if(INSTANCE == null) {
            INSTANCE = new LazyLoggerSingleton();
        }

        return INSTANCE;
    }



    public static  LazyLoggerSingleton getThreadSafeInstanceViaDoubleCheck(){
        if(INSTANCE == null) {

            synchronized (LazyLoggerSingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new LazyLoggerSingleton();
                }

            }
        }

        return INSTANCE;
    }

    public static LazyLoggerSingleton getThreadSafeInstanceViaInnerClass(){

        return SingletonHelper.INSTANCE;

    }

    private static class SingletonHelper{
        private static final LazyLoggerSingleton INSTANCE = new LazyLoggerSingleton();
    }




}
