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
	int currentLevel;

	public final char BLOCK_CHAR = '@';
	public final char SECRET_CHAR = 'X';
	public final char SPAWN_CHAR = '*';
	public final char END_CHAR = '#';

	private Config()
	{
		currentLevel = 0;

		maps = new ArrayList<>();

		// Load map files
		maps.add(new Map("maps/Tutorial.txt"));
		maps.add(new Map("maps/MazeRayme.txt"));
		maps.add(new Map("maps/MazeTapa.txt"));
		maps.add(new Map("maps/MazeEddy.txt"));
		maps.add(new Map("maps/MazeDrew.txt"));
		maps.add(new Map("maps/End.txt"));
		maps.add(new Map("maps/MazeRandom.txt"));
	}

	public void nextLevel()
	{
		++currentLevel;
		if(currentLevel == maps.size())
		{
			--currentLevel;
		}
	}

	public Map getMap()
	{
		return maps.get(currentLevel);
	}
}
