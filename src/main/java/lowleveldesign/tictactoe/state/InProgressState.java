package lowleveldesign.tictactoe.state;

import lowleveldesign.tictactoe.entities.Game;
import lowleveldesign.tictactoe.entities.Player;
import lowleveldesign.tictactoe.enums.GameStatus;
import lowleveldesign.tictactoe.enums.Symbol;
import lowleveldesign.tictactoe.exception.InvalidMoveException;

public class InProgressState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) {

        if(game.getCurrentPlayer()!=player){
            throw new InvalidMoveException("please wait for your turn");
        }

        game.getBoard().placeSymbol(row,col,player.getSymbol());

        if(game.checkWinner(player)){
            game.setWinner(player);
            game.setGameStatus(player.getSymbol() == Symbol.X ? GameStatus.WINNER_X : GameStatus.WINNER_O);
            game.setGameState(new WinnerState());

        }else if(game.getBoard().isFull()){
            game.setGameStatus(GameStatus.DRAW);
            game.setGameState(new DrawState());
        }
        else{
            game.switchPlayers();
        }
    }
}
