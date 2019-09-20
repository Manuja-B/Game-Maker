package com.oosd.gamemaker.commmands;

import java.util.List;

import com.oosd.gamemaker.models.Sprite;

public class SaveCommand implements Command {
	private List<Sprite> sprites;
	public SaveCommand(List<Sprite> sprites) {
		super();
		this.sprites = sprites;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub

	}

}
