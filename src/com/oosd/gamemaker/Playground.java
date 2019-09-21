package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.Sprite;

public class Playground extends JPanel {
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
			try {
				
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			repaint();
			
		}
	}
	
	public void addManualMovement() {
		for(Sprite sprite: allItems.getAllSprites()) {
			ArrayList<Movement> spriteManual = sprite.getManualMovements();	
			for(Movement manual : spriteManual) {
				System.out.println("playground"+manual);
			}
		}	
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
	    graphobj = (Graphics2D) g;
	    for(Sprite sprite: allItems.getAllSprites()) {
	    	sprite.draw(graphobj);
	    }

	}
}
