package BoardFactory;

import BoardGame.BackgammonBoard;
import BoardGame.Board;

public class BackgammonBoardCreator implements IBoardCreator {
    @Override
    public Board create() {
        return new BackgammonBoard();
    }
}
