import MazeZ.Engine.GameObject;

import MazeZ.Graphics.Position;
import com.sun.tools.javac.api.ClientCodeWrapper;

import static org.junit.Assert.*;

/**
 * Created by Tapa on 7/25/16.
 */
public class GameObjectTest
{

    @org.junit.Test
    public void testGetPosition()
    {
        GameObject expected = new GameObject(new Position(2,4));
        GameObject actual = new GameObject(new Position(2,4));

        assertEquals(expected, actual);

    }

    @org.junit.Test
    public void testSetPosition()
    {
        GameObject expected = new GameObject(new Position(2, 4));
        GameObject actual = new GameObject(new Position(2, 4));

        assertEquals(expected, actual);


    }

    @org.junit.Test
    public void testMove()
    {
        GameObject expected = new GameObject(new Position(1,2));
        GameObject actual = new GameObject(new Position(0,0));
        actual.move(new Position(1,2));

        assertEquals(expected, actual);
    }



}