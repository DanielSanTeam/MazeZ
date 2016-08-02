package MazeZ.Engine;

import MazeZ.Graphics.Drawable;
import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lukit on 7/25/2016.
 */
public class Map extends GameObject implements Drawable
{
	private char mMapContent[][];

	static final char START_CHAR = '*';
	static final char END_CHAR = '#';

	public Map(Map m)
	{
		int xLength = m.mMapContent.length;
		int yLength = m.mMapContent[0].length;
		mMapContent = new char[xLength][yLength];

		for(int v = 0; v < yLength; ++v)
		{
			for(int u = 0; u < xLength; ++u)
			{
				mMapContent[u][v] = m.mMapContent[u][v];
			}
		}

		mPos = m.mPos;
	}

	public Map(String filename)
	{
		File mapfile = new File(filename);

		List<String> lines = new ArrayList<>();

		try (BufferedReader in = new BufferedReader(new FileReader(mapfile)))
		{
			String line;
			while((line = in.readLine()) != null)
			{
				lines.add(line);
			}

			int width = 0;
			int height = 0;

			if(lines.size() != 0)
			{
				height = lines.size();
				width = lines.get(0).length();
			}

			mMapContent = new char[width][height];

			for(int v = 0; v < height; ++v)
			{
				for(int u = 0; u < width; ++u)
				{
					mMapContent[u][v] = lines.get(v).charAt(u);
				}
			}

			in.close();
		}
		catch (Exception e)
		{
			System.err.printf("Error trying to read from mapfile: %s%n", filename);
		}
	}

	public char getChar(int x, int y)
	{
		try
		{
			return mMapContent[x][y];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return ' ';
		}
	}

	public void setChar(int x, int y, char c)
	{
		try
		{
			mMapContent[x][y] = c;
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			// Do Nothing
		}
	}

	public Position getStartPosition()
	{
		return findChar(START_CHAR);
	}

	private Position findChar(char c)
	{
		for(int v = 0; v < mMapContent[0].length; ++v)
		{
			for(int u = 0; u < mMapContent.length; ++u)
			{
				if(mMapContent[u][v] == c)
					return new Position(u, v);
			}
		}

		// Char not found
		System.err.println("Start position of map could not be found.");
		return new Position();
	}

	@Override
	public void draw(RenderWindow target)
	{
		for(int y = 0; y < target.getRenderHeight(); ++y)
		{
			for(int x =0; x < target.getRenderWidth(); ++x)
			{
				char c = this.getChar(x + mPos.x, y + mPos.y);
				target.setChar(x, y, c);
			}
		}
	}
}
