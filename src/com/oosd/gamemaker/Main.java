package com.oosd.gamemaker;
import java.io.*;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Main extends JPanel {
	public static void main(String[] args) {
		final int frameWidth = 1200;
		final int frameHeight = 800;
		JFrame frame = new JFrame();
		
		//playgroundPanel.setBackground(Color.BLACK);
		
		frame.setSize(frameWidth, frameHeight);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		JPanel maker = new Maker();
		maker.setSize(400,800);
		maker.setLocation(0,0);
		maker.setBackground(Color.LIGHT_GRAY);
		//whitePanel = maker;
		((Maker)maker).makeGame();
		JPanel playgroundPanel = new Playground((Maker)maker);
		playgroundPanel.setSize(800, 800);
		playgroundPanel.setLocation(400,0);
		frame.add(playgroundPanel);
		frame.add(maker);
		//frame.pack();
		//frame.add(whitePanel);
		System.out.println(frame.getComponentCount());
		frame.setVisible(true);
		
		((Playground)playgroundPanel).startGame();
		
		
		
	}

}