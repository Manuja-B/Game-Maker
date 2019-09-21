package com.oosd.gamemaker.behavior;
//import com.oosd.gamemaker.Maker;
import com.oosd.gamemaker.Playground;
import com.oosd.gamemaker.models.Sprite;

public class BoundaryRotate implements BoundaryBehavior{
	
	@Override
	public void reactWithBoundary(Sprite sprite, Playground playground) {
		// TODO Auto-generated method stub
		//System.out.println("Inside Boundary Behavior");
		
		int xMin = sprite.getX() - sprite.getWidth() / 2;
		int yMin = sprite.getY() - sprite.getHeight() / 2;
		int xMax = sprite.getX() + sprite.getWidth() / 2;
		int yMax = sprite.getY() + sprite.getHeight() / 2;
		//System.out.println(sprite.getDy()+" "+"Get Y location");
		if ( xMax > playground.getWidth())
		{
			sprite.update(sprite.getWidth(),sprite.getY());
			//sprite.setX(0);
			//sprite.setY(sprite.getY());
			//sprite.setDx(-sprite.getDx());
		}
		if(xMin<0)
			sprite.update(playground.getWidth(),sprite.getY());
			//sprite.setX(playground.getWidth());
			//sprite.setY(sprite.getY());
			//sprite.setDx(-sprite.getDx());
		if (yMin < 0 )
		{
			sprite.update(sprite.getX(),playground.getHeight());
			//sprite.setX(sprite.getX());
			//sprite.setY(playground.getHeight());
			//sprite.setDy(-sprite.getDy());
		}
		if(yMax>playground.getHeight())
			sprite.update(sprite.getX(),sprite.getHeight());
			//sprite.setX(sprite.getX());
			//sprite.setY(0);
			//sprite.setDy(-sprite.getDy());
	}

}
