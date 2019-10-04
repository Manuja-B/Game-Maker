package com.oosd.gamemaker.behavior;

import static org.junit.Assert.assertEquals;

import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.oosd.gamemaker.Playground;

public class ManualMovementTest {
	
	ManualMovement manualMovement;
	
	@Mock
	Playground playground;
	
	@Before
	public void setup() {
		playground = Mockito.mock(Playground.class);
	}
	
	
	@Test
	public void testDispatcherKeyEventUp() {
		manualMovement = new ManualMovement(KeyEvent.VK_UP, 0);
		KeyEvent keyEvent = new KeyEvent(playground, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_UP);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(true, manualMovement.getIsUp());
		keyEvent = new KeyEvent(playground, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_UP);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(false, manualMovement.getIsUp());
	}
	
	@Test
	public void testDispatcherKeyEventDown() {
		manualMovement = new ManualMovement(KeyEvent.VK_DOWN, 1);
		KeyEvent keyEvent = new KeyEvent(playground, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_DOWN);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(true, manualMovement.getIsDown());
		keyEvent = new KeyEvent(playground, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_DOWN);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(false, manualMovement.getIsDown());
	}
	
	@Test
	public void testDispatcherKeyEventLeft() {
		manualMovement = new ManualMovement(KeyEvent.VK_LEFT, 2);
		KeyEvent keyEvent = new KeyEvent(playground, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_LEFT);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(true, manualMovement.getIsLeft());
		keyEvent = new KeyEvent(playground, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_LEFT);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(false, manualMovement.getIsLeft());
	}
	
	@Test
	public void testDispatcherKeyEventRight() {
		manualMovement = new ManualMovement(KeyEvent.VK_RIGHT, 3);
		KeyEvent keyEvent = new KeyEvent(playground, KeyEvent.KEY_PRESSED, 0, 0, KeyEvent.VK_RIGHT);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(true, manualMovement.getIsRight());
		keyEvent = new KeyEvent(playground, KeyEvent.KEY_RELEASED, 0, 0, KeyEvent.VK_RIGHT);
		manualMovement.dispatchKeyEvent(keyEvent);
		assertEquals(false, manualMovement.getIsRight());
	}
	
	

}
