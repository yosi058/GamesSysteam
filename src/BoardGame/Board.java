package BoardGame;

public interface Board{

    Square getSquare(int x, int y);

    boolean gameOver(int color);

    void updateBoard(int x1, int y1, int x2, int y2);
    Square[][] getBoard();

    Iterator getIterator();
}
