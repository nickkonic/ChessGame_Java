import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class King extends Piece {

    public King(Point position, String name) {
        super(position, name);
    }

    @Override
    public List<Point> getPossibleMoves(Piece[][] board) {
        List<Point> moves = new ArrayList<>();
        int x = position.x;
        int y = position.y;

        // King moves (one square in any direction)
        int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};
        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (isValidMove(newX, newY, board)) {
                moves.add(new Point(newX, newY));
            }
        }
        return moves;
    }

    private boolean isValidMove(int x, int y, Piece[][] board) {
        return x >= 0 && x < board[0].length && y >= 0 && y < board.length && board[y][x] == null;
    }
}
