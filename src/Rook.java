import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Point position, String name) {
        super(position, name);
    }

    @Override
    public List<Point> getPossibleMoves(Piece[][] board) {
        List<Point> moves = new ArrayList<>();
        int x = position.x;
        int y = position.y;

        // Rook moves (horizontal and vertical)
        for (int i = 0; i < board.length; i++) {
            if (isValidMove(x, i, board)) {
                moves.add(new Point(x, i));
            }
            if (isValidMove(i, y, board)) {
                moves.add(new Point(i, y));
            }
        }
        return moves;
    }

    private boolean isValidMove(int x, int y, Piece[][] board) {
        return x >= 0 && x < board[0].length && y >= 0 && y < board.length && board[y][x] == null;
    }
}
