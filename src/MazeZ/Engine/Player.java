package MazeZ.Engine;

import MazeZ.Graphics.Position;
import MazeZ.Graphics.RenderWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by lukit on 7/25/2016.
 */
public class Player extends Entity
{
	private Collection<Item> mItems;

	private Game mGame;

	final ActionListener UP;
	final ActionListener DOWN;
	final ActionListener LEFT;
	final ActionListener RIGHT;

	@Override
	public void draw(RenderWindow target)
	{
		target.setChar(mPos.x, mPos.y, mSymbol);
	}

	enum Move {NONE, UP, DOWN, LEFT, RIGHT};
	Move movement;

	public Player(Game game, Position pos)
	{
		super('$', 15, pos);
		mItems = new ArrayList<>();
		mGame = game;
		movement = Move.NONE;

		UP = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.UP;
				mGame.update();
			}
		};

		DOWN = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.DOWN;
				mGame.update();
			}
		};

		LEFT = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.LEFT;
				mGame.update();
			}
		};

		RIGHT = new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent actionEvent)
			{
				movement = Move.RIGHT;
				mGame.update();
			}
		};
	}

	public void useItem(int itemID)
	{
		for(Item i : mItems)
		{
			if(i.getId() == itemID)
			{
				i.use(this);
				break;
			}
		}
	}
}
