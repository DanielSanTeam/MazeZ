package MazeZ.Engine;

import MazeZ.Graphics.Position;

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
