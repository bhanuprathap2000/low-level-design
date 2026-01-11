package lowleveldesign.snakeandladder;

import java.util.*;

public class SnakeAndLadderDemo {
    public static void main(String[] args) {
        List<BoardEntity> boardEntities = List.of(
                new Snake(17, 7), new Snake(54, 34),
                new Snake(62, 19), new Snake(98, 79),
                new Ladder(3, 38), new Ladder(24, 33),
                new Ladder(42, 93), new Ladder(72, 84)
        );


        Game game = new Game.Builder()
                .withBoard(100, boardEntities)
                .withPlayer(new Player("Alice"))
                .withPlayer(new Player("Bob"))
                .withDice(new Dice(1, 6))
                .build();

        game.play();
    }
}