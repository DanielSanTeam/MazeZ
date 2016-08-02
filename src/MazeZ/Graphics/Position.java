package MazeZ.Graphics;

public class Position
{
    public int x;
    public int y;

    public Position() {
        this(0, 0);
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public Position(Position pos) {
        x = pos.x;
        y = pos.y;
    }

    public Position add(Position pos) {
        x += pos.x;
        y += pos.y;
        return this;
    }

    public static Position add(Position p1, Position p2) {
        Position result = new Position();
        result.add(p1).add(p2);
        return result;
    }

    public Position subtract(Position pos) {
        x -= pos.x;
        y -= pos.y;
        return this;
    }


    public static Position subtract(Position p1, Position p2) {
        Position result = new Position(p1);
        result.subtract(p2);
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Position position = (Position) object;

        if (x != position.x) return false;
        return y == position.y;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "MazeZ.Graphics.Position(" +
                x +
                ", " +
                y +
                ')';
    }
}
