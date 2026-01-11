package lowleveldesign.snakeandladder;

public class Dice {

    private final int minValue;

    private final int maxValue;


    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }


    /*
    * This will generate the random numbers between the min and max value
    *
    * math.random gives between the 0 and 0.999 and if we multiply by number of range - we get between the
    * 0 to range -1  but we need between the min and max value hence add minvalue
    * */
    public int roll(){

        return (int)(Math.random() * (maxValue - minValue +1) + minValue);
    }
}
