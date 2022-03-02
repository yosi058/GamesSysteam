package MainGame;

import BoardGame.Board;
import BoardGame.Move;
import BoardGame.Square;

import java.util.Random;

public class ComputerPlayer extends Iplayer {
    private Iconnect iconnect;

    public ComputerPlayer(Iconnect i) {

        this.iconnect = i;
        counter = new Counter();
    }

    @Override
    public Move getMove(Board board, int turn) {
        iconnect.showBoard(board,turn);
        Random rand = new Random();
        boolean color = true;
        if (turn == 0) {
            color = false;
        }
        Square[][] squares = board.getBoard();
        while (true) {
            int x = rand.nextInt(7);
            int y = rand.nextInt(7);
            if (squares[x][y].getPiece() != null) {
                if (squares[x][y].getPiece().getColor() == color) {
                    return new Move(squares[x][y].getPiece().getMoves(board, x, y).get(0));
                }
            }
        }
    }

    @Override
    public Counter getCounter() {
        return this.counter;
    }
}
