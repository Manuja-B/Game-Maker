package com.oosd.gamemaker.behavior;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.DigitalClock;
import com.oosd.gamemaker.models.Sprite;

public class ClockTick implements Movement {
	
	private double milliSeconds;
	private int seconds;
	private int minutes;
	@Override
	public void move(Sprite sprite, JPanel playground) {
		// TODO Auto-generated method stub
		
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
	
	

}
