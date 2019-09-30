package com.oosd.gamemaker.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Rectangle extends Sprite{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1245882985717282226L;
	int initialPositionX, initialPositionY;
	int paddleWidth, paddleHeight;
	List<Integer> historyX = new ArrayList<Integer>();
	int countX = 0, totalCount = 0;
	Boolean flag = false;
	Color color;
	private static int counter = 0;
	public Rectangle(Color color, int initialPositionX, int initialPositionY, int width, int height, int dx, int dy) {
		this.color = color;
		this.initialPositionX = initialPositionX;
		this.initialPositionY = initialPositionY;
		this.width = width;
		this.height = height;
		this.setDx(dx);
		this.setDy(dy);
		this.update(initialPositionX, initialPositionY);
		StringBuilder strName = new StringBuilder("Rectangle ");
		strName.append(++counter);
		this.name = strName.toString();
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.fillRect(locationX, locationY , width, height);
		
	}
	
}
