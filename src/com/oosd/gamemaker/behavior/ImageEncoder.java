package com.oosd.gamemaker.behavior;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Base64;

import javax.imageio.ImageIO;

public class ImageEncoder implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private transient BufferedImage bimage;
	
	public ImageEncoder(String fileName)
	{
		try 
		{
			this.bimage = ImageIO.read(new File(fileName));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}	
	}
	
	
	public BufferedImage getBufferedImage()
	{
		return this.bimage;
	}
	
	
	public String encodeToString(BufferedImage image) {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try {
            ImageIO.write(image, "PNG", bos);
            byte[] imageBytes = bos.toByteArray();

            imageString = Base64.getEncoder().encodeToString(imageBytes);
         
            bos.close();
        } catch (IOException e) {
        }
        return imageString;
    }

}