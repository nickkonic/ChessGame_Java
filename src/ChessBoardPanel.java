import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ChessBoardPanel extends JPanel {
    private final int TILE_SIZE = 75;
    private final int BOARD_SIZE = 8;
    private Piece[][] board;
    private Piece selectedPiece;
    private List<Point> possibleMoves;

    public ChessBoardPanel() {
        board = new Piece[BOARD_SIZE][BOARD_SIZE];
        setUpPieces();
        selectedPiece = null;
        possibleMoves = new ArrayList<>();
        setPreferredSize(new Dimension(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX() / TILE_SIZE;
                int y = e.getY() / TILE_SIZE;

                if (selectedPiece == null) {
                    selectedPiece = board[y][x];
                    if (selectedPiece != null) {
                        possibleMoves = selectedPiece.getPossibleMoves(board);
                    } else {
                        possibleMoves.clear();
                    }
                } else {
                    if (possibleMoves.contains(new Point(x, y))) {
                        // Move the piece
                        movePiece(x, y);
                        selectedPiece = null;
                        possibleMoves.clear();
                    } else {
                        selectedPiece = null;
                        possibleMoves.clear();
                   }
    }
    repaint();
}
        });
    }
    
    private void movePiece(int x, int y) {
    int oldX = selectedPiece.getPosition().x;
    int oldY = selectedPiece.getPosition().y;
    board[oldY][oldX] = null;
    board[y][x] = selectedPiece;
    selectedPiece.setPosition(new Point(x, y));
}

    private void setUpPieces() {
        // Initialize pieces for a standard chess setup (for simplicity, using only one color)
        board[0][0] = new Rook(new Point(0, 0), "Rook");
        board[0][1] = new Knight(new Point(1, 0), "Knight");
        board[0][2] = new Bishop(new Point(2, 0), "Bishop");
        board[0][3] = new Queen(new Point(3, 0), "Queen");
        board[0][4] = new King(new Point(4, 0), "King");
        board[0][5] = new Bishop(new Point(5, 0), "Bishop");
        board[0][6] = new Knight(new Point(6, 0), "Knight");
        board[0][7] = new Rook(new Point(7, 0), "Rook");
        for (int i = 0; i < BOARD_SIZE; i++) {
            board[1][i] = new Pawn(new Point(i, 1), "Pawn");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBoard(g);
        drawPieces(g);
        if (selectedPiece != null) {
            drawSelectedPiece(g);
            drawPossibleMoves(g);
        }
    }

    private void drawBoard(Graphics g) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if ((row + col) % 2 == 0) {
                    g.setColor(Color.BLACK);
                } else {
                    g.setColor(Color.lightGray);
                }
                g.fillRect(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    private void drawPieces(Graphics g) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                if (board[row][col] != null) {
                    g.setColor(Color.WHITE);
                    int x = col * TILE_SIZE;
                    int y = row * TILE_SIZE;
                    g.fillOval(x + TILE_SIZE / 4, y + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 2);
                    g.setColor(Color.BLACK);
                    g.drawString(board[row][col].getName(), x + TILE_SIZE / 4 + 5, y + TILE_SIZE / 4 + TILE_SIZE / 2);
                }
            }
        }
    }

    private void drawSelectedPiece(Graphics g) {
        g.setColor(Color.RED);
        int x = selectedPiece.getPosition().x * TILE_SIZE;
        int y = selectedPiece.getPosition().y * TILE_SIZE;
        g.fillOval(x + TILE_SIZE / 4, y + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 2);
        g.setColor(Color.BLACK);
        g.drawString(selectedPiece.getName(), x + TILE_SIZE / 4 + 5, y + TILE_SIZE / 4 + TILE_SIZE / 2);
    }

    private void drawPossibleMoves(Graphics g) {
        g.setColor(Color.GREEN);
        for (Point move : possibleMoves) {
            int x = move.x * TILE_SIZE;
            int y = move.y * TILE_SIZE;
            g.fillOval(x + TILE_SIZE / 4, y + TILE_SIZE / 4, TILE_SIZE / 2, TILE_SIZE / 2);
        }
    }
}
