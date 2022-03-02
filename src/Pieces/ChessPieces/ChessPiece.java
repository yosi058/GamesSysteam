package Pieces.ChessPieces;
import Pieces.Piece;

public abstract class ChessPiece extends Piece{

    protected ChessPiece(boolean color) {
        super(color);
    }

    public boolean valid(int x, int y) {
        if(x < 0 || x > 7 || y < 0 || y > 7)
            return false;
        else
            return true;
    }
}
