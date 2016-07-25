import MazeZ.Graphics.Position;

import static org.junit.Assert.*;

/**
 * Created by Andrew Hunsaker on 7/25/16.
 */
public class PositionTest {
    private Position p = new Position(0, 0);

    @org.junit.Test
    public void testAdd() {
        Position expected = new Position(5, 5);
        Position actual = p.add(new Position(5,5));
        assertEquals(expected, actual);

    }

    @org.junit.Test
    public void testStaticAdd() {
        Position expected = new Position(10, 10);
        Position actual = Position.add(new Position(5,5), new Position(5,5));
        assertEquals(expected, actual);

    }

    @org.junit.Test
    public void testSubtract() {
        Position expected = new Position(-5, -5);
        Position actual = p.subtract(new Position(5,5));
        assertEquals(expected, actual);

    }

    @org.junit.Test
    public void testStaticSubtract() {
        Position expected = new Position(-10, -10);
        Position actual = p.subtract(new Position(5,5), new Position(5, 5));
        assertEquals(expected, actual);

    }

}