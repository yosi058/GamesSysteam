package Pieces.ChessPieces;

import BoardGame.Board;
import BoardGame.Move;
import Pieces.Piece;

import java.util.ArrayList;

public class King extends ChessPiece{
    boolean hasMoved = false;

    /**
     *
     */
    public King(boolean color) {
        super(color);
        value = 0;
    }

    public King(boolean color, boolean hasMoved) {
        super(color);
        this.hasMoved = hasMoved;
        value = 0;
    }

    public King clone() {
        return new King(color, hasMoved);
    }

    public String toString() {
        if(color == Piece.WHITE)
            return "K";
        else
            return "k";
    }

    public ArrayList<Move> getMoves(Board b, int x, int y) {
        ArrayList<Move> moves = new ArrayList<Move>();

        // N
        if(valid(x, y+1) &&
                (!b.getSquare(x, y+1).getOccupied() ||
                        (b.getSquare(x, y+1).getOccupied() && b.getSquare(x, y+1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x,y+1));

        // NE
        if(valid(x+1, y+1) &&
                (!b.getSquare(x+1, y+1).getOccupied() ||
                        (b.getSquare(x+1, y+1).getOccupied() && b.getSquare(x+1, y+1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x+1,y+1));

        // E
        if(valid(x+1,y) &&
                (!b.getSquare(x+1,y).getOccupied() ||
                        (b.getSquare(x+1,y).getOccupied() && b.getSquare(x+1,y).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x+1,y));


        // SE
        if(valid(x+1,y-1) &&
                (!b.getSquare(x+1,y-1).getOccupied() ||
                        (b.getSquare(x+1,y-1).getOccupied() && b.getSquare(x+1,y-1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x+1,y-1));

        // S
        if(valid(x,y-1) &&
                (!b.getSquare(x,y-1).getOccupied() ||
                        (b.getSquare(x,y-1).getOccupied() && b.getSquare(x,y-1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x,y-1));

        // SW
        if(valid(x-1,y-1) &&
                (!b.getSquare(x-1,y-1).getOccupied() ||
                        (b.getSquare(x-1,y-1).getOccupied() && b.getSquare(x-1,y-1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x-1,y-1));

        // W
        if(valid(x-1,y) &&
                (!b.getSquare(x-1,y).getOccupied() ||
                        (b.getSquare(x-1,y).getOccupied() && b.getSquare(x-1,y).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x-1,y));

        // NW
        if(valid(x-1,y+1) &&
                (!b.getSquare(x-1,y+1).getOccupied() ||
                        (b.getSquare(x-1,y+1).getOccupied() && b.getSquare(x-1,y+1).getPiece().getColor() != color)))
            moves.add(new Move(x,y,x-1,y+1));

        // Castling a=0, b=1, c=2, d=3, e=4, f=5, g=6, h=7
        if(color == Piece.WHITE) {
            if(!hasMoved && x == 4 && y == 0) {
                if(!b.getSquare(5, 0).getOccupied() &&
                        !b.getSquare(6, 0).getOccupied() &&
                        b.getSquare(7, 0).getOccupied() &&
                        b.getSquare(7, 0).getPiece().toString().equals("R"))
                    moves.add(new Move(x,y,x+2,y));


            }
            else
                hasMoved = true;
        }
        else { // color == Piece.BLACK
            if(!hasMoved && x == 4 && y == 8-1) {

            }
            else
                hasMoved = true;
        }


        // TODO King cannot move into open fire


        return moves;
    }
}
