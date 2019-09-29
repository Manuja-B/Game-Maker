package com.oosd.gamemaker.models;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.oosd.gamemaker.behavior.Movement;


public class DigitalClock extends Sprite{
	
	private double milliSeconds;
	private int positionX;
	private int positionY;
	private static int counter = 0;
	int currMinutes, currSeconds;
	
	public DigitalClock(int positionX, int positionY)
	{
		this.positionX = positionX;
		this.positionY = positionY; 
		this.update(0,0); // initializing minutes and seconds
		StringBuilder strName = new StringBuilder("Clock ");
		strName.append(++counter);
		this.name = strName.toString();
	}
	
	
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.setColor(Color.BLACK);
		Font f = new Font("Dialog", Font.PLAIN, 30);
		g2d.setFont(f);
		g2d.drawString(locationX + ":" + locationY, positionX, positionY);
		
	}
	
	public int getCurrMinutes() {
		// TODO Auto-generated method stub
		return locationX;
	}

	public void setCurrMinutes(int currMinutes) {
		// TODO Auto-generated method stub
		this.currMinutes = currMinutes;
	}

	public int getCurrSeconds() {
		// TODO Auto-generated method stub
		return locationY;
	}

	public void setCurrSeconds(int currSeconds) {
		// TODO Auto-generated method stub
		this.currSeconds = currSeconds;
	}


}
