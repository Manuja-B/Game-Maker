package com.oosd.gamemaker.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import com.oosd.gamemaker.behavior.Movement;

public class Rectangle extends Sprite{
	int initialPositionX, initialPositionY;
	int paddleWidth, paddleHeight;
	List<Integer> historyX = new ArrayList<Integer>();
	int countX = 0, totalCount = 0;
	Boolean flag = false;
	Color color;
	public static int counter = 0;
	
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
	public void update(int x, int y) {
		this.x = x;
		this.y = y;
		
	}
	@Override
	public void draw(Graphics2D g2d) {
		g2d.setColor(this.color);
		g2d.fillRect(x, y , width, height);
		
	}
	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void replay() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void endReplay() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void storeHistory() {
		// TODO Auto-generated method stub
		
	}
}
