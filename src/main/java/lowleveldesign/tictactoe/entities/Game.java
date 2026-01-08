package lowleveldesign.tictactoe.entities;

import lowleveldesign.tictactoe.enums.GameStatus;
import lowleveldesign.tictactoe.observer.GameSubject;
import lowleveldesign.tictactoe.state.GameState;
import lowleveldesign.tictactoe.state.InProgressState;
import lowleveldesign.tictactoe.strategy.ColumnWinningStrategy;
import lowleveldesign.tictactoe.strategy.DiagonalWinningStrategy;
import lowleveldesign.tictactoe.strategy.RowWinningStrategy;
import lowleveldesign.tictactoe.strategy.WinningStrategy;

import java.util.List;

public class Game extends GameSubject {

    private final Board board;
    private final Player player1;
    private final Player player2;

    private Player currentPlayer;

    private Player winner;

    private GameStatus gameStatus;

    private GameState gameState;

    private final List<WinningStrategy> winningStrategies;

    public Game(Player player1, Player player2) {
        this.board = new Board(3);
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1; // player 1 starts the game
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.gameState = new InProgressState();
        this.winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );
    }

    public void switchPlayers() {

        this.currentPlayer = currentPlayer == player1 ? player2 : player1;
    }

    public void makeMove(Player player, int row, int col) {

        this.gameState.handleMove(this,player,row,col);

    }

    public boolean checkWinner(Player player) {
        for (WinningStrategy winningStrategy : winningStrategies) {

            if (winningStrategy.checkWinner(board, player)) {
                return true;
            }

        }
        return false;

    }

    public Board getBoard() {
        return board;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getWinner() {
        return winner;
    }

    public GameStatus getStatus() {
        return gameStatus;
    }


    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;

        if(gameStatus!=GameStatus.IN_PROGRESS){
            notifyObservers();
        }
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
