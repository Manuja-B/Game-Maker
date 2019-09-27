package com.oosd.gamemaker.models;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Composite extends Sprite implements Serializable {
	List<Sprite> sprites;
	
	public Composite() {
		 sprites = new ArrayList<Sprite>();
		 
	}
	

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub

	}
	public void add(Sprite sprite) {
		sprites.add(sprite);
	}
	public void remove(Sprite sprite) {
		sprites.remove(sprite);
	}
	public List<Sprite> getAllSprites() {
		return sprites;
	}
	
	@Override
	public void pause() {
		if(!isGamePaused()) {
			super.pause();
			for (Sprite sprite: sprites) {
				sprite.pause();
			}
		}
		else {
			super.play();
			for (Sprite sprite: sprites) {
				sprite.play();
			}
		}
	}
	
	public void edit(int index, Sprite sprite) {
		sprites.set(index, sprite);
	}
	
	

}
