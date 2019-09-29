package com.oosd.gamemaker.behavior;

import com.oosd.gamemaker.models.Sprite;

public class Explode extends Reaction {
	
	public Explode(Sprite primary, Sprite secondary, Sound sound) {
		super(primary, secondary, sound);
	}


	/**
	 * 
	 */
	private static final long serialVersionUID = -6234868905842258823L;
	
	@Override
	public boolean react() {
		if(doesReact(primary, secondary))
		{
			secondary.update(-100, -100);
			secondary.setDx(0);
			secondary.setDy(0);
			if(sound != null) {
				sound.playSound();
			}
			return true;
		}
		return false;
	}


}
