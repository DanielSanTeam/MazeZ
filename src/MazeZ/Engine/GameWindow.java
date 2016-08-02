package MazeZ.Engine;

import MazeZ.Graphics.RenderWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JPanel
{
	private RenderWindow mRenderWindow;

	public GameWindow(RenderWindow rw)
	{
		super();

		// Grab RenderWindow reference
		mRenderWindow = rw;

		// Setup UI
		this.setLayout(new BorderLayout());

		final int MARGIN_LR = 14;
		final int MARGIN_TB = 16;

		JPanel displayContainer = new JPanel();
		displayContainer.setBackground(Color.BLACK);
		displayContainer.setLayout(new GridLayout(1,1));
		displayContainer.setBorder(new EmptyBorder(MARGIN_TB, MARGIN_LR, MARGIN_TB, MARGIN_LR));
		displayContainer.add(mRenderWindow.getDisplay());

		this.add(displayContainer, BorderLayout.CENTER);
	}
}
