package MainGame;

public class LogicFactory {

    public GameLogic createLogic(int type) {
        if (type == 1) {
            return new ChessLogic();
        }
        return null;
    }
}
