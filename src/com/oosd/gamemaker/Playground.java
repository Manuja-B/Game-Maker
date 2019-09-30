package com.oosd.gamemaker;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.oosd.gamemaker.behavior.Reaction;
import com.oosd.gamemaker.behavior.ShootBehavior;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.Sprite;

public class Playground extends JPanel implements ActionListener, MouseListener{
	
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
	
	public Playground(Maker maker)  {
		this.maker = maker;
		this.allItems = new Composite();
		this.reactions=new ArrayList<Reaction>();
		this.setLayout(null);
		this.addMouseListener(this);
			 
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
	
	public static Graphics2D graphobj = null;
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
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("mouse");
		allItems.shoot();
		List<Sprite> bullets = maker.getLevelObjects().get(maker.getCurrentLevel()).getSprites().getBullets();
		for (Sprite bullet: bullets) {
			for (Sprite component: allItems.getAllSprites()) {
				if (component.isShootEffect()) {
					maker.getLevelObjects().get(maker.getCurrentLevel()).addReaction(new ShootBehavior(bullet, component, null));
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// Do nothing
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// Do nothing
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// Do nothing
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// Do nothing
		
	}
}
