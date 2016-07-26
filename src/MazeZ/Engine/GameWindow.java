package MazeZ.Engine;

import MazeZ.Graphics.RenderWindow;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by lukit on 7/25/2016.
 */
public class GameWindow extends JPanel
{
	private final Dimension mControlPanelSize = new Dimension(600, 200);
	private JPanel mControlSection;

	private RenderWindow mRenderWindow;

	Controls controls;

	public GameWindow(RenderWindow rw)
	{
		super();

		// Grab RenderWindow reference
		mRenderWindow = rw;

		// Create Controls
		controls = new Controls();

		// Setup UI
		this.setLayout(new BorderLayout());

		mControlSection = new JPanel();
		mControlSection.setPreferredSize(mControlPanelSize);
		this.add(mControlSection, BorderLayout.SOUTH);

		final int MARGIN_LR = 14;
		final int MARGIN_TB = 16;

		JPanel displayContainer = new JPanel();
		displayContainer.setLayout(new GridLayout(1,1));
		displayContainer.setBorder(new EmptyBorder(MARGIN_TB, MARGIN_LR, MARGIN_TB, MARGIN_LR));
		displayContainer.add(mRenderWindow.getDisplay());

		this.add(displayContainer, BorderLayout.CENTER);

		mControlSection.add(controls);
	}

	class Controls extends JPanel
	{
		private JButton mUp, mDown, mLeft, mRight;

		public void attach(Player player)
		{
			mUp.addActionListener(player.UP);
			mLeft.addActionListener(player.LEFT);
			mRight.addActionListener(player.RIGHT);
			mDown.addActionListener(player.DOWN);
		}

		public Controls()
		{
			this.setLayout(new GridLayout(3,3));

			mUp = new JButton("/\\");
			mLeft = new JButton(("<"));
			mRight = new JButton((">"));
			mDown = new JButton("\\/");

			this.add(new JLabel());
			this.add(mUp);
			this.add(new JLabel());

			this.add(mLeft);
			this.add(new JLabel());
			this.add(mRight);

			this.add(new JLabel());
			this.add(mDown);
			this.add(new JLabel());
		}
	}
}
