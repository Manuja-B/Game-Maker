package com.oosd.gamemaker.behavior;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.oosd.gamemaker.Playground;
import com.oosd.gamemaker.models.DigitalClock;
import com.oosd.gamemaker.models.Sprite;

public class ClockTickTest {
	
	@Mock
	Playground playground;
	
	@Before
	public void setup() {
		playground = Mockito.mock(Playground.class);
	} 
	
	@Test
	public void testUnidirectionalXY() {
		ClockTick clockTick = new ClockTick();
		Sprite sprite = new DigitalClock(100, 100);
		sprite.play();
		for(int i = 0; i<6000;i++)
		{
			clockTick.move(sprite, playground);
		}
		assertEquals(1, sprite.getLocationX());
		assertEquals(0, sprite.getLocationY());
		
	}
}
