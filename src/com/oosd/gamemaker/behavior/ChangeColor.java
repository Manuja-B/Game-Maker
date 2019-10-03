package com.oosd.gamemaker.behavior;

import java.awt.Color;
import java.awt.event.MouseEvent;

import com.oosd.gamemaker.models.Sprite;

public class ChangeColor implements MouseClickBehaviour {
	
	private Sprite sprite;
	private Color color;
	private boolean isClicked;
	
	public ChangeColor(Sprite sprite, Color color) {
		this.sprite = sprite;
		this.color = color;
		isClicked = false;
	}
	
	@Override
	public void respondToClick() {
		// TODO Auto-generated method stub
		if(isClicked) {
			sprite.setColor(this.color);
		}else {
			sprite.setColor(Color.ORANGE);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
		isClicked = true;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		isClicked = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
