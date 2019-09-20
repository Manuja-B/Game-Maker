package com.oosd.gamemaker.commmands;

import java.util.List;

import com.oosd.gamemaker.models.Sprite;

public class UndoCommand implements Command {
private List<Sprite> sprites;
	
	public UndoCommand(List<Sprite> sprites) {
		super();
		this.sprites = sprites;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		for(Sprite sprite : sprites) {
			sprite.undo();
		}
	}

}
