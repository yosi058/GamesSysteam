package MainGame;

import BoardGame.Board;

public interface Iconnect {
     void menu();
     int getTypeGame();
     int getTypePlayer();
     String getMove(Board board,int turn);
     void showBoard(Board board,int turn);
     void showWinner(int turn);
}
