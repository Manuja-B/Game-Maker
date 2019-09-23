package com.oosd.gamemaker.behavior;
import com.oosd.gamemaker.Playground;
import com.oosd.gamemaker.models.Sprite;

public class BoundaryBounce implements BoundaryBehavior{
	public void reactWithBoundary(Sprite sprite, Playground playground)
	{
		//System.out.println("Inside reactWithBoundary");
		int xMin = sprite.getX() - sprite.getWidth() / 2;
		int yMin = sprite.getY() - sprite.getWidth() / 2;
		int xMax = sprite.getX() + sprite.getWidth() / 2;
		int yMax = sprite.getY() + sprite.getWidth() / 2;

		if (xMin < 0 || xMax > playground.getWidth())
		{
			sprite.setDx(-sprite.getDx());
		}
		if (yMin < 0 || yMax > playground.getHeight()-220)
		{
			sprite.setDy(-sprite.getDy());
		}
	}
}



