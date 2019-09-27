package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.Reaction;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.Sprite;

public class Playground extends JPanel implements ActionListener{
	
	Maker maker;
	JPanel controller;
	Image image;
	String selectedpath;
	Composite allItems = new Composite();
	JButton startButton;
	ArrayList<Reaction> reactions; 
	//String level="1";
	JLabel levelNumberLabel;
	
	public Playground(Maker maker)  {
		//this.setBackground(Color.WHITE);
		this.maker = maker;
		this.allItems = new Composite();//maker.getLevelObjects().get(maker.getCurrentLevel()).getSprites();
		this.reactions=new ArrayList<Reaction>();//maker.getLevelObjects().get(maker.getCurrentLevel()).getReactions();
		this.setLayout(null);
			 
	}
	public void setBackgroundImage()
	{
		this.selectedpath = maker.getLevelObjects().get(maker.getCurrentLevel()).getSelectedPath();
		//System.out.println(selectedpath);
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
		else {
			image = null;
		}
	}
	
	public static Graphics2D graphobj = null;
	public void startGame() {
		startButton = new JButton("Play/ Pause");
		levelNumberLabel=new JLabel(""+LevelObject.level);
		startButton.addActionListener(this);
		startButton.setVisible(true);
		startButton.setBounds(200, 10, 200, 20);
		this.add(startButton);
		while(true){
			
			this.setBackgroundImage();
			this.allItems = maker.getLevelObjects().get(maker.getCurrentLevel()).getSprites();
			for(Sprite sprite: allItems.getAllSprites()) {
				
				sprite.move(this);
			}
			for(Reaction reaction: reactions) {
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
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == startButton ) {
			allItems.pause();
		}
	}
}
