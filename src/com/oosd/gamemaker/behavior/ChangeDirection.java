package com.oosd.gamemaker.behavior;

import com.oosd.gamemaker.models.Sprite;

public class ChangeDirection extends Reaction {
	
	private static final long serialVersionUID = 1L;

	public ChangeDirection(Sprite primary, Sprite secondary, Sound sound) {
		super(primary, secondary, sound);
	}

	@Override
	public boolean react() {
		if(doesReact(primary, secondary))
		{
			Movement movement = primary.getAutomaticMovement();
			if(movement.isUniDirectionMovementX() && !movement.isUniDirectionMovementY()) {
				movement.setUniDirectionMovementX(false);
				movement.setUniDirectionMovementY(true);
				primary.setDy(-primary.getDy());
			}else if(!movement.isUniDirectionMovementX() && movement.isUniDirectionMovementY()) {
				movement.setUniDirectionMovementX(true);
				movement.setUniDirectionMovementY(false);
				primary.setDx(-primary.getDx());
			}
			primary.setX(primary.getX() - (3* primary.getDx()));
			primary.setY(primary.getY() - (3* primary.getDy()));
			
			primary.setAutomaticMovement(movement);
			return true;
		}
		
		return false;
	}

}
