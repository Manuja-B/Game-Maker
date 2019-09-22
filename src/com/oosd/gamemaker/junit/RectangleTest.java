package com.oosd.gamemaker.junit;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import com.oosd.gamemaker.models.Rectangle;

public class RectangleTest {

	public Rectangle rec = new Rectangle(Color.BLACK, 0, 0, 0, 0, 0, 0);
	@Test
	public void test() {
		rec.setDx(20);
		rec.setDy(20);
		assertEquals(20, rec.getDx());
		assertEquals(20, rec.getDy());
	}

}
