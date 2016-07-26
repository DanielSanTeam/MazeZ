package MazeZ.Engine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukit on 7/25/2016.
 */
public class Config
{
	private static Config ourInstance = new Config();

	public static Config getInstance()
	{
		return ourInstance;
	}

	private List<Map> maps;
	private int mCurrentLevel;

	private Config()
	{
		mCurrentLevel = 0;

		maps = new ArrayList<>();

		// Load map files
		maps.add(new Map("maps/MazeEddy.txt"));
		maps.add(new Map("maps/TestMaze.txt"));
	}

	public void nextLevel()
	{
		++mCurrentLevel;
		if(mCurrentLevel == maps.size())
		{
			--mCurrentLevel;
		}
	}

	public Map getMap()
	{
		return maps.get(mCurrentLevel);
	}
}
