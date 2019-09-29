package com.oosd.gamemaker.models;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture extends Sprite{
	private String currentPath=System.getProperty("user.dir");
	private Image image ;
	//private File f=new File(currentPath+"/doggy.jpeg");
	private File f=new File("//home//bivas//Pictures//football.jepg");
	private static int counter = 0;
	public Picture( int initialPositionX, int initialPositionY, int imageHeight, int imageWidth,int dx, int dy)
	{	
		this.height = imageHeight;
		this.width = imageWidth;
		this.update(initialPositionX, initialPositionY);
		this.setDx(dx);
		this.setDy(dy);
		//image = Toolkit.getDefaultToolkit().getImage(currentPath+"/doggy.jpeg");
		try {
			image=ImageIO.read(f);
			
		} catch (IOException e) {
			System.out.println("Cannot find image");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.height = imageHeight;
		this.width = imageWidth;
		this.setDx(dx);
		this.setDy(dy);
		StringBuilder strName = new StringBuilder("Picture ");
		strName.append(++counter);
		this.name = strName.toString();
	}


	@Override
	public void draw(Graphics2D g2d) {
        g2d.drawImage(image,locationX,locationY,width,height,null);
		// TODO Auto-generated method stub
		
	}

}
