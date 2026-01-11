package lowleveldesign.snakeandladder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * The reason to choose the map for snake and ladder is that , we just maintain the snake and ladders positions,
 * rest of position is normal and need not to be maintained.
 * */
public class Board {

    private final int size;

    private Map<Integer,Integer> snakeAndLadders = new HashMap<>();

    public Board(int size, List<BoardEntity> boardEntityList) {
        this.size = size;

        for(BoardEntity boardEntity:boardEntityList){
            snakeAndLadders.put(boardEntity.getStart(),boardEntity.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int getFinalPosition(int position){
        return snakeAndLadders.getOrDefault(position,position);
    }
}

