package com.oosd.gamemaker.models;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.oosd.gamemaker.behavior.BoundaryBehavior;
import com.oosd.gamemaker.behavior.Movement;

public class Ball extends Sprite {
	//private int x,y;
	private Color color;
	private int countPosX = 0;
	private int countPosY = 0;
	private int lastDx;
	private int lastDy;
	private int totalCount = 0;
	private int initialPositionX;
	private int initialPositionY;
	public static int counter = 0;
	
	
	public Ball(Color color, int initialPositionX, int initialPositionY, int ballWidth, int ballHeight,int dx, int dy) {
		this.color = color;
		this.initialPositionX = initialPositionX;
		this.initialPositionY = initialPositionY;
		this.update(initialPositionX, initialPositionY);
		this.height = ballHeight;
		this.width = ballWidth;
		this.countPosX = 0;
		this.countPosY = 0;
		this.totalCount = 0;
		this.setDx(dx);
		this.setDy(dy);
		this.manualMovements = new ArrayList<Movement>();
		//counter++;
//		this.name = StringBuilder("Ball",+counter);
		StringBuilder strName = new StringBuilder("Ball ");
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
		g2d.fillOval(x, y, height, width);
		
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
