package MazeZ.Engine;

import java.util.ArrayList;
import java.util.List;

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
		maps.add(new Map("maps/Tutorial.txt"));
		maps.add(new Map("maps/MazeRayme.txt"));
		maps.add(new Map("maps/MazeTapa.txt"));
		maps.add(new Map("maps/MazeEddy.txt"));
		maps.add(new Map("maps/MazeDrew.txt"));
		maps.add(new Map("maps/End.txt"));
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
