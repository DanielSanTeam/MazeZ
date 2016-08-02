package MazeZ.Engine;



import MazeZ.Graphics.Drawable;
import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

public abstract class Entity extends GameObject implements Drawable
{
	protected int mHealth;
	protected char mSymbol;

	public Entity()
	{
		this('?', 100);
	}

	public Entity(char sym, int health)
	{
		health = mHealth;
		mSymbol = sym;

	}

	public Entity(char sym, int health, Position pos)
	{
		super(pos);
		health = mHealth;
		mSymbol = sym;
		
	}

	public boolean isAlive()
	{
		if(mHealth >= 0)
			return true;
		return false;
	}

	public void setHealth(int health)
	{
		mHealth = health;
	}

	public int getHealth()
	{
		return mHealth;
	}

	public char getSymbol()
	{
		return mSymbol;
	}

	public char getmSymbol()
	{
		return mSymbol;
	}
}
