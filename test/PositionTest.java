import MazeZ.Graphics.Position;

import static org.junit.Assert.*;

/**
 * Created by Andrew Hunsaker on 7/25/16.
 */
public class PositionTest {
    private Position p;

    @org.junit.Test
    public void testAdd() {
        p = new Position();
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
        p = new Position();
        Position expected = new Position(-5, -5);
        Position actual = p.subtract(new Position(5,5));
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void testStaticSubtract() {
        Position expected = new Position(-5, -5);
        Position actual = Position.subtract(new Position(0,0), new Position(5, 5));
        assertEquals(expected, actual);
    }

}