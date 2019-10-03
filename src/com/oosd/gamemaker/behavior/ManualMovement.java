package com.oosd.gamemaker.behavior;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class ManualMovement implements Movement, KeyEventDispatcher {

	private static final long serialVersionUID = 8062557088943136222L;
	
	private Boolean isLeft = false;
	private Boolean isRight = false;
	private Boolean isDown = false;
	private Boolean isUp = false;
	
	private Boolean isLeftCode = false;
	private Boolean isRightCode = false;
	private Boolean isDownCode = false;
	private Boolean isUpCode = false;

	int key;
	
	public ManualMovement(int key, int directionCode) {
		super();
		this.key = key;
		switch(directionCode)
		{
			case(0):
				this.isUpCode = true;
				break;
			case(1):
				this.isDownCode = true;
				break;
			case(2):
				this.isLeftCode = true;
				break;
			case(3):
				this.isRightCode = true;
				break;
			default:
				System.out.println("No code is set");
		}
	}
	
	@Override
	public void move(Sprite sprite, JPanel playground) {
		int positionY = sprite.getY();
		int positionX = sprite.getX();
		
		int maxRight = playground.getWidth();
		int endpositionX = positionX + sprite.getWidth();
		
		int endpositionY = positionY + sprite.getHeight();
		
		int maxY = playground.getHeight()-220;
		
		int dx = 1;
		int dy = 1;
		
		
		if (isLeft && positionX > 0) {
			positionX -= dx;
		}
		else if (isRight && endpositionX < maxRight) {
			positionX += dx;
		} 
		else if (isDown && endpositionY < maxY) {
			positionY += dy;
		}
		else if(isUp && positionY > 0) {
			positionY -= dy;
		}
		
		sprite.update(positionX, positionY);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if(e.getKeyCode() == key) {
			if (e.getID() == KeyEvent.KEY_PRESSED && isLeftCode) {
	            this.isLeft = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED && isLeftCode) {
	            this.isLeft = false;
	        } else if (e.getID() == KeyEvent.KEY_PRESSED && isRightCode) {
	            this.isRight = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED && isRightCode) {
	            this.isRight = false;
	        } else if (e.getID() == KeyEvent.KEY_PRESSED && isDownCode) {
	            this.isDown = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED && isDownCode) {
	            this.isDown = false;
	        }
			else if (e.getID() == KeyEvent.KEY_PRESSED && isUpCode) {
	            this.isUp = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED && isUpCode) {
	            this.isUp = false;
	        }
		}
		return false;
	}


}