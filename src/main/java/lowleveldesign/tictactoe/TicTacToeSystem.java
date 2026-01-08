package lowleveldesign.tictactoe;

import lowleveldesign.tictactoe.entities.Game;
import lowleveldesign.tictactoe.entities.Player;
import lowleveldesign.tictactoe.exception.InvalidMoveException;
import lowleveldesign.tictactoe.observer.Scoreboard;

public class TicTacToeSystem {

    private static TicTacToeSystem instance;

    private Game game;

    private Scoreboard scoreboard;

    private TicTacToeSystem() {
        this.scoreboard = new Scoreboard();
    }


    public static synchronized TicTacToeSystem getInstance() {

        if (instance == null) {
            instance = new TicTacToeSystem();
        }

        return instance;
    }

    public void createGame(Player player1, Player player2) {

        this.game = new Game(player1, player2);

        this.game.addObserver(this.scoreboard);

        System.out.printf("Game started between %s (X) and %s (O).%n", player1.getName(), player2.getName());

    }

    public void makeMove(Player player, int row, int col) {

        if (game == null) {
            System.out.println("No game in progress. Please create a game first.");
            return;

        } else {

            try {
                System.out.printf("%s plays at (%d, %d)%n", player.getName(), row, col);

                game.makeMove(player, row, col);

                printBoard();

                System.out.println("Game Status: " + game.getStatus());

                if (game.getWinner() != null) {
                    System.out.println("Winner: " + game.getWinner().getName());
                }
            } catch (InvalidMoveException exception) {
                System.out.println("Error: " + exception.getMessage());

            }


        }


    }

    public void printBoard() {
        this.game.getBoard().printBoard();
    }

    public void printScoreBoard() {
        scoreboard.printScores();
    }
}
