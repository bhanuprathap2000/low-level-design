package lowleveldesign.tictactoe.state;

import lowleveldesign.tictactoe.entities.Game;
import lowleveldesign.tictactoe.entities.Player;

public interface GameState {

    void handleMove(Game game, Player player,int row, int col);
}
