package com.oosd.gamemaker.models;

import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Picture extends Sprite{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6449562524584478972L;
	private Image image ;
	private File f=new File("//home//bivas//Pictures//football.jepg");
	private static int counter = 0;
	public Picture( int initialPositionX, int initialPositionY, int imageHeight, int imageWidth,int dx, int dy)
	{	
		this.height = imageHeight;
		this.width = imageWidth;
		this.update(initialPositionX, initialPositionY);
		this.setDx(dx);
		this.setDy(dy);
		try {
			image=ImageIO.read(f);
			
		} catch (IOException e) {
			System.out.println("Cannot find image"+e.getMessage());

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
	}

}
