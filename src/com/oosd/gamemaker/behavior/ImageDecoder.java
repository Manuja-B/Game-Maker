package com.oosd.gamemaker.behavior;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import Decoder.BASE64Decoder;


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
			BASE64Decoder decoder = new BASE64Decoder();
			imageByte = decoder.decodeBuffer(imageString);
			ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
			image = ImageIO.read(bis);
			bis.close();
		} catch (Exception e) {
			
		}
		return image;
	}

}
