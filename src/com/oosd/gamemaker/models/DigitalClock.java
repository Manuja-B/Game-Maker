package com.oosd.gamemaker.models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.oosd.gamemaker.behavior.Movement;


public class DigitalClock extends Sprite{
	
	private double milliSeconds;
//	private int seconds;
//	private int minutes;
	private int positionX;
	private int positionY;
	int currMinutes, currSeconds;
	
	public DigitalClock(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY; 
		this.update(0,0); // initializing minutes and seconds
		this.movements = new ArrayList<Movement>();
	}
	
		@Override
	public void update(int x, int y) {
		// TODO Auto-generated method stub
		this.x = x;
		this.y = y;	
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.PINK);
		Font f = new Font("Dialog", Font.PLAIN, 30);
		g2d.setFont(f);
		g2d.drawString(x + ":" + y, positionX, positionY);
		
	}
	
	public int getCurrMinutes() {
		// TODO Auto-generated method stub
		return x;
	}

	public void setCurrMinutes(int currMinutes) {
		// TODO Auto-generated method stub
		this.currMinutes = currMinutes;
	}

	public int getCurrSeconds() {
		// TODO Auto-generated method stub
		return y;
	}

	public void setCurrSeconds(int currSeconds) {
		// TODO Auto-generated method stub
		this.currSeconds = currSeconds;
	}

//	public void position(int minutes2, int seconds2) {
//		// TODO Auto-generated method stub
//		setCurrSeconds(seconds);
//		setCurrMinutes(minutes);
//	}


}
