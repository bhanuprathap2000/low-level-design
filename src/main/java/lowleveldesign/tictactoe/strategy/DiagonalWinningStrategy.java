package lowleveldesign.tictactoe.strategy;

import lowleveldesign.tictactoe.entities.Board;
import lowleveldesign.tictactoe.entities.Player;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, Player player) {

        boolean mainDiagonal = true;

        for (int i = 0; i < board.getSize(); i++) {

            if (board.getCell(i, i).getSymbol() != player.getSymbol()) {
                mainDiagonal = false;
                break;
            }
        }

        if (mainDiagonal) return true;

        boolean antiDiagonal = true;

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getCell(i, board.getSize() - 1 - i).getSymbol() != player.getSymbol()) {
                antiDiagonal = false;
                break;
            }
        }

        return antiDiagonal;
    }
}
