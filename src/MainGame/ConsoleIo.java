package MainGame;

import BoardGame.Board;
import BoardGame.Iterator;
import BoardGame.Square;

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

    public void showBoard(Board board, int turn) {
        if (turn == 1) {
            System.out.print("It's White turn - play!\n");
        } else {
            System.out.print("It's black turn - play!\n");
        }
        Square[][] squares = board.getBoard();
        int columnLength = squares[0].length;
        int i = 0;
        int size = 0;
        System.out.print("----------------\n");
        System.out.print("|");
        for (Iterator iter = board.getIterator(); iter.hasNext(); ) {
            Square square = (Square) iter.next();
            String squareToPrint = square.toString();
            System.out.print(squareToPrint + " ");
            i++;
            if ((i % columnLength) == 0) {
                System.out.print("|\n");
                size++;
                if (size != columnLength) {
                    System.out.print("|");
                }
            }
        }
        System.out.print("----------------\n");
    }

    @Override
    public String getMove(Board board,int turn) {
        this.showBoard(board,turn);
        System.out.println("Please choose a move by this format - start,end");
        return scanner.nextLine();
    }
}
