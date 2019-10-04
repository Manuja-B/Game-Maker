package com.oosd.gamemaker.behavior;

import com.oosd.gamemaker.models.Sprite;

public class ClickExplode implements MouseClickBehaviour {
	
	private Sprite sprite;
	
	public ClickExplode(Sprite sprite) {
		this.sprite = sprite;
		
	}
	
	@Override
	public void respondToClick() {
		sprite.setLocationX(-100);
		sprite.setLocationY(-100);
	}

}
