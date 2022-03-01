package Pieces.ChessPieces;

import BoardGame.Board;
import BoardGame.Move;
import Pieces.Piece;

import java.util.ArrayList;

public class Knight extends ChessPiece{
    
    public Knight(boolean color) {
        super(color);
        value = 3;
    }

    public Knight clone() {
        return new Knight(color);
    }

    public String toString() {
        if(color == Piece.WHITE)
            return "N";
        else
            return "n";
    }

    public ArrayList<Move> getMoves(Board b, int x, int y) {
        ArrayList<Move> moves = new ArrayList<Move>();

        // NNE
        if(valid(x+1, y+2) &&
                (!b.getSquare(x+1, y+2).getOccupied() ||
                        (b.getSquare(x+1, y+2).getOccupied() && b.getSquare(x+1, y+2).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x+1, y+2));

        // ENE
        if(valid(x+2, y+1) &&
                (!b.getSquare(x+2, y+1).getOccupied() ||
                        (b.getSquare(x+2, y+1).getOccupied() && b.getSquare(x+2, y+1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x+2, y+1));

        // ESE
        if(valid(x+2,y-1) &&
                (!b.getSquare(x+2,y-1).getOccupied() ||
                        (b.getSquare(x+2,y-1).getOccupied() && b.getSquare(x+2,y-1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x+2,y-1));


        // SSE
        if(valid(x+1,y-2) &&
                (!b.getSquare(x+1,y-2).getOccupied() ||
                        (b.getSquare(x+1,y-2).getOccupied() && b.getSquare(x+1,y-2).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x+1,y-2));

        // SSW
        if(valid(x-1,y-2) &&
                (!b.getSquare(x-1,y-2).getOccupied() ||
                        (b.getSquare(x-1,y-2).getOccupied() && b.getSquare(x-1,y-2).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x-1,y-2));

        // WSW
        if(valid(x-2,y-1) &&
                (!b.getSquare(x-2,y-1).getOccupied() ||
                        (b.getSquare(x-2,y-1).getOccupied() && b.getSquare(x-2,y-1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x-2,y-1));

        // WNW
        if(valid(x-2,y+1) &&
                (!b.getSquare(x-2,y+1).getOccupied() ||
                        (b.getSquare(x-2,y+1).getOccupied() && b.getSquare(x-2,y+1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x-2,y+1));

        // NNW
        if(valid(x-1,y+2) &&
                (!b.getSquare(x-1,y+2).getOccupied() ||
                        (b.getSquare(x-1,y+2).getOccupied() && b.getSquare(x-1,y+2).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x-1,y+2));

        return moves;
    }
}
