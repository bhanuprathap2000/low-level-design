package lowleveldesign.snakeandladder;

public class Ladder extends BoardEntity{
    public Ladder(int start, int end) {
        super(start, end);

        if(start>= end){
            throw new IllegalArgumentException("Ladder start should be at the start than it's top");
        }
    }
}
