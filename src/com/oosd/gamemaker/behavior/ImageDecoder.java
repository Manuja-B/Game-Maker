package com.oosd.gamemaker.behavior;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;



public class ImageDecoder implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public ImageDecoder()
	{
		//Empty Constructor
	}
	
	public BufferedImage decodeToImage(String imageString) {

		BufferedImage image = null;
		byte[] imageByte;
		try {
			imageByte = DatatypeConverter.parseBase64Binary(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			
		}
		return image;
	}

}
