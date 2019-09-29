package com.oosd.gamemaker.junit;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import org.junit.Test;

import com.oosd.gamemaker.models.Ball;
import com.oosd.gamemaker.*;
import com.oosd.gamemaker.behavior.AutomaticMovement;
import com.oosd.gamemaker.behavior.BoundaryBounce;
import com.oosd.gamemaker.behavior.ManualDown;
import com.oosd.gamemaker.behavior.ManualLeft;
import com.oosd.gamemaker.behavior.ManualUp;

public class BallTest {

	public Ball b = new Ball(Color.BLACK, 0, 0, 0, 0, 20, 20);
	public Playground pu = new Playground(new Maker());
	

	@Test
   public void test() {
		//pu.startGame();
	
		b.setAutomaticMovement(new AutomaticMovement());
		b.setBoundaryMovement(new BoundaryBounce());
		b.setManualMovement(new ManualDown(KeyEvent.VK_DOWN));
		b.setManualMovement(new ManualUp(KeyEvent.VK_UP));
		b.setManualMovement(new ManualLeft(KeyEvent.VK_LEFT));
		b.move(pu);
		b.setDx(20);
		b.setDy(20);
		assertEquals(20, b.getDx());
		assertEquals(20, b.getDy());
   }
}
