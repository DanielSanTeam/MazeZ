package MazeZ.Engine;

import MazeZ.Engine.GameObject;
import MazeZ.Graphics.Drawable;

/**
 * Created by lukit on 7/25/2016.
 */
public class Map extends GameObject implements Drawable
{
	private char mMapContent[][];

	static final char START_CHAR = '*';
	static final char END_CHAR = '#';

	@Override
	public void draw(RenderWindow target)
	{

	}
}
