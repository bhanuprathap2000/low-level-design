package lowleveldesign.tictactoe.strategy;

import lowleveldesign.tictactoe.entities.Board;
import lowleveldesign.tictactoe.entities.Player;

public interface WinningStrategy {

    boolean checkWinner(Board board, Player player);
}
