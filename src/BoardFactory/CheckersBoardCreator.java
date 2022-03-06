package BoardFactory;

import BoardGame.Board;
import BoardGame.CheckersBoard;

public class CheckersBoardCreator implements IBoardCreator {
    @Override
    public Board create() {
        return new CheckersBoard();
    }
}
