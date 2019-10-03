package com.oosd.gamemaker.behavior;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class AutomaticMovement implements Movement {

	private static final long serialVersionUID = 5512078739763787804L;
	
	@Override
	public void move(Sprite sprite, JPanel playground) {
        int positionX = sprite.getX() + sprite.getDx();
        int positionY = sprite.getY()+ sprite.getDy();
        sprite.update(positionX, positionY);
	}

}
