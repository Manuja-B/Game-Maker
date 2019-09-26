package com.oosd.gamemaker.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;

import com.oosd.gamemaker.Playground;
import com.oosd.gamemaker.behavior.BoundaryBehavior;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.Reaction;

public abstract class Sprite implements Serializable{
	protected ArrayList<Movement>  manualMovements = new ArrayList<Movement>();
	protected ArrayList<Reaction> reactions;
	private Movement automaticMovement;
	private boolean isGamePaused = true;
	private int dx = 1;
	private int dy = 1;
	protected int x,y;
	protected String name;
	protected int height, width;
	protected BoundaryBehavior boundaryBehavior;
	private boolean firstUpdate = true;
	//public abstract void update(int x, int y);
	public abstract void draw(Graphics2D g2d);
	
	public void update(int x, int y ) {
		System.out.println(x+","+y);
		if(!isGamePaused() || firstUpdate) {
			this.x = x;
			this.y = y;
		}	
		if(firstUpdate) {
			firstUpdate = false;
		}
	}
	public String getName() {
		return name;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getDx() {
		// TODO Auto-generated method stub
		return dx;
	}
	public int getDy() {
		// TODO Auto-generated method stub
		return dy;
	}
	public void setDx(int dx) {
		this.dx = dx;
	}
	
	public void setDy(int dy) {
		this.dy = dy;
	}
	public void setManualMovement(Movement movement) {
		this.manualMovements.add(movement);
	}
	
	public void setReaction(Reaction reaction) {
		this.reactions.add(reaction);
	}

	public void move(Playground playground) {
		for(Movement movement : getManualMovements()) {
			movement.move(this, playground);
		}
		if(boundaryBehavior != null) {
			boundaryBehavior.reactWithBoundary(this, playground);
		}
		if(automaticMovement != null) {
			automaticMovement.move(this, playground);
		}
		
	}
	public void setBoundaryMovement(BoundaryBehavior boundaryBehavior) {
		this.boundaryBehavior = boundaryBehavior;
	}
	public ArrayList<Movement> getManualMovements() {
		return manualMovements;
	}
	public Movement getAutomaticMovement() {
		return automaticMovement;
	}
	public void setAutomaticMovement(Movement automaticMovement) {
		this.automaticMovement = automaticMovement;
	}
	
	public void pause() {
		this.isGamePaused = true;
	}
	public void play(){
		this.isGamePaused = false;
	}
	public boolean isGamePaused() {
		return isGamePaused;
	}
	
}
