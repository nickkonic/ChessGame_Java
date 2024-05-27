import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Queen extends Piece {

    public Queen(Point position, String name) {
        super(position, name);
    }

    @Override
    public List<Point> getPossibleMoves(Piece[][] board) {
        List<Point> moves = new ArrayList<>();
        int x = position.x;
        int y = position.y;

        // Queen moves (horizontal, vertical, diagonal)
        for (int i = 0; i < board.length; i++) {
            if (isValidMove(x, i, board)) {
                moves.add(new Point(x, i));
            }
            if (isValidMove(i, y, board)) {
                moves.add(new Point(i, y));
            }
        }
        for (int i = 1; i < board.length; i++) {
            if (isValidMove(x + i, y + i, board)) {
                moves.add(new Point(x + i, y + i));
            }
            if (isValidMove(x - i, y + i, board)) {
                moves.add(new Point(x - i, y + i));
            }
            if (isValidMove(x + i, y - i, board)) {
                moves.add(new Point(x + i, y - i));
            }
            if (isValidMove(x - i, y - i, board)) {
                moves.add(new Point(x - i, y - i));
            }
        }
        return moves;
    }

    private boolean isValidMove(int x, int y, Piece[][] board) {
        return x >= 0 && x < board[0].length && y >= 0 && y < board.length && board[y][x] == null;
    }
}
