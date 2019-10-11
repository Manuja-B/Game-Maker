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
			primary.setStatus("Dead");
			secondary.setStatus("Dead");
			if(sound != null) {
				sound.playSound();
			}
			return true;
		}
		return false;
	}
}
