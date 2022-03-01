package BoardGame;

import Pieces.Piece;

public class Square {

    private Piece piece;
    private boolean occupied;

    public Square() {
        this.occupied = false;
    }
    public Square(Piece piece) {
        this.occupied = true;
        this.piece = piece;
    }
    public Square(Square square) {
        this.occupied = square.getOccupied();
        this.piece = square.getOccupied() ? square.getPiece().clone() : null;
    }
    public boolean getOccupied(){
        return this.occupied;
    }
    public void setOccupied(boolean occupied){
        this.occupied = occupied;
    }
    public void setPiece(Piece piece) {
        this.piece = piece;
    }
    public Piece getPiece(){
        return  this.piece;
    }
    public String toString() {
        if(occupied)
            return piece.toString();
        else
            return ".";
    }
}
