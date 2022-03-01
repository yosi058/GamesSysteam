package BoardFactory;

import BoardGame.Board;
import BoardGame.CheckersBoard;

public class CheckersBoardFactory implements Creator{
    @Override
    public Board create() {
        return new CheckersBoard();
    }
}
