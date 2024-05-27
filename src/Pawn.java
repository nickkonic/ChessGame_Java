import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {
    private boolean firstMove;

    public Pawn(Point position, String name) {
        super(position, name);
        firstMove = true;
    }

    @Override
    public List<Point> getPossibleMoves(Piece[][] board) {
        List<Point> moves = new ArrayList<>();
        int x = position.x;
        int y = position.y;

        // Pawn moves
        int direction = firstMove ? 2 : 1;
        for (int i = 1; i <= direction; i++) {
            if (isValidMove(x, y + i, board)) {
                moves.add(new Point(x, y + i));
            } else {
                break;
            }
        }
        firstMove = false;
        return moves;
    }

    private boolean isValidMove(int x, int y, Piece[][] board) {
        return x >= 0 && x < board[0].length && y >= 0 && y < board.length && board[y][x] == null;
    }
}