package com.oosd.gamemaker.behavior;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class ManualLeft implements Movement, KeyEventDispatcher {

	Boolean isLeft = false;
	int key;
	
	public ManualLeft(int key) {
		super();
		this.key = key;
	}
	@Override
	public void move(Sprite sprite, JPanel playground) {
		int positionY = sprite.getY();
		int positionX = sprite.getX();;
		int dx = 1;
		if (isLeft && positionX > 0) {
			positionX -= dx;
		}
		sprite.update(positionX, positionY);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if(e.getKeyCode() == key) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
	            this.isLeft = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
	            this.isLeft = false;
	        } 
		}
		return false;
	}


}
