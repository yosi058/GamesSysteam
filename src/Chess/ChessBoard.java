package Chess;

import BoardGame.Board;
import BoardGame.Iterator;
import BoardGame.Move;
import BoardGame.Square;
import Pieces.ChessPieces.Bishop;
import Pieces.ChessPieces.ChessPiece;
import Pieces.ChessPieces.King;
import Pieces.ChessPieces.Knight;
import Pieces.ChessPieces.Pawn;
import Pieces.ChessPieces.Queen;
import Pieces.ChessPieces.Rook;
import Pieces.Piece;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ChessBoard implements Board {
    public static final int a = 0, b = 1, c = 2, d = 3, e = 4, f = 5, g = 6, h = 7;
    private static ChessBoard chessBoard = null;

    private Square[][] squares;

    /**
     * 8	r n b q k b n r
     * 7	p p p p p p p p
     * 6	. . . . . . . .
     * 5	. . . . . . . .
     * 4	. . . . . . . .
     * 3	. . . . . . . .
     * 2	P P P P P P P P
     * 1  R N B Q K B N R
     * <p>
     * a b c d e f g h
     * <p>
     * P=pawn, K=king, Q=queen, R=rook, N=knight, B=Bishop
     * Uppercase is white
     *
     * @param squares
     */

    private ChessBoard(Square[][] squares) {
        this.squares = squares;
    }

    /**
     *
     */
    private ChessBoard() {
        // initialize board
        boolean Color = ChessPiece.BLACK;
        squares = new Square[8][8];
//        squares[a][0] = new Square(new Rook(Color));
//        squares[b][0] = new Square(new Knight(Color));
//        squares[c][0] = new Square(new Bishop(Color));
//        squares[d][0] = new Square(new Queen(Color));
//        squares[e][0] = new Square(new King(Color));
//        squares[f][0] = new Square(new Bishop(Color));
//        squares[g][0] = new Square(new Knight(Color));
//        squares[h][0] = new Square(new Rook(Color));

        squares[a][a] = new Square(new Rook(Color));
        squares[a][b] = new Square(new Knight(Color));
        squares[a][c] = new Square(new Bishop(Color));
        squares[a][d] = new Square(new Queen(Color));
        squares[a][e] = new Square(new King(Color));
        squares[a][f] = new Square(new Bishop(Color));
        squares[a][g] = new Square(new Knight(Color));
        squares[a][h] = new Square(new Rook(Color));

        for (int i = 0; i < 8; i++) {
            squares[1][i] = new Square(new Pawn(Color));
        }

        for (int i = 2; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                squares[i][j] = new Square();
            }
        }

        Color = ChessPiece.WHITE;
//        squares[a][8 - 1] = new Square(new Rook(Color));
//        squares[b][8 - 1] = new Square(new Knight(Color));
//        squares[c][8 - 1] = new Square(new Bishop(Color));
//        squares[d][8 - 1] = new Square(new Queen(Color));
//        squares[e][8 - 1] = new Square(new King(Color));
//        squares[f][8 - 1] = new Square(new Bishop(Color));
//        squares[g][8 - 1] = new Square(new Knight(Color));
//        squares[h][8 - 1] = new Square(new Rook(Color));
//
//        for (int i = 0; i < 8; i++) {
//            squares[i][7 - 1] = new Square(new Pawn(Color));
//        }
        squares[h][a] = new Square(new Rook(Color));
        squares[h][b] = new Square(new Knight(Color));
        squares[h][c] = new Square(new Bishop(Color));
        squares[h][d] = new Square(new Queen(Color));
        squares[h][e] = new Square(new King(Color));
        squares[h][f] = new Square(new Bishop(Color));
        squares[h][g] = new Square(new Knight(Color));
        squares[h][h] = new Square(new Rook(Color));

        for (int i = 0; i < 8; i++) {
            squares[6][i] = new Square(new Pawn(Color));
        }
    }

    public static Board getInstancce() {
        if (chessBoard != null) {
            return chessBoard;
        }
        chessBoard = new ChessBoard();
        return chessBoard;
    }

    private class ChessBoardIterator implements Iterator {
        //private  Square[][] squaress;
        private int rowIndex = 0;
        private int columnIndex = 0;

        @Override
        public boolean hasNext() {
            if (rowIndex >= squares.length) {
                return false;
            }
            if (columnIndex >= squares[rowIndex].length && rowIndex == squares.length - 1) {
                return false;
            }
            return true;

        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (columnIndex >= squares[rowIndex].length) {
                rowIndex++;
                columnIndex = 0;
            }
            return squares[rowIndex][columnIndex++];
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 7; i >= 0; i--) {
            str += (i + 1) + "  ";
            for (int j = 0; j < 8; j++) {
                str += squares[j][i] + " ";
            }
            str += "\n";
        }

        str += "\n   a b c d e f g h";

        return str;
    }

    public ArrayList<Move> getMoves(boolean color) {
        return getMoves(color, true);
    }


    @Override
    public boolean gameOver(int colorValue) {
        boolean color;
        if (colorValue == 1) {
            color = true;
        } else {
            color = false;
        }
        int x = -1, y = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (squares[i][j].getOccupied() &&
                        squares[i][j].getPiece().getColor() == color &&
                        squares[i][j].getPiece().toString().equalsIgnoreCase("K")) {
                    x = i;
                    y = j;
                }
            }
        }

        // check a move if after making this move the king can be killed (moving into check)
        ArrayList<Move> opponentMoves = getMoves(!color, false);

        // check all opponent moves if they kill king (opponent moves in next round)
        for (int j = 0; j < opponentMoves.size(); j++) {
            if (opponentMoves.get(j).getX2() == x && opponentMoves.get(j).getY2() == y) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if player color is under check
     *
     * @param color
     * @param moves
     * @return
     */
    public boolean isCheckAfter(boolean color, ArrayList<Move> moves) {

        Square[][] newSquares = getTilesAfter(moves);

        int x = -1, y = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (newSquares[i][j].getOccupied() &&
                        newSquares[i][j].getPiece().getColor() == color &&
                        newSquares[i][j].getPiece().toString().equalsIgnoreCase("K")) {
                    x = i;
                    y = j;
                }
            }
        }

        // check a move if after making this move the king can be killed (moving into check)
        ArrayList<Move> opponentMoves = getMovesAfter(!color, moves, false);

        // check all opponent moves if they kill king (opponent moves in next round)
        for (int j = 0; j < opponentMoves.size(); j++) {
            if (opponentMoves.get(j).getX2() == x && opponentMoves.get(j).getY2() == y) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Move> getMoves(boolean color, boolean checkCheck) {
        ArrayList<Move> moves = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (squares[i][j].getOccupied() &&
                        squares[i][j].getPiece().getColor() == color) {
                    moves.addAll(squares[i][j].getPiece().getMoves(this, i, j));
                }
            }
        }

        // check if move is valid (must not be check after move) and throw away erroneous moves
        if (checkCheck) {
            // find king (of correct color)
            int x = -1, y = -1;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (squares[i][j].getOccupied() &&
                            squares[i][j].getPiece().getColor() == color &&
                            squares[i][j].getPiece().toString().equalsIgnoreCase("K")) {
                        x = i;
                        y = j;
                    }
                }
            }

            ArrayList<Move> removeThese = new ArrayList<Move>();
            for (int i = 0; i < moves.size(); i++) {
                // check a move if after making this move the king can be killed (moving into check)
                ArrayList<Move> checkThis = new ArrayList<Move>(moves.subList(i, i + 1));
                ArrayList<Move> opponentMoves = getMovesAfter(!color, checkThis, false);

                int xUpdated = x, yUpdated = y;
                if (checkThis.get(0).getX1() == x && checkThis.get(0).getY1() == y) { // get updated king position
                    xUpdated = checkThis.get(0).getX2();
                    yUpdated = checkThis.get(0).getY2();
                }

                // check all opponent moves if they kill king (opponent moves in next round)
                for (int j = 0; j < opponentMoves.size(); j++) {
                    if (opponentMoves.get(j).getX2() == xUpdated && opponentMoves.get(j).getY2() == yUpdated) {
                        removeThese.add(checkThis.get(0));
                    }
                }
            }

            moves.removeAll(removeThese); // remove invalid moves
        }
        Collections.shuffle(moves);
        return moves;
    }

    public ArrayList<Move> getMovesAfter(boolean color, ArrayList<Move> moves) {
        return getMovesAfter(color, moves, true);
    }

    public ArrayList<Move> getMovesAfter(boolean color, ArrayList<Move> moves, boolean checkCheck) {

        Square[][] temp = new Square[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                temp[x][y] = new Square(this.squares[x][y]);
            }
        }

        ChessBoard b = new ChessBoard(temp);

        for (int i = 0; i < moves.size(); i++) {
            b.makeMove(moves.get(i));
        }

        ArrayList<Move> futureMoves = b.getMoves(color, checkCheck);

        return futureMoves;
    }

    public Square[][] getTilesAfter(ArrayList<Move> moves) {

        Square[][] temp = new Square[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                temp[x][y] = new Square(this.squares[x][y]);
            }
        }

        ChessBoard b = new ChessBoard(temp);

        for (int i = 0; i < moves.size(); i++) {
            b.makeMove(moves.get(i));
        }

        Square[][] temp2 = new Square[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                temp2[x][y] = new Square(b.getSquare(x, y));
            }
        }

        return temp2;
    }

    /**
     * @param m
     * @return -1 if black wins
     * 1 if white wins
     * 0 if game continues
     */
    public int makeMove(Move m) {
        Square oldSquare = squares[m.getX1()][m.getY1()];

        squares[m.getX2()][m.getY2()] = squares[m.getX1()][m.getY1()];
        squares[m.getX1()][m.getY1()] = new Square();

        if (m.isCastling()) {
            if (m.getX2() == g && m.getY2() == 1 - 1) {
                squares[f][1 - 1] = squares[h][1 - 1];
                squares[h][1 - 1] = new Square();
            }
            if (m.getX2() == c && m.getY2() == 1 - 1) {
                squares[d][1 - 1] = squares[a][1 - 1];
                squares[a][1 - 1] = new Square();
            }
            if (m.getX2() == g && m.getY2() == 8 - 1) {
                squares[f][8 - 1] = squares[h][8 - 1];
                squares[h][8 - 1] = new Square();
            }
            if (m.getX2() == c && m.getY2() == 8 - 1) {
                squares[d][8 - 1] = squares[a][8 - 1];
                squares[a][8 - 1] = new Square();
            }
        }

        // pawn at top?
        if (oldSquare.getPiece().toString().equals("P") && m.getY2() == 8 - 1) {
            squares[m.getX2()][m.getY2()] = new Square(new Queen(Piece.WHITE));
        }

        if (oldSquare.getPiece().toString().equals("p") && m.getY2() == 1 - 1) {
            squares[m.getX2()][m.getY2()] = new Square(new Queen(Piece.BLACK));
        }

        return 0;
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

//    @Override
//    public boolean gameOver() {
//        return false;
//    }

    @Override
    public void updateBoard(int x1, int y1, int x2, int y2) {
        Piece piece = squares[x1][y1].getPiece();
        squares[x1][y1] = new Square();
        squares[x2][y2] = new Square(piece);
    }

    @Override
    public Square[][] getBoard() {
        return squares.clone();
    }

    @Override
    public Iterator getIterator() {
        return new ChessBoardIterator();
    }
}
