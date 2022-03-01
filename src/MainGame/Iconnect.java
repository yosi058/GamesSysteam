package MainGame;

import BoardGame.Board;

public interface Iconnect {
     void menu();
     int getTypeGame();
     int getTypePlayer();
     String getMove(Board board);
}
