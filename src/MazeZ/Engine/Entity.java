package MazeZ.Engine;



import MazeZ.Graphics.Drawable;
import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

/**
 * Created by lukit on 7/25/2016.
 */
public class Entity extends GameObject implements Drawable
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

	@Override
	public void draw(RenderWindow target)
	{
		// TODO Auto-generated method stub
		
	}
}
