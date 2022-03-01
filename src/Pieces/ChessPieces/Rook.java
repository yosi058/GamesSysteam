package Pieces.ChessPieces;

import BoardGame.Board;
import BoardGame.Move;
import Pieces.Piece;

import java.util.ArrayList;

public class Rook extends ChessPiece{

    public Rook(boolean color) {
        super(color);
        value = 5;
    }

    public String toString() {
        if(color == Piece.WHITE)
            return "R";
        else
            return "r";
    }

    public Rook clone() {
        return new Rook(color);
    }


    public ArrayList<Move> getMoves(Board b, int x, int y) {
        ArrayList<Move> moves = new ArrayList<Move>();

        // up
        for(int i = 1; i < 8; i++) {
            if(valid(x, y+i)) {
                if(b.getSquare(x, y+i).getOccupied()) {
                    if(b.getSquare(x, y+i).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x,y+i));

                    break;
                }
                else
                    moves.add(new Move(x,y,x,y+i));
            }
        }

        // down
        for(int i = 1; i < 8; i++) {
            if(valid(x, y-i)) {
                if(b.getSquare(x, y-i).getOccupied()) {
                    if(b.getSquare(x, y-i).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x,y-i));

                    break;
                }
                else
                    moves.add(new Move(x,y,x,y-i));
            }
        }

        // left
        for(int i = 1; i < 8; i++) {
            if(valid(x-i, y)) {
                if(b.getSquare(x-i, y).getOccupied()) {
                    if(b.getSquare(x-i, y).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x-i,y));

                    break;
                }
                else
                    moves.add(new Move(x,y,x-i,y));
            }
        }

        // right
        for(int i = 1; i < 8; i++) {
            if(valid(x+i, y)) {
                if(b.getSquare(x+i, y).getOccupied()) {
                    if(b.getSquare(x+i, y).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x+i,y));

                    break;
                }
                else
                    moves.add(new Move(x,y,x+i,y));
            }
        }


        return moves;
    }
}
