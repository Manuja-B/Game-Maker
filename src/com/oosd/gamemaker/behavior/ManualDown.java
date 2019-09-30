package com.oosd.gamemaker.behavior;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class ManualDown implements Movement, KeyEventDispatcher {

	Boolean isDown = false;
	int key;
	
	public ManualDown(int key) {
		super();
		this.key = key;
	}
	@Override
	public void move(Sprite sprite, JPanel playground) {
		int positionY = sprite.getY() ;
		int endpositionY = positionY + sprite.getHeight();
		int positionX = sprite.getX();;
		int maxY = playground.getHeight()-220;
		int dy = 1;
		if (isDown && endpositionY < maxY) {
			positionY += dy;
		}
		sprite.update(positionX, positionY);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		System.out.println("Yo");
		if(e.getKeyCode() == key) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
	            this.isDown = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
	            this.isDown = false;
	        } 
		}
		return false;
	}

}
