package com.oosd.gamemaker.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.oosd.gamemaker.models.DigitalClock;

public class ClockTest {

	private DigitalClock digitalClockTest = new DigitalClock(0, 0);
	@Test
	public void test() {
		
			digitalClockTest.setDx(20);
			digitalClockTest.setDy(20);
			assertEquals(20, digitalClockTest.getDx());
			assertEquals(20, digitalClockTest.getDy());
			assertEquals(0, digitalClockTest.getX());
			assertEquals(0, digitalClockTest.getY());
	}

	
}
