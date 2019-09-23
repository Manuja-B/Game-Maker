package com.oosd.gamemaker.behavior;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class ManualRight implements Movement, KeyEventDispatcher {

	Boolean isRight = false;
	int key;
	
	public ManualRight(int key) {
		super();
		this.key = key;
	}
	@Override
	public void move(Sprite sprite, JPanel playground) {
		int positionY = sprite.getY();
		int positionX = sprite.getX();
		int maxRight = playground.getWidth();
		int endposition = positionX + sprite.getWidth();
		int dx = 1;
		if (isRight && endposition < maxRight) {
			positionX += dx;
		}
		sprite.update(positionX, positionY);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if(e.getKeyCode() == key) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
	            this.isRight = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
	            this.isRight = false;
	        } 
		}
		return false;
	}

}
