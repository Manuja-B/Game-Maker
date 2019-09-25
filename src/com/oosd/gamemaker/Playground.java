package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.Reaction;
import com.oosd.gamemaker.commmands.LoadCommand;
import com.oosd.gamemaker.commmands.PauseCommand;
import com.oosd.gamemaker.commmands.ReplayCommand;
import com.oosd.gamemaker.commmands.SaveCommand;
import com.oosd.gamemaker.commmands.UndoCommand;
import com.oosd.gamemaker.layouts.ButtonContainer;
import com.oosd.gamemaker.layouts.ControllerLayout;
import com.oosd.gamemaker.layouts.FlowLayoutClass;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.Sprite;

public class Playground extends JPanel{
	
	Maker maker;
	JPanel controller;
	Image image;
	String selectedpath;
	Composite allItems = new Composite();
		
	public Playground(Maker maker)  {
		//this.setBackground(Color.WHITE);
		this.maker = maker;
		this.allItems = maker.getAllItems();
		this.setLayout(null);
			 
	}
	public void setBackgroundImage()
	{
		this.selectedpath = maker.getSelectedpath();
		
		System.out.println("B4 selectedpath: "+selectedpath+" in setBackgroundImage() of Playground");	
		if(selectedpath != null)
		{
			File sourceimage = new File(selectedpath);
			try {
				image = ImageIO.read(sourceimage);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
//	public static Graphics2D graphobj = null;
//	public void startGame() {
//		this.setLayout(null);
//	}
	public static Graphics2D graphobj = null;
	public void startGame() {
//		JPanel border  = new FlowLayoutClass();
//		//JPanel border = new BorderLayoutClass();
//		
//		
//		 border.setOpaque(false);
//		
//		border.setBounds(0,600,800,150);
//		//border.setBackground(Color.GRAY);		
//		
//		ButtonContainer buttonContainer = new ButtonContainer( allItems,(ControllerLayout) border);
//		this.add(border);
//+
//		
//		buttonContainer.addButton("Pause", new PauseCommand(allItems.getAllSprites()), (ControllerLayout)border);
//		buttonContainer.addButton("Replay", new ReplayCommand(allItems.getAllSprites()), (ControllerLayout)border);
//		buttonContainer.addButton("Undo", new UndoCommand(allItems.getAllSprites()), (ControllerLayout)border);
//		buttonContainer.addButton("Save", new SaveCommand(allItems.getAllSprites()), (ControllerLayout)border);
//		buttonContainer.addButton("Load", new LoadCommand(allItems.getAllSprites()), (ControllerLayout)border);
//		
		
		
		while(true){
			
			this.setBackgroundImage();
			this.allItems = maker.getAllItems();
			//System.out.println(allItems.getAllSprites().size());
			for(Sprite sprite: allItems.getAllSprites()) {
				
				sprite.move(this);
			}
			for(Reaction reaction: maker.getReactions()) {
				reaction.react();
			}
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

		//this.setBackgroundImage();
		graphobj = (Graphics2D) g; 
	    
	    if(image!=null)
	    {
	    	graphobj.drawImage(image,0,0,800,800,this);
	    }
		
	    for(Sprite sprite: allItems.getAllSprites()) {
	    	sprite.draw(graphobj);
	    }

	}
}
