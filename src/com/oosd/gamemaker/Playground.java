package com.oosd.gamemaker;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


import com.oosd.gamemaker.behavior.Reaction;
import com.oosd.gamemaker.behavior.ShootBehavior;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.Sprite;
import com.sun.javafx.webkit.KeyCodeMap.Entry;

public class Playground extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2376859069846492382L;
	Maker maker;
	JPanel controller;
	Image image;
	String selectedpath;
	Composite allItems = new Composite();
	JButton startButton;
	List<Reaction> reactions; 
	JLabel levelNumberLabel;
	Sprite s;
	int objpos;
	
	public Playground(Maker maker)  {
		this.maker = maker;
		this.allItems = new Composite();
		this.reactions=new ArrayList<Reaction>();
		this.setLayout(null);
		this.setFocusable(true);
		System.out.println("I am here");
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	public void setBackgroundImage()
	{
		this.selectedpath = maker.getLevelObjects().get(maker.getCurrentLevel()).getSelectedPath();
		if(selectedpath != null)
		{
			File sourceimage = new File(selectedpath);
			try {
				image = ImageIO.read(sourceimage);
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		else {
			image = null;
		}
	}
	
	private static Graphics2D graphobj = null;
	public void startGame() {
		startButton = new JButton("Play/ Pause");
		levelNumberLabel=new JLabel(""+LevelObject.getLevel());
		startButton.addActionListener(this);
		startButton.setVisible(true);
		startButton.setBounds(200, 10, 200, 20);
		this.add(startButton);
		while(true){
			
			this.setBackgroundImage();
			this.allItems = maker.getLevelObjects().get(maker.getCurrentLevel()).getSprites();
			this.reactions = maker.getLevelObjects().get(maker.getCurrentLevel()).getReactions();
			for(Sprite sprite: allItems.getAllSprites()) {
				sprite.move(this);
			}
			for(Reaction reaction: reactions) {
				reaction.react();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e1) {
				Thread.currentThread().interrupt();
				System.out.println("Interrupted exception");
			}
			repaint();
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
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
		if(e.getSource() == startButton ) {
			allItems.pause();
		}
		else {
			System.out.println("yo");
		}
	}
	public void mouseClicked(MouseEvent e) {
		
		allItems.shoot();
		List<Sprite> bullets = maker.getLevelObjects().get(maker.getCurrentLevel()).getSprites().getBullets();
		System.out.println("List"+allItems.getAllSprites());
		for (Sprite bullet: bullets) {
			for (Sprite component: allItems.getAllSprites()) {
				if (component.isShootEffect()) {
					maker.getLevelObjects().get(maker.getCurrentLevel()).addReaction(new ShootBehavior(bullet, component, null));
				}
			}
		}
		
		
		int startX = e.getX();
		int startY = e.getY();
		
		for(int i=0; i<allItems.getAllSprites().size(); i++) {			
			if((startX >= allItems.getAllSprites().get(i).getX()-allItems.getAllSprites().get(i).getWidth())&&(startX <=allItems.getAllSprites().get(i).getX()+allItems.getAllSprites().get(i).getWidth())&&
					(startY <= allItems.getAllSprites().get(i).getY()+allItems.getAllSprites().get(i).getHeight())&&(startY >= allItems.getAllSprites().get(i).getY()-allItems.getAllSprites().get(i).getHeight()) 
					
					) {
				 
				System.out.println("BlahBlah"+allItems.getAllSprites().get(i));
				objpos=i;
				break;
	}
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
		int startX = e.getX();
		int startY = e.getY();
		for(int i=0; i<allItems.getAllSprites().size(); i++) {			
			if((startX >= allItems.getAllSprites().get(i).getX()-allItems.getAllSprites().get(i).getWidth())&&(startX <= allItems.getAllSprites().get(i).getX()+allItems.getAllSprites().get(i).getWidth())&&(startY <= allItems.getAllSprites().get(i).getY()+allItems.getAllSprites().get(i).getHeight())&&(startY >= allItems.getAllSprites().get(i).getY()-allItems.getAllSprites().get(i).getHeight())) {
		
				System.out.println(allItems.getAllSprites().get(i));
				break;
			}
		}
		((Sprite) allItems.getAllSprites().get(objpos)).setX(e.getX());
		((Sprite) allItems.getAllSprites().get(objpos)).setY(e.getY());
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}



	

}
