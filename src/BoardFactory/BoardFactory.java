package BoardFactory;
import BoardGame.Board;
import java.util.HashMap;

public class BoardFactory {
    HashMap<Integer, IBoardCreator> BoardCreator;
    public BoardFactory() {
        BoardCreator = new HashMap<Integer, IBoardCreator>();
        BoardCreator.put(3,new BackgammonBoardCreator());
        BoardCreator.put(2,new CheckersBoardCreator());
        BoardCreator.put(1,new ChessBoardCreator());
    }
    public Board createBoard(int Type) {
        return BoardCreator.get(Type).create();
    }

}
