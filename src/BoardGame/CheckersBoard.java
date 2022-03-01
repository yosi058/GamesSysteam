package BoardGame;

public class CheckersBoard implements Board{
    @Override
    public Square getSquare(int x, int y) {
        return null;
    }

    @Override
    public boolean gameOver() {
        return false;
    }

    @Override
    public void updateBoard(int x1, int y1, int x2, int y2) {

    }

    @Override
    public Square[][] getBoard() {
        return new Square[0][];
    }
}
