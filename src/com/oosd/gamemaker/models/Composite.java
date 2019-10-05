package com.oosd.gamemaker.models;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.oosd.gamemaker.behavior.AutomaticMovement;
public class Composite extends Sprite implements Serializable {
	private static final long serialVersionUID = 3034276043596940830L;
	List<Sprite> sprites;
	List<Sprite> bullets;
	public Composite() {
		 sprites = new ArrayList<Sprite>();
	}
	@Override
	public void draw(Graphics2D g2d) {
		System.out.println("Composite can't be drawn");
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
	public void shoot() {
		bullets = new ArrayList<Sprite>();
		for( Sprite sprite: sprites) {
			if(sprite.isWillShoot()) {
				Sprite bullet = new Ball(Color.BLACK,sprite.getX(),sprite.getY()-1,10,10,0,-3);
				bullet.setAutomaticMovement(new AutomaticMovement(true, true));
				bullet.play();
				getBullets().add(bullet);
			}	
		}
		sprites.addAll(getBullets());
	}

	public List<Sprite> getBullets() {
		return bullets;
	}
}
