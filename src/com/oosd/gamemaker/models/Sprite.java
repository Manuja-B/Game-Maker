package com.oosd.gamemaker.models;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.oosd.gamemaker.Playground;
import com.oosd.gamemaker.behavior.BoundaryBehavior;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.Reaction;

public abstract class Sprite {
	protected ArrayList<Movement>  movements;
	protected ArrayList<Reaction> reactions;
	private boolean isReplay = false;
	private boolean isGamePaused = false;
	private int dx = 1;
	private int dy = 1;
	protected int x,y;
	protected String name;
	protected int height, width;
	protected BoundaryBehavior boundaryBehavior;
	public abstract void update(int x, int y);
	public abstract void draw(Graphics2D g2d);
	
	
	
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
	public void setMovement(Movement movement) {
		this.movements.add(movement);
	}
	public void setReaction(Reaction reaction) {
		this.reactions.add(reaction);
	}

	public void move(Playground playground) {
		for(Movement movement : movements) {
			movement.move(this, playground);
		}
		//boundaryBehavior.reactWithBoundary(this, playground);
	}
	public void setBoundaryMovement(BoundaryBehavior boundaryBehavior) {
		this.boundaryBehavior = boundaryBehavior;
	}
	public abstract void undo();

	public abstract void replay();

	public abstract void endReplay();

	public abstract void storeHistory();
	public void pause() {
		this.isGamePaused = !isGamePaused;
	}

	
}
