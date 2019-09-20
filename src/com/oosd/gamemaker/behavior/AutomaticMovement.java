package com.oosd.gamemaker.behavior;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class AutomaticMovement implements Movement {

	@Override
	public void move(Sprite sprite, JPanel playground) {
		// TODO Auto-generated method stub
		int xMin = sprite.getX() - sprite.getWidth()/2;
        int yMin = sprite.getY() - sprite.getHeight()/2;
        int xMax = sprite.getX() + sprite.getWidth()/2;
        int yMax = sprite.getY() + sprite.getHeight()/2;;
       //\ System.out.println(playground.getWidth());
        if (xMin < 0 || xMax > playground.getWidth()) {
            sprite.setDx(-sprite.getDx());
        }
        if (yMin < 0 || yMax > playground.getHeight()) {
        	sprite.setDy(-sprite.getDy());
        }
        int positionX = sprite.getX() + sprite.getDx();
        int positionY = sprite.getY()+ sprite.getDy();
        sprite.update(positionX, positionY);
	}
	
}
