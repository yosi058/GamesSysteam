package MainGame;

import BoardFactory.BoardFactory;
import BoardGame.Board;

public class Main {

    public static void main(String[] args) {
        BoardFactory boardFactory = new BoardFactory();
        PlayerFactory playerFactory = new PlayerFactory();
        LogicFactory logicFactory = new LogicFactory();
        Iconnect i = new ConsoleIo();
        Iplayer player_one = playerFactory.createPlayer(i, 2);
        Iplayer player_two = playerFactory.createPlayer(i, i.getTypePlayer());
        Board board = boardFactory.createBoard(i.getTypeGame());
        GameLogic gameLogic = logicFactory.createLogic(i.getTypeGame());
        Fileobserver fileobserver =  new Fileobserver();
        Game game = new Game(board, gameLogic, player_one, player_two);
        game.addObserver(fileobserver);
        game.addObserver(i);
        game.start();
    }
}
