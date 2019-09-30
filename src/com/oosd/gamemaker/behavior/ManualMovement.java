package com.oosd.gamemaker.behavior;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class ManualMovement implements Movement, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3233933797707271155L;
	int dx;
	int positionX;
	int positionY;
	boolean isLeft;
	boolean isRight;

	@Override
	public void move(Sprite sprite, JPanel playground) {
        int positionY = sprite.getY();;
		int positionX = sprite.getX();;
		int maxX = playground.getWidth();
		dx = sprite.getDx();
		if (isLeft && positionX > 0) {
			positionX -= dx;
		}
		if (isRight && (positionX + (sprite.getWidth())) < maxX) {
			positionX += dx;
		}
		sprite.update(positionX, positionY);
		
}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("press");
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			this.isLeft = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			this.isRight = true;

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			this.isLeft = false;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

			this.isRight = false;

		}
		
	}
}
