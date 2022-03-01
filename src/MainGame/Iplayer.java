package MainGame;

import BoardGame.Board;
import BoardGame.Move;

import java.util.ArrayList;

public abstract class Iplayer {
  protected Counter counter;
  public abstract Move getMove(Board board,int turn);
  public abstract Counter getCounter();
}
