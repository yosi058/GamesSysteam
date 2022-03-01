package MainGame;

import BoardGame.Board;
import BoardGame.Move;
import BoardGame.Square;

import java.util.ArrayList;

public class ChessLogic extends GameLogic {
    @Override
    public boolean isFinish(Board board) {
        return board.gameOver();
    }

    @Override
    public void updateBoard(Board board, Move move) {
        board.updateBoard(move.getX1(), move.getY1(), move.getX2(), move.getY2());
    }

    @Override
    public boolean isLeagl(Board board, Move move) {
        Square square = board.getSquare(move.getX1(), move.getY1());
        ArrayList<Move> valid_moves = square.getPiece().getMoves(board, move.getX1(), move.getY1());
        return checkValid(move, valid_moves);
    }

    @Override
    public int getVal(Board board, Move move) {
        Square square = board.getSquare(move.getX2(), move.getY2());
        if (square.getPiece() != null) {
            return square.getPiece().getValue();
        }
        return 0;
    }

    private boolean checkValid(Move current, ArrayList<Move> valid_moves) {
        for (Move move : valid_moves) {
            if ((current.getX1() == move.getX1()) && (current.getX2() == move.getX2()) &&
                    (current.getY1() == move.getY1()) && (current.getY2() == move.getY2())) {
                return true;
            }
        }
        return false;
    }
}
