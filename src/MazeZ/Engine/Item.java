package MazeZ.Engine;

public abstract class Item extends Entity
{
	private int mID;
	
	public abstract void use(Player p);
	
	public int getId(){
		return mID;
	}

}
