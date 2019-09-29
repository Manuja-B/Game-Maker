package com.oosd.gamemaker.behavior;

import com.oosd.gamemaker.models.Sprite;

public class ShootBehavior extends Reaction {
	public ShootBehavior(Sprite primary, Sprite secondary, Sound sound) {
		super(primary, secondary, sound);
		
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -1317140047103260576L;
	
	
	@Override
	public boolean react() {
		if(doesReact(primary, secondary))
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
