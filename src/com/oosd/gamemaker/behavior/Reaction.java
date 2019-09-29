package com.oosd.gamemaker.behavior;

import java.io.Serializable;

import com.oosd.gamemaker.models.Sprite;

public abstract class Reaction implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2757834906244628652L;
	Sprite primary;
	Sprite secondary;
	Sound sound;
	
	public Reaction(Sprite primary, Sprite secondary, Sound sound) {
		super();
		this.primary = primary;
		this.secondary = secondary;
		this.sound = sound;
	}
	public abstract boolean react();
	public boolean doesReact(Sprite primary, Sprite secondary) {
		int primaryXmin = primary.getX();
		int primaryYmin = primary.getY();
		int secondaryXmin = secondary.getX();
		int secondaryYmin = secondary.getY();
		int primaryYmax = primaryYmin + primary.getHeight();
		int primaryXmax = primaryXmin + primary.getWidth();
		
		return ((primaryYmin - secondary.getHeight())<= secondaryYmin 
				&& secondaryYmin <= primaryYmax 
				&& secondaryXmin >= (primaryXmin - secondary.getWidth())
				&& secondaryXmin <= primaryXmax);
	}
}
