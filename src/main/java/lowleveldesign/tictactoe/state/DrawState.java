package lowleveldesign.tictactoe.state;

import lowleveldesign.tictactoe.entities.Game;
import lowleveldesign.tictactoe.entities.Player;
import lowleveldesign.tictactoe.exception.InvalidMoveException;

public class DrawState implements GameState{
    @Override
    public void handleMove(Game game, Player player, int row, int col) {
        throw new InvalidMoveException("Game has been drawn already");
    }
}
