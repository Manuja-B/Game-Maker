package com.oosd.gamemaker.junit;

import static org.junit.Assert.*;

import java.awt.Color;
import org.junit.Test;
import com.oosd.gamemaker.models.Ball;

public class BallTest {

	private Ball b = new Ball(Color.BLACK, 0, 0, 0, 0, 20, 20);

	@Test
   public void test() {
	   b.setDx(20);
	   b.setDy(20);
	   assertEquals(20, b.getDx());
	   assertEquals(20, b.getDy());
   }
}
