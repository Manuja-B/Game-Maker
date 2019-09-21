package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.oosd.gamemaker.behavior.AutomaticMovement;
import com.oosd.gamemaker.behavior.ManualMovement;
import com.oosd.gamemaker.behavior.ManualUp;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.BoundaryBounce;
import com.oosd.gamemaker.behavior.ClockTick;
import com.oosd.gamemaker.models.Ball;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.DigitalClock;
import com.oosd.gamemaker.models.Rectangle;
import com.oosd.gamemaker.models.Sprite;

public class Maker extends JPanel implements ActionListener {
	JPanel makerPanel = new JPanel();
	Composite allItems;
	Sprite currentSprite;
	int x,y,dx,dy;
	String boundaryReaction;
	ArrayList<String> keys = new ArrayList<String>() ;
	ArrayList<String> manualMovement = new ArrayList<String>() ;
	ArrayList<JTextField> textboxes = new ArrayList<JTextField>() ;
	ArrayList<JComboBox<String>> comboBoxes = new ArrayList<JComboBox<String>>() ;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	public Maker() {
		allItems = new Composite();
		this.setLayout(null);
	}

	public void addLabel(String message, int x, int y) {
		JLabel label = new JLabel(message);
		label.setBounds(x, y, 200, 20);
		this.add(label);
	}

	public void makeGame() {
		addLabel("Add a new Component", 10, 10);
		addLabel("Component Type", 10, 30);
		addCombobox(new String[] { "Ball", "Paddle", "Brick", "Clock" }, 200, 30); //2
		addLabel("Location", 10, 50);
		addLabel("x", 180, 50); 
		addTextBox(200,50);  
		addLabel("y", 280, 50); 
		addTextBox(300,50);
		
		addLabel("Dimensions", 10, 70);
		addLabel("Height", 140, 70); //4
		addTextBox(200,70);  //5
		addLabel("Width", 250, 70); //6
		addTextBox(300,70); //7
		
		addLabel("Automatic Movement", 10, 90 ); //8
		addLabel("dx", 180, 90); //9
		addTextBox(200,90); //10
		addLabel("dy", 250, 90); //11
		addTextBox(270,90); //12
		addLabel("Boundary Reaction", 10, 110); //13
		addCombobox(new String[] { "Bounce", "Rotate", "Vanish" }, 200, 110); //14
		addLabel("Keypress", 10, 170); //15
		addCombobox(new String[] { "Up","Down"}, 200, 170); //16
		addLabel("Movement", 10, 190); //17 
		addCombobox(new String[] { "Up","Down"}, 200, 190); //18
		addButtonToPanel("Add Manual Movement", 10, 210); //19
		addLabel("Reactions", 10, 260); //20
		ArrayList<Sprite> items =  (ArrayList)allItems.getAllSprites(); 
		String componentNames[] = new String[items.size()]; 
		for(int i = 0; i < items.size();i++) {
			componentNames[i] = items.get(i).getName();
		}
		addCombobox(componentNames, 10, 280); //21
		addCombobox(new String[] { "Bounce Back", "Explode"}, 150, 280); //22
		addButtonToPanel("Add Reaction", 10, 300); //23
		addButtonToPanel("Add Component", 10, 320); //24
	}
	
	public void addTextBox(int x, int y) {
		JTextField  textbox = new JTextField();
		textbox.setBounds(x,y,50,20);
		textbox.addActionListener(this);
		textboxes.add(textbox);
		this.add(textbox);
		
	}
	
	public void addButtonToPanel(String name, int x, int y) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(x, y, 200, 20);
		this.add(button);
		buttons.add(button);
	}
	
	public void addSprite() {
		String x = textboxes.get(0).getText();
		String y = textboxes.get(1).getText();
		String height = textboxes.get(2).getText();
		String width = textboxes.get(3).getText();
		String dx = textboxes.get(4).getText();
		String dy = textboxes.get(5).getText();
		Sprite newSprite;
		int componentIndex = comboBoxes.get(0).getSelectedIndex();
		int boundaryBehavior = comboBoxes.get(1).getSelectedIndex();
		System.out.println(x+","+y);
		System.out.println("Hey"+componentIndex);
		if(componentIndex == 0) {

			newSprite = new Ball(Color.BLUE, Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(height), Integer.parseInt(width),Integer.parseInt(dx),Integer.parseInt(dy));
			//newSprite.setManualMovement(new AutomaticMovement());
			newSprite.setAutomaticMovement(new AutomaticMovement());
			if(boundaryBehavior ==0) {
				//set boundary behavior to bounce 
				   newSprite.setBoundaryMovement(new BoundaryBounce());
			}
			else if(boundaryBehavior == 1) {
				//rotate
			}
			else if(boundaryBehavior == 2) {
				//vanish
			}
			allItems.add(newSprite);
		}
		
		else if(componentIndex == 1) {
			newSprite = new Rectangle(Color.RED, Integer.parseInt(x), Integer.parseInt(y), 10, 10);
			Movement spriteManual = new ManualUp(KeyEvent.VK_UP);
			newSprite.setManualMovement(spriteManual);
			KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	        manager.addKeyEventDispatcher((KeyEventDispatcher) spriteManual);	
			
			allItems.add(newSprite);
		}
		else if(componentIndex == 3) {
			newSprite = new DigitalClock(Integer.parseInt(x), Integer.parseInt(y));
			newSprite.setAutomaticMovement(new ClockTick());
			allItems.add(newSprite);
		}
	}
	
	public Composite getAllItems() {
		return allItems;
	}

	public void addCombobox(String labels[], int x, int y) {
		JComboBox<String> combo = new JComboBox<>(labels);
		combo.setBounds(x, y, 100, 20);
		combo.setMaximumSize(combo.getPreferredSize());
		comboBoxes.add(combo);
		this.add(combo);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < buttons.size(); i++) {
			if (arg0.getSource() == buttons.get(2)) {
				
				addSprite();
			}
			else if(arg0.getSource() == buttons.get(0)) {
			}
		}
	}
}
