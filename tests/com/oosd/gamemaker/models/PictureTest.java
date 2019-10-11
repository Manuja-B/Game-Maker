package com.oosd.gamemaker.models;

import java.awt.Graphics2D;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class PictureTest {
	
	private Picture picture;
	private String path;
	
	@Mock
	Graphics2D graphics2d;

	@Before
	public void setup() {
		graphics2d = Mockito.mock(Graphics2D.class);
		this.path = System.getProperty("user.dir");
	}
	
	
	@Test
	public void testPictureTest()
	{
		picture = new Picture(100, 100, 40, 40, 0, 0, this.path + "/resources/Ball.png" );
		picture.draw(graphics2d);
	}
	

}
