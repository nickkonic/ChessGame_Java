import java.awt.Point;
import java.util.List;

public abstract class Piece {
    protected Point position;
    protected String name;

    public Piece(Point position, String name) {
        this.position = position;
        this.name = name;
    }

    public Point getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
    
    public void setPosition(Point position) {
    this.position = position;
    }

    public abstract List<Point> getPossibleMoves(Piece[][] board);
}
