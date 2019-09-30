package com.oosd.gamemaker.behavior;
//import com.oosd.gamemaker.Maker;
import com.oosd.gamemaker.Playground;
import com.oosd.gamemaker.models.Sprite;

public class BoundaryRotate implements BoundaryBehavior{
	
	@Override
	public void reactWithBoundary(Sprite sprite, Playground playground) {
		// TODO Auto-generated method stub
		int xMin = sprite.getX() ;
		int yMin = sprite.getY() ;
		int xMax = sprite.getX() + sprite.getWidth() ;
		int yMax = sprite.getY() + sprite.getHeight();
		if ( xMin > playground.getWidth())
		{
			sprite.update(1,sprite.getY());
		}
		if(xMin<0)
			sprite.update(playground.getWidth(),sprite.getY());
		if (yMin < 0 )
		{
			sprite.update(sprite.getX(),playground.getHeight());
		}
		if(yMax>playground.getHeight())
			sprite.update(sprite.getX(),sprite.getHeight());
		System.out.println(sprite.getHeight());
		System.out.println(sprite.getWidth());
	}

}
