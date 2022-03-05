package MainGame;

import BoardGame.Board;
import BoardGame.Move;
import BoardGame.Square;

import java.util.ArrayList;

public class HumanPlayer extends Iplayer {
    private Iconnect iconnect;

    public HumanPlayer(Iconnect i) {

        this.iconnect = i;
        counter = new Counter();
    }

    @Override
    public Move getMove(Board board,int turn) {
        //print the board
        String move = iconnect.getMove(board,turn);
        String[] moves = move.split(",");
        ArrayList<Integer> indexs = convertMove(moves[0].toCharArray());
        int x = indexs.get(1);
        int y = indexs.get(0);
        indexs = convertMove(moves[1].toCharArray());
        int x2 = indexs.get(1);
        int y2 = indexs.get(0);
        return new Move(x,y,x2,y2);
    }

    @Override
    public Counter getCounter() {
        return this.counter;
    }
    public Iconnect getIconnect() {
         return this.iconnect;
    }
//    private boolean checkValid(int x, int y, int x2, int y2, ArrayList<Move> valid_moves) {
//        for (Move move : valid_moves) {
//            if ((x == move.getX1()) && (x2 == move.getX2()) && (y == move.getY1()) && (y2 == move.getY2())){
//                return true;
//            }
//        }
//        return false;
//    }

    private ArrayList<Integer> convertMove(char[] toCharArray) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (char s : toCharArray) {
            if ((s >= 'A') && (s <= 'H')) {
                temp.add(s - 65);
            } else if ((s >= '1') && (s <= '8')) {
                temp.add(8-(s - 48));
            }
        }
        return temp;
    }
}
