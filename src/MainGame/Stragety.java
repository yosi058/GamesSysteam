package MainGame;

import BoardGame.Board;
import BoardGame.Move;

public interface Stragety {
    Move getMove(Board board, int turn);
}



