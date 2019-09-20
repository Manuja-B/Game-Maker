package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.Sprite;

public class Playground extends JPanel{
	private int playgroundHeight;
	private int playgroundWidth;
	Maker maker;
	Composite allItems = new Composite();
	public Playground(Maker maker) {
		this.setBackground(Color.WHITE);
		this.maker = maker;
		this.allItems = maker.getAllItems();
	}
	public static Graphics2D graphobj = null;
	public void startGame() {
		while(true){
			this.allItems = maker.getAllItems();
			for(Sprite sprite: allItems.getAllSprites()) {
				sprite.move(this);
			}
			//System.out.println(this.allItems.getAllSprites().size());
			//System.out.println("while");
			try {
				
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			repaint();
			
		}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    graphobj = (Graphics2D) g;
	    
		//((Sprite)allItems.get(0)).draw(graphobj);
	    for(Sprite sprite: allItems.getAllSprites()) {
	    	sprite.draw(graphobj);
	    }
	    //System.out.println(allItems);

	}
//	public int getPlaygroundHeight() {
//		return playgroundHeight;
//	}
//	public int getPlaygroundWidth() {
//		return playgroundWidth;
//	}
	
}
