package MainGame;

import BoardGame.Board;
import BoardGame.Move;

public  abstract class GameLogic {


    public abstract boolean isFinish( Board board);

    public abstract void updateBoard(Board board, Move move);

    public abstract boolean isLeagl(Board board, Move move);
    public int getVal(Board board, Move move){
        return 0;
    }
}
