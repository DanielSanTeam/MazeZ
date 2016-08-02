package MazeZ.Graphics;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RenderWindow
{
	private char mRenderSpace[][];
	private final int mWidth;
	private final int mHeight;
	private final JTextArea mDisplay;
	private final Font mFont = new Font("Courier New", Font.PLAIN, 18);

	public RenderWindow(int width, int height)
	{
		mDisplay = new JTextArea();
		mDisplay.setFocusable(false);
		mWidth = width;
		mHeight = height;

		mRenderSpace = new char[mWidth][mHeight];

		for(int v = 0; v < mHeight; ++v)
		{
			for(int u = 0; u < mWidth; ++u)
			{
				mRenderSpace[u][v] = ' ';
			}
		}

		final int DISPLAY_PADDING = 8;

		mDisplay.setBackground(Color.BLACK);
		mDisplay.setForeground(Color.GREEN);
		mDisplay.setBorder(new EmptyBorder(DISPLAY_PADDING,
				DISPLAY_PADDING,
				DISPLAY_PADDING,
				DISPLAY_PADDING));
		mDisplay.setEditable(false);
		mDisplay.setFont(mFont);
	}

	public int getRenderWidth()
	{
		return mWidth;
	}

	public int getRenderHeight()
	{
		return mHeight;
	}

	public char getChar(int x, int y)
	{
		try
		{
			return mRenderSpace[x][y];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			return '?';
		}
	}

	public void setChar(int x, int y, char c)
	{
		if(x < mWidth && y < mHeight)
		{
			mRenderSpace[x][y] = c;
		}
		else
		{
			System.err.println("Error! Trying to draw to invalid position on RenderWindow!");
		}
	}

	public void draw(Drawable drawItem)
	{
		drawItem.draw(this);
	}

	public void display()
	{
		mDisplay.setText(null);
		for(int v = 0; v < mHeight; ++v)
		{
			for(int u = 0; u < mWidth; ++u)
			{
				char c = this.getChar(u, v);
				mDisplay.append(Character.toString(c));
			}
			mDisplay.append("\n");
		}
	}

	public JComponent getDisplay()
	{
		return mDisplay;
	}
}
