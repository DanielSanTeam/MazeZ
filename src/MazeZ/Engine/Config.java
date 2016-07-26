package MazeZ.Engine;

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

	private Config()
	{
	}
}
