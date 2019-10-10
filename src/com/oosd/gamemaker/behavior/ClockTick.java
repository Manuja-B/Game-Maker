package com.oosd.gamemaker.behavior;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.DigitalClock;
import com.oosd.gamemaker.models.Sprite;

public class ClockTick implements Movement {
	
	private static final long serialVersionUID = 8622346125852620161L;
	private double milliSeconds;
	private int seconds;
	private int minutes;
	
	@Override
	public void move(Sprite sprite, JPanel playground) {
		milliSeconds += 0.01;
		seconds = ((DigitalClock) sprite).getCurrSeconds();
		minutes = ((DigitalClock) sprite).getCurrMinutes();
		if (milliSeconds >= 1) {
			seconds++;
			milliSeconds = 0;
		}
		if (seconds == 60) {
			minutes++;
			seconds = 0;
		}
		((DigitalClock) sprite).update(minutes, seconds);
		
	}

	@Override
	public void setUniDirectionMovementX(boolean uniDirectionX) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setUniDirectionMovementY(boolean uniDirectionY) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isUniDirectionMovementX() {
		return false;
	}

	@Override
	public boolean isUniDirectionMovementY() {
		return false;
	}
	
	

}
