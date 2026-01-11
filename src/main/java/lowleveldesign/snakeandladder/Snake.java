package lowleveldesign.snakeandladder;

public class Snake extends BoardEntity{
    public Snake(int start, int end) {
        super(start, end);
        if(start <= end){
            throw new IllegalArgumentException("Snake Head must be at the higher position , than it's tail");
        }
    }
}
