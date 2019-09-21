package com.oosd.gamemaker.behavior;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JPanel;
import com.oosd.gamemaker.models.Sprite;

public class ManualUp implements Movement, KeyEventDispatcher {

	
	Boolean isUp = false;
	int key;
	
	public ManualUp(int key) {
		super();
		this.key = key;
	}
	@Override
	public void move(Sprite sprite, JPanel playground) {
		// TODO Auto-generated method stub
		int positionY = sprite.getY();
		int positionX = sprite.getX();;
		int maxX = playground.getHeight();
		int dy = sprite.getDy();
		if (isUp && positionY > 0) {
			positionY -= dy;
		}
		sprite.update(positionX, positionY);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		if(e.getKeyCode() == key) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
	            System.out.println("press");
	            this.isUp = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
	            System.out.println("release");
	            this.isUp = false;
	        } 
		}
		return false;
	}

}
