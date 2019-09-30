package com.oosd.gamemaker.junit;
import static org.junit.Assert.*;
import org.junit.Test;

import com.oosd.gamemaker.models.DigitalClock;

public class ClockTest {

	public DigitalClock dc = new DigitalClock(0, 0);
	@Test
	public void test() {
		
			dc.setDx(20);
			dc.setDy(20);
			assertEquals(20, dc.getDx());
			assertEquals(20, dc.getDy());
			assertEquals(0, dc.getX());
			assertEquals(0, dc.getY());
	}

	
}
