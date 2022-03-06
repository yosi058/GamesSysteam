package MainGame;

import BoardGame.Board;
import BoardGame.Move;

import java.util.LinkedList;

public class Game implements Iobserable {
    private GameLogic gameLogic;
    private Board board;
    private Iplayer playerA;
    private Iplayer playerB;
    private int turn = 1;
    //    public static final boolean color = t
    private LinkedList<Observer> observers = new LinkedList<>();

    public Game(Board b, GameLogic g, Iplayer A, Iplayer B) {
        this.board = b;
        this.gameLogic = g;
        this.playerA = A;
        this.playerB = B;
    }

    public Iplayer getcurrentplayer(int x) {
        if (x == 1) {
            return this.playerA;
        }
        return this.playerB;
    }

    public void start() {
        while (!gameLogic.isFinish(board, turn)) {
            Move move = getcurrentplayer(turn).getMove(board, turn);
            if (gameLogic.isLeagl(board, move)) {
                getcurrentplayer(turn).getCounter().increase(gameLogic.getVal(board, move));
                notifyall();
                gameLogic.updateBoard(board, move);
                if (turn == 1) {
                    turn = 0;
                } else {
                    turn = 1;
                }
            }
        }
        notifyall();
        getcurrentplayer(turn).getIconnect().showWinner(turn);
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyall() {
        for (Observer o : observers) {
            o.update(this.playerA.getCounter().getCount(), this.playerB.getCounter().getCount());
        }
    }
}

