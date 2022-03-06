package MainGame;

import BoardGame.Board;
import BoardGame.Iterator;
import BoardGame.Square;

import java.util.Scanner;

public class ConsoleIo extends Iconnect {
    private String game;
    private String player;
    private Scanner scanner;
    private int score1;
    private int score2;

    public ConsoleIo() {
        this.scanner = new Scanner(System.in);
        score1 = score2 = 0;
        this.menu();
    }

    @Override
    public void menu() {

        System.out.println("Hi!welcome to the Board-Games:");
        System.out.println("Please choose a game to play:\n" +
                "1:Chess-Game\n" +
                "2:Backgammon-Game\n" +
                "3:Checkers-Game");
        this.game = scanner.nextLine();  // Read user input
        System.out.println("Please choose a player to play against:\n" +
                "1:Computer-player\n" +
                "2:Human-player\n" +
                "3:Practice");
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
        System.out.print("The score is:\n" +
                "WHITE:" + this.score1 + "\n" + "BLACK:" + this.score2 + "\n");
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
    public String getMove(Board board, int turn) {
        this.showBoard(board, turn);
        System.out.println("Please choose a move by this format - start,end.For example:A3,A5");
        return scanner.nextLine();
    }

    public void showWinner(int turn) {
        if (turn == 1) {
            System.out.println("The black player wins-the score is !" + this.score1);
        } else {
            System.out.println("The white player wins-the score is!" + this.score2);
        }
    }

    @Override
    public void update(int score1, int score2) {
        if ((this.score1 != score1) || (this.score2 != score2)) {
            this.score1 = score1;
            this.score2 = score2;
        }
    }
}

