package com.oosd.gamemaker.junit;

import static org.junit.Assert.*;

import org.junit.Test;

import com.oosd.gamemaker.Maker;

public class MakerTest {

	Maker mk = new Maker();
	@Test
	public void test() {
		mk.makeGame();
		int check = mk.getButtons().size();
		assertEquals(3, check);
		
	}

}
