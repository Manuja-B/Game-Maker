package com.oosd.gamemaker.junit;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.event.KeyEvent;
import org.junit.Test;
import com.oosd.gamemaker.models.Ball;
import com.oosd.gamemaker.models.Rectangle;
import com.oosd.gamemaker.panels.Maker;
import com.oosd.gamemaker.panels.Playground;
import com.oosd.gamemaker.behavior.AutomaticMovement;
import com.oosd.gamemaker.behavior.BounceBack;
import com.oosd.gamemaker.behavior.BoundaryBounce;
import com.oosd.gamemaker.behavior.BoundaryRotate;
import com.oosd.gamemaker.behavior.ManualDown;
import com.oosd.gamemaker.behavior.ManualLeft;
import com.oosd.gamemaker.behavior.ManualUp;
import com.oosd.gamemaker.behavior.Reaction;

public class BallTest {

	private Ball b ;
	private Playground pu;
	@Test
   public void test1() {
		//pu.startGame();
		b= new Ball(Color.BLACK, 0, 0, 0, 0, 20, 20);
		pu = new Playground(new Maker());
		b.setAutomaticMovement(new AutomaticMovement());
		b.setBoundaryMovement(new BoundaryBounce());
		b.setManualMovement(new ManualDown(KeyEvent.VK_DOWN));
		b.setManualMovement(new ManualUp(KeyEvent.VK_UP));
		b.setManualMovement(new ManualLeft(KeyEvent.VK_LEFT));
		b.move(pu);
		b.setDx(20);
		b.setDy(20);
		Rectangle rect = new Rectangle(Color.BLUE,0, 0, 0, 0, 20, 20);
		Reaction bounce = new BounceBack(rect, b, null);
		assertEquals(20, b.getDx());
		assertEquals(20, b.getDy());
		bounce.react();
		boolean isReact = bounce.doesReact(rect, b);
		assertEquals(true, isReact);
		assertEquals(-20, b.getDx());
		assertEquals(20, b.getDy());
   }
	@Test
	public void test2() {
		pu = new Playground(new Maker());
		b= new Ball(Color.BLACK, 100, 100, 100, 0, 0,0);
		b.setAutomaticMovement(new AutomaticMovement());
		b.setBoundaryMovement(new BoundaryRotate());
		//System.out.println(b.getX());
		b.update(1000, 100);
		b.move(pu);
		//System.out.println(b.getX());
		
	}
}
