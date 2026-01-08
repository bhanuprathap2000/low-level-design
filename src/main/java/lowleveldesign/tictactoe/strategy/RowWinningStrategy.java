package lowleveldesign.tictactoe.strategy;

import lowleveldesign.tictactoe.entities.Board;
import lowleveldesign.tictactoe.entities.Player;
import lowleveldesign.tictactoe.enums.Symbol;

public class RowWinningStrategy implements WinningStrategy{

    /*
    *
    * In row strategy we fixed row and iterated over the column
    * */

    @Override
    public boolean checkWinner(Board board, Player player) {

        Symbol symbol = player.getSymbol();

        for(int row=0;row<board.getSize();row++){

            boolean rowWin = true;
            for(int col=0;col<board.getSize();col++){

                if(board.getCell(row,col).getSymbol() != symbol){
                    rowWin = false;
                    break;
                }
            }

            if(rowWin) return true;
        }

        return false;
    }
}
