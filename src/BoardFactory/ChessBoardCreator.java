package BoardFactory;

import BoardGame.Board;
import Chess.ChessBoard;

public class ChessBoardCreator implements IBoardCreator {

@Override
public Board create() {
    return ChessBoard.getInstance();
}
}
