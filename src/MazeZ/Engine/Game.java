package MazeZ.Engine;

import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JFrame implements KeyListener
{
	private GameWindow mGameWindow;
	private RenderWindow mRenderWindow;
	private Player mPlayer;
	private Map mCurrentMap;
	private Map mCanvas;

	public Game()
	{
		// Create game window
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// Create RenderWindow
		mRenderWindow = new RenderWindow(50, 25);

		// Create Game Window
		mGameWindow = new GameWindow(mRenderWindow);
		this.add(mGameWindow);

		// Add KeyListener
		this.addKeyListener(this);
	}

	private void init()
	{
		// Update Window Title with level number
		this.setTitle(String.format("MazeZ - Level: %d", Config.getInstance().currentLevel));

		// Get Map
		mCurrentMap = Config.getInstance().getMap();

		//Setup Canvas
		mCanvas = new Map(mCurrentMap);

		// Create Player at spawn point
		mPlayer = new Player(this, mCurrentMap.getStartPosition());

		// Get Focus
		this.requestFocus();
	}

	public void run()
	{
		init();
		update();
	}

	void update()
	{
		mCanvas = new Map(mCurrentMap);

		Position lastPlayerPosition = new Position(mPlayer.getPosition());
		//Position lastMapPosition = new Position(mCanvas.getPosition());

		switch(mPlayer.movement)
		{
			case NONE:
				break;
			case UP:
			{
				mPlayer.move(new Position(0, -1));
			}break;
			case LEFT:
			{
				mPlayer.move(new Position(-1, 0));
			}break;
			case DOWN:
			{
				mPlayer.move(new Position(0, 1));
			}break;
			case RIGHT:
			{
				mPlayer.move(new Position(1, 0));
			}break;
		}

		char charAtPlayerPosition = mCurrentMap.getChar(mPlayer.getPosition().x, mPlayer.getPosition().y);
		if(charAtPlayerPosition == Config.getInstance().BLOCK_CHAR)
		{
			mPlayer.setPosition(lastPlayerPosition);
			mCanvas.setPosition(new Position(0, 0));
		}
		else if (charAtPlayerPosition == Config.getInstance().END_CHAR)
		{
			Config.getInstance().nextLevel();
			run();
			return;
		}
		mCanvas.setPosition(Position.subtract(mPlayer.getPosition(),
				new Position(mRenderWindow.getRenderWidth() / 2, mRenderWindow.getRenderHeight() / 2)));

		// Reset Player Movement
		mPlayer.movement = Player.Move.NONE;

		// Hide secret chars
		mCanvas.hideSpecialChars();

		// Draw scene
		mCanvas.setChar(mPlayer.getPosition().x, mPlayer.getPosition().y, mPlayer.getSymbol());
		draw();
	}

	private void draw()
	{
		mRenderWindow.draw(mCanvas);
		mRenderWindow.display();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();

		if(key == KeyEvent.VK_J)
		{
			mPlayer.movement = Player.Move.DOWN;
		}
		else if(key == KeyEvent.VK_K)
		{
			mPlayer.movement = Player.Move.UP;
		}
		else if(key == KeyEvent.VK_H)
		{
			mPlayer.movement = Player.Move.LEFT;
		}
		else if(key == KeyEvent.VK_L)
		{
			mPlayer.movement = Player.Move.RIGHT;
		}

		update();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{

	}
}
