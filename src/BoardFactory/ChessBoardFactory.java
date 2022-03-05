package BoardFactory;

import BoardGame.Board;
import Chess.ChessBoard;

public class ChessBoardFactory implements Creator{
//
@Override
public Board create() {
    return ChessBoard.getInstancce();
}
}
