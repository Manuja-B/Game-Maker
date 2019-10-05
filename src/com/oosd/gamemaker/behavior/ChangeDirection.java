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
			}else if(!movement.isUniDirectionMovementX() && movement.isUniDirectionMovementY()) {
				movement.setUniDirectionMovementX(true);
				movement.setUniDirectionMovementY(false);
			}
			primary.setX(primary.getX() - (2* primary.getDx()));
			primary.setY(primary.getY() - (2* primary.getDy()));
			
			primary.setAutomaticMovement(movement);
			return true;
		}
		
		return false;
	}

}
