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
//			if(primaryXmin <= secondaryXmax || primaryXmax <= secondaryXmax) {
//				secondary.setDx(-(secondary.getDx()));
//			}
//			else if (secondaryYmin <= primaryYmin || secondaryYmax >= primaryYmax) {
//				secondary.setDy(-(secondary.getDy()));
//			}
			if(primaryYmin <= secondaryYmax && secondaryYmin <= primaryYmin) {
				secondary.setDy(-(secondary.getDy()));
			}
			else if (secondaryYmin <= primaryYmax && secondaryYmax >= primaryYmax) {
				secondary.setDy(-(secondary.getDy()));
			}
			else if(primaryXmin <= secondaryXmax && secondaryXmin <= primaryXmin) {
				secondary.setDx(-(secondary.getDx()));
			}
			else if(primaryXmax <= secondaryXmax && secondaryXmin <= primaryXmax) {
				secondary.setDx(-(secondary.getDx()));
			}
			System.out.println("yo");
			return true;
		}
		
		return false;
	}

}
