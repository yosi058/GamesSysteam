package BoardFactory;
import BoardGame.Board;
import java.util.HashMap;

public class BoardFactory {
    HashMap<Integer, Creator> BoardCreator;
    public BoardFactory() {
        BoardCreator = new HashMap<Integer, Creator>();
        BoardCreator.put(3,new BackgammonBoardFactory());
        BoardCreator.put(2,new CheckersBoardFactory());
        BoardCreator.put(1,new ChessBoardFactory());
    }
    public Board createBoard(int Type) {
        return BoardCreator.get(Type).create();
    }

}
