package com.oosd.gamemaker.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import com.oosd.gamemaker.behavior.Movement;

public class Ball extends Sprite {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1484789349833161766L;
	private Color color;
	private static int counter = 0;
	
	
	public Ball(Color color, int initialPositionX, int initialPositionY, int ballWidth, int ballHeight,int dx, int dy) {
		this.color = color;
		this.update(initialPositionX, initialPositionY);
		this.height = ballHeight;
		this.width = ballWidth;
		this.setDx(dx);
		this.setDy(dy);
		this.manualMovements = new ArrayList<Movement>();
		StringBuilder strName = new StringBuilder("Ball ");
		strName.append(++counter);
		this.name = strName.toString();
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.fillOval(locationX, locationY, height, width);
		
	}
}
