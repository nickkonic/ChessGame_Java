import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {

    public Knight(Point position, String name) {
        super(position, name);
    }

    @Override
    public List<Point> getPossibleMoves(Piece[][] board) {
        List<Point> moves = new ArrayList<>();
        int x = position.x;
        int y = position.y;

        // Knight moves
        int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
        int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
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
