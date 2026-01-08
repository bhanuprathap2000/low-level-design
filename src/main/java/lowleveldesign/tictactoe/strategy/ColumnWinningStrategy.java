package lowleveldesign.tictactoe.strategy;

import lowleveldesign.tictactoe.entities.Board;
import lowleveldesign.tictactoe.entities.Player;

public class ColumnWinningStrategy implements WinningStrategy {


    /*
    * In column we fixed the col and iterated over the row
    * */
    @Override
    public boolean checkWinner(Board board, Player player) {

        for (int col = 0; col < board.getSize(); col++) {

            boolean colWin = true;

            for (int row = 0; row < board.getSize(); row++) {


                if (board.getCell(row, col).getSymbol() != player.getSymbol()) {

                    colWin = false;
                    break;
                }


            }

            if (colWin) return true;
        }

        return false;
    }
}
