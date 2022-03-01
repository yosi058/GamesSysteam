package Pieces.BackgammonPieces;

import BoardGame.Move;
import BoardGame.Board;
import Pieces.Piece;

import java.util.ArrayList;

public abstract class BackgammonPiece extends Piece {

    protected BackgammonPiece(boolean color) {
        super(color);
    }

    @Override
    public ArrayList<Move> getMoves(Board b, int x, int y) {
        return null;

    }
}
