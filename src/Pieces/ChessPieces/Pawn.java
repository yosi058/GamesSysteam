package Pieces.ChessPieces;

import BoardGame.Board;
import BoardGame.Move;
import Pieces.Piece;

import java.util.ArrayList;

public class Pawn extends ChessPiece{

    public Pawn(boolean color) {
        super(color);
        value = 1;
    }

    public Pawn clone() {
        return new Pawn(color);
    }

    public String toString() {
        if(color == Piece.WHITE)
            return "P";
        else
            return "p";
    }

    /**
     * @param b Board
     * @param x x location of piece
     * @param y y location of piece
     * @return
     */
    public ArrayList<Move> getMoves(Board b, int x, int y) {
        ArrayList<Move> moves = new ArrayList<Move>();

        if(color == Piece.WHITE) {
            // forward
            if(valid(x,y+1) && !b.getSquare(x, y+1).getOccupied())
                moves.add(new Move(x,y,x,y+1));

            // kill diagonally
            if(valid(x+1,y+1) && b.getSquare(x+1, y+1).getOccupied() && b.getSquare(x+1, y+1).getPiece().getColor() != color)
                moves.add(new Move(x,y,x+1,y+1));

            // kill diagonally
            if(valid(x-1,y+1) && b.getSquare(x-1, y+1).getOccupied() && b.getSquare(x-1, y+1).getPiece().getColor() != color)
                moves.add(new Move(x,y,x-1,y+1));
        }
        else {
            // forward
            if(valid(x,y-1) && !b.getSquare(x, y-1).getOccupied())
                moves.add(new Move(x,y,x,y-1));

            // kill diagonally
            if(valid(x+1,y-1) && b.getSquare(x+1, y-1).getOccupied() && b.getSquare(x+1, y-1).getPiece().getColor() != color)
                moves.add(new Move(x,y,x+1,y-1));

            // kill diagonally
            if(valid(x-1,y-1) && b.getSquare(x-1, y-1).getOccupied() && b.getSquare(x-1, y-1).getPiece().getColor() != color)
                moves.add(new Move(x,y,x-1,y-1));
        }

        return moves;
    }
}
