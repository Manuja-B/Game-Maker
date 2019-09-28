package com.oosd.gamemaker.behavior;

import com.oosd.gamemaker.models.Sprite;

public class ShootBehavior implements Reaction {
	Sprite primary;
	Sprite secondary;
	Sound sound;
	
	public ShootBehavior(Sprite primary, Sprite secondary, Sound sound) {
		super();
		this.primary = primary;
		this.secondary = secondary;
		this.sound = sound;
	}
	@Override
	public boolean react() {
		// TODO Auto-generated method stub
		int primaryXmin = primary.getX();
		int primaryYmin = primary.getY();
		int secondaryXmin = secondary.getX();
		int secondaryYmin = secondary.getY();
		int primaryYmax = primaryYmin + primary.getHeight();
		int primaryXmax = primaryXmin + primary.getWidth();
		if((primaryYmin - secondary.getHeight())<= secondaryYmin 
				&& secondaryYmin <= primaryYmax 
				&& secondaryXmin >= (primaryXmin - secondary.getWidth())
				&& secondaryXmin <= primaryXmax)
		{
			secondary.update(-100,-100);
			secondary.setDx(0);
			secondary.setDy(0);
			primary.update(-100, -100);
			primary.setDx(0);
			primary.setDy(0);
			if(sound != null) {
				sound.playSound();
			}
			return true;
		}
		return false;
	}

}
