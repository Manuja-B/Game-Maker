package com.oosd.gamemaker.behavior;

import com.oosd.gamemaker.models.Sprite;

public class BounceBack implements Reaction {

	Sprite primary;
	Sprite secondary;
	
	
	
	public BounceBack(Sprite primary, Sprite secondary) {
		super();
		this.primary = primary;
		this.secondary = secondary;
	}
	@Override
	public boolean react() {
		// TODO Auto-generated method stub
		//System.out.println("yo");
		int primaryXmin = primary.getX();
		int primaryYmin = primary.getY();
		int secondaryXmin = secondary.getX();
		int secondaryYmin = secondary.getY();
		int primaryYmax = primaryYmin + primary.getHeight();
		int primaryXmax = primaryXmin + primary.getWidth();
		int secondaryXmax = secondaryXmin + primary.getWidth();
		int secondaryYmax = secondaryYmin + primary.getHeight();
		
		if((primaryYmin - secondary.getHeight())<= secondaryYmin 
				&& secondaryYmin <= primaryYmax 
				&& secondaryXmin >= (primaryXmin - secondary.getWidth())
				&& secondaryXmin <= primaryXmax)
		{

			int secondaryXCenter = secondary.getX() + secondary.getWidth()/2;
			int secondaryYCenter = secondary.getY() + secondary.getHeight()/2;
			if(primaryYmin <= secondaryYCenter && secondaryYCenter <= primaryYmax ) {
				secondary.setDx(-secondary.getDx());
			}
			else {
				secondary.setDy(-(secondary.getDy()));
			}
			//System.out.println("yo");
			return true;
		}
		
		return false;
	}

}