package MazeZ.Engine;

public class Item
{
	private int mID;
	
	public abstract void use(Player p);
	
	public int getId(){
		return mID;
			
	}

}
