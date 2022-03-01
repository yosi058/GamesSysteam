package MainGame;

import BoardGame.Board;

import java.util.Scanner;

public class ConsoleIo implements Iconnect {
    private String game;
    private String player;
    private Scanner scanner;

    public ConsoleIo() {
        this.scanner = new Scanner(System.in);
        this.menu();
    }

    @Override
    public void menu() {

        System.out.println("hi!welcome :");
        System.out.println("please choose a game:" +
                "1:chess" +
                "2:.. ");
        this.game = scanner.nextLine();  // Read user input
        System.out.println("please choose a player:" +
                "1:computer" +
                "2:.. ");
        this.player = scanner.nextLine();  // Read user input
    }

    @Override
    public int getTypeGame() {
        return Integer.parseInt(this.game);
    }

    @Override
    public int getTypePlayer() {
        return Integer.parseInt(this.player);
    }

    @Override
    public String getMove(Board board) {
        board.presentBoard();
        System.out.println("Please choose a move by this format - start,end");
        return scanner.nextLine();
    }
}
