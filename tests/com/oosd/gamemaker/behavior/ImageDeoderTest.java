package com.oosd.gamemaker.behavior;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.Test;

public class ImageDeoderTest {
	
	private String path;
	
	public ImageDeoderTest() {
		this.path = System.getProperty("user.dir");
	}
	
	@Test
	public void testImageDecoder() throws IOException
	{
		ImageEncoder imageEncoder =  new ImageEncoder(this.path + "/resources/Ball.png");
		String actualEncodedImageString = imageEncoder.encodeToString(imageEncoder.getBufferedImage());
		ImageDecoder imageDecoder =  new ImageDecoder();
		BufferedImage image = imageDecoder.decodeToImage(actualEncodedImageString);
		assertEquals(imageEncoder.getBufferedImage().getHeight(), image.getHeight());
		assertEquals(imageEncoder.getBufferedImage().getWidth(), image.getWidth());
	}

}
