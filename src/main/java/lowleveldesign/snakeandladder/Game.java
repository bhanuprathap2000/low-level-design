package lowleveldesign.snakeandladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Game {

    private final Board board;
    private final Dice dice;

    private final Queue<Player> players;

    private GameStatus gameStatus;

    private Player winner;

    private Game(Builder builder) {
        this.board = builder.board;
        this.dice = builder.dice;
        this.players = builder.players;
        this.gameStatus = builder.gameStatus;
        this.winner = builder.winner;
    }


    public static class Builder {


        private Board board;

        private Dice dice;

        private final Queue<Player> players = new LinkedList<>();

        private GameStatus gameStatus = GameStatus.NOT_STARTED;

        private Player winner;


        public Builder withBoard(int size , List<BoardEntity> boardEntityList) {
            this.board = new Board(size,boardEntityList);
            return this;
        }

        public Builder withDice(Dice dice) {
            this.dice = dice;
            return this;
        }

        public Builder withPlayer(Player player) {
            this.players.offer(player);
            return this;
        }

        public Builder withGameStatus(GameStatus gameStatus) {
            this.gameStatus = gameStatus;
            return this;
        }

        public Game build() {

            if (board == null) {
                throw new IllegalStateException("Board must be provided");
            }

            if (dice == null) {
                throw new IllegalStateException("Dice must be provided");
            }

            if (players.size() < 2) {
                throw new IllegalStateException("At least 2 players are required");
            }


            return new Game(this);
        }

    }


    public void play() {

        if (players.size() < 2) {
            System.out.println("Number of players are less than 2 , hence cannot begin game");
            return;
        }

        this.gameStatus = GameStatus.RUNNING;
        System.out.println("Game Started");


        while (gameStatus == GameStatus.RUNNING) {

            Player player = players.poll();
            takeTurn(player);

            if (gameStatus == GameStatus.RUNNING) {
                players.offer(player);

            }
        }

        System.out.println("Game Finished");

        if (winner != null) {
            System.out.printf("The winner is %s!\n", winner.getName());

        }
    }

    public void takeTurn(Player player) {

        int roll = this.dice.roll();

        System.out.printf("\n%s's turn. Rolled a %d.\n", player.getName(), roll);

        int currentPosition = player.getPosition();
        int nextPosition = currentPosition + roll;

        if (nextPosition > board.getSize()) {
            System.out.printf("Oops, %s needs to land exactly on %d. Turn skipped.\n", player.getName(), board.getSize());
            return;
        }

        if (nextPosition == this.board.getSize()) {
            player.setPosition(nextPosition);
            this.winner = player;
            this.gameStatus = GameStatus.FINISHED;
            System.out.printf("Hooray! %s reached the final square %d and won!\n", player.getName(), board.getSize());
            return;

        }

        int finalPosition = this.board.getFinalPosition(nextPosition);

        if (finalPosition > nextPosition) { // Ladder
            System.out.printf("Wow! %s found a ladder 🪜 at %d and climbed to %d.\n", player.getName(), nextPosition, finalPosition);
        } else if (finalPosition < nextPosition) { // Snake
            System.out.printf("Oh no! %s was bitten by a snake 🐍 at %d and slid down to %d.\n", player.getName(), nextPosition, finalPosition);
        } else {
            System.out.printf("%s moved from %d to %d.\n", player.getName(), currentPosition, finalPosition);
        }

        player.setPosition(finalPosition);

        if (roll == 6) {
            System.out.printf("%s rolled a 6 and gets another turn!\n", player.getName());
            takeTurn(player);
        }


    }


}
