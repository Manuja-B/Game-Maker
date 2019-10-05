package com.oosd.gamemaker.behavior;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Sprite;

public class UniDirectionMovement implements Movement {

	private boolean uniDirectionMovementX;
	private boolean uniDirectionMovementY;
	
	public UniDirectionMovement(boolean uniDirectionMovementX, boolean uniDirectionMovementY) {
		this.uniDirectionMovementX = uniDirectionMovementX;
		this.uniDirectionMovementY = uniDirectionMovementY;
	}
	
	public boolean isUniDirectionMovementX() {
		return uniDirectionMovementX;
	}

	public void setUniDirectionMovementX(boolean uniDirectionMovementX) {
		this.uniDirectionMovementX = uniDirectionMovementX;
	}

	public boolean isUniDirectionMovementY() {
		return uniDirectionMovementY;
	}

	public void setUniDirectionMovementY(boolean uniDirectionMovementY) {
		this.uniDirectionMovementY = uniDirectionMovementY;
	}

	@Override
	public void move(Sprite sprite, JPanel playground) {
		int positionX = sprite.getX();
		int positionY = sprite.getY();
		if(uniDirectionMovementX && !uniDirectionMovementY)
		{
			positionX = sprite.getX() + sprite.getDx();
		}
		else if(uniDirectionMovementY && !uniDirectionMovementX)
		{
			positionY = sprite.getY()+ sprite.getDy();
		}
       
		sprite.update(positionX, positionY);
	}

}
