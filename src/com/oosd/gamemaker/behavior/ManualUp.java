package com.oosd.gamemaker.behavior;

import java.awt.KeyEventDispatcher;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import com.oosd.gamemaker.models.Sprite;

public class ManualUp implements Movement, KeyEventDispatcher {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5768191188452110965L;
	Boolean isUp = false;
	int key;
	
	public ManualUp(int key) {
		super();
		this.key = key;
	}
	@Override
	public void move(Sprite sprite, JPanel playground) {
		int positionY = sprite.getY();
		int positionX = sprite.getX();;
		int dy = 1;
		if (isUp && positionY > 0) {
			positionY -= dy;
		}
		sprite.update(positionX, positionY);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent e) {
		if(e.getKeyCode() == key) {
			if (e.getID() == KeyEvent.KEY_PRESSED) {
	            this.isUp = true;
	        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
	            this.isUp = false;
	        } 
		}
		return false;
	}

}
