import javax.swing.*;

public class ChessGame extends JFrame {
    public ChessGame() {
        setTitle("Chess Game");
        setSize(616, 639);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        ChessBoardPanel boardPanel = new ChessBoardPanel();
        add(boardPanel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessGame game = new ChessGame();
            game.setVisible(true);
        });
    }
}