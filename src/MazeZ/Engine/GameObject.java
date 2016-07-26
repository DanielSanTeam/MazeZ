package MazeZ.Engine;

import MazeZ.Graphics.Position;

/**
 * Created by Tapa on 7/25/16.
 */
public abstract class GameObject
{
    protected Position mPos;

    public GameObject()
    {
        this(new Position());
    }

    public GameObject(Position pos)
    {
        mPos = pos;
    }

    public Position getPosition() {
        return mPos;
    }

    public void setPosition(Position pos) {
        this.mPos = pos;
    }

    public void move(Position pos)
    {
        mPos.add(pos);
    }
}
