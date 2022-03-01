package BoardFactory;

import BoardGame.BackgammonBoard;
import BoardGame.Board;

public class BackgammonBoardFactory implements Creator{
    @Override
    public Board create() {
        return new BackgammonBoard();
    }
}
