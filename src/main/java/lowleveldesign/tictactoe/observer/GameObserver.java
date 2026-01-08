package lowleveldesign.tictactoe.observer;

import lowleveldesign.tictactoe.entities.Game;

public interface GameObserver {

    void update(Game game);
}
