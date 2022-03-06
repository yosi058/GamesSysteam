package MainGame;

import BoardGame.Board;
import BoardGame.Move;

import java.util.ArrayList;

public abstract class Iplayer implements Stragety {
  protected Counter counter;
//  public abstract Move getMove(Board board,int turn);
  public abstract Counter getCounter();
  public abstract Iconnect getIconnect();
}
