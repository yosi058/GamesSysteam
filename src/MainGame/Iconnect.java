package MainGame;

import BoardGame.Board;

//public interface Iconnect  {
//     void menu();
//     int getTypeGame();
//     int getTypePlayer();
//     String getMove(Board board,int turn);
//     void showBoard(Board board,int turn);
//     void showWinner(int turn);
//}
public abstract class Iconnect implements Observer  {
    abstract void  menu();
     abstract int getTypeGame();
     abstract int getTypePlayer();
     abstract String getMove(Board board,int turn);
     abstract  void showBoard(Board board,int turn);
     abstract void showWinner(int turn);
}
