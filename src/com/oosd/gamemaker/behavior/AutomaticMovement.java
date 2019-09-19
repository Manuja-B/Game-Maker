package com.oosd.gamemaker.behavior;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class AutomaticMovement implements Movement {

	@Override
	public void move(Sprite sprite, JPanel playground) {
		// TODO Auto-generated method stub
		
        int positionX = sprite.getX() + sprite.getDx();
        int positionY = sprite.getY()+ sprite.getDy();
        sprite.update(positionX, positionY);
	}

}
