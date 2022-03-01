package Pieces.ChessPieces;

import BoardGame.Move;
import BoardGame.Board;
import Chess.ChessBoard;
import Pieces.Piece;

import java.util.ArrayList;

public class Bishop extends ChessPiece{

    public Bishop(boolean color) {
        super(color);
        value = 3;
    }

    @Override
    public Piece clone() {
        return new Bishop(this.color);
    }

    @Override
    public ArrayList<Move> getMoves(Board b, int x, int y) {
        ArrayList<Move> moves = new ArrayList<Move>();


        // NE
        for(int i = 1; i < 8; i++) {
            if(valid(x+i, y+i)) {
                if(b.getSquare(x+i, y+i).getOccupied()) {
                    if(b.getSquare(x+i, y+i).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x+i,y+i));

                    break;
                }
                else
                    moves.add(new Move(x,y,x+i,y+i));
            }
        }

        // NW
        for(int i = 1; i < 8; i++) {
            if(valid(x-i, y+i)) {
                if(b.getSquare(x-i, y+i).getOccupied()) {
                    if(b.getSquare(x-i, y+i).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x-i,y+i));

                    break;
                }
                else
                    moves.add(new Move(x,y,x-i,y+i));
            }
        }

        // SE
        for(int i = 1; i < 8; i++) {
            if(valid(x+i, y-i)) {
                if(b.getSquare(x+i, y-i).getOccupied()) {
                    if(b.getSquare(x+i, y-i).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x+i,y-i));

                    break;
                }
                else
                    moves.add(new Move(x,y,x+i,y-i));
            }
        }

        // SW
        for(int i = 1; i < 8; i++) {
            if(valid(x-i, y-i)) {
                if(b.getSquare(x-i, y-i).getOccupied()) {
                    if(b.getSquare(x-i, y-i).getPiece().getColor() != color)
                        moves.add(new Move(x,y,x-i,y-i));

                    break;
                }
                else
                    moves.add(new Move(x,y,x-i,y-i));
            }
        }

        return moves;
    }
}
