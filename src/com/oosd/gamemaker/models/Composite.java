package com.oosd.gamemaker.models;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

public class Composite extends Sprite {
	List<Sprite> sprites;
	
	public Composite() {
		 sprites = new ArrayList<Sprite>();
	}
	@Override
	public void update(int x, int y) {
		// TODO Auto-generated method stub

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

}
