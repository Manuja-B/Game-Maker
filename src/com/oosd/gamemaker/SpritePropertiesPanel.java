package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.oosd.gamemaker.ComboItem;
import com.oosd.gamemaker.behavior.AutomaticMovement;
import com.oosd.gamemaker.behavior.BoundaryBounce;
import com.oosd.gamemaker.behavior.BoundaryRotate;
import com.oosd.gamemaker.behavior.ClockTick;
import com.oosd.gamemaker.behavior.ManualDown;
import com.oosd.gamemaker.behavior.ManualLeft;
import com.oosd.gamemaker.behavior.ManualRight;
import com.oosd.gamemaker.behavior.ManualUp;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.models.Ball;
import com.oosd.gamemaker.models.DigitalClock;
import com.oosd.gamemaker.models.Picture;
import com.oosd.gamemaker.models.Rectangle;
import com.oosd.gamemaker.models.Sprite;

public class SpritePropertiesPanel extends JPanel implements ActionListener{
	Maker maker;
	Sprite newSprite;
	int x,y,dx,dy;
	String boundaryReaction;
	
	ArrayList<String> keys = new ArrayList<String>() ;
	ArrayList<Movement> manualMovements = new ArrayList<Movement>() ;
	ArrayList<JTextField> textboxes = new ArrayList<JTextField>() ;
	ArrayList<JComboBox<ComboItem>> comboBoxes = new ArrayList<JComboBox<ComboItem>>() ;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	
	SpritePropertiesPanel(Maker maker)
	{
		this.maker=maker;
		this.setLayout(null);
	}
	
	
	public void addLabel(String message, int x, int y, JPanel panel) {
		JLabel label = new JLabel(message);
		label.setBounds(x, y, 200, 20);
		panel.add(label);
	}
	
	public void addTextBox(int x, int y, JPanel panel) {
		JTextField  textbox = new JTextField();
		textbox.setBounds(x,y,50,20);
		textbox.addActionListener(this);
		textboxes.add(textbox);
		panel.add(textbox);
		
	}
	
	public void addButtonToPanel(String name, int x, int y, JPanel panel) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(x, y, 200, 20);
		panel.add(button);
		buttons.add(button);
	}

	
	public void addCombobox(ComboItem items[], int x, int y, JPanel panel) {
		JComboBox<ComboItem> combo = new JComboBox<ComboItem>(items);
		combo.setBounds(x, y, 100, 20);
		combo.setMaximumSize(combo.getPreferredSize());
		comboBoxes.add(combo);
		panel.add(combo);
	}
	
	
	public void addSprite(int spriteIndex) {
		String x = textboxes.get(0).getText().isEmpty()?"0":textboxes.get(0).getText();
		String y = textboxes.get(1).getText().isEmpty()?"0":textboxes.get(1).getText();
		String height = textboxes.get(2).getText().isEmpty()?"0":textboxes.get(2).getText();
		String width = textboxes.get(3).getText().isEmpty()?"0":textboxes.get(3).getText();
		String dx = textboxes.get(4).getText().isEmpty()?"0":textboxes.get(4).getText();
		String dy = textboxes.get(5).getText().isEmpty()?"0":textboxes.get(5).getText();
		//int componentIndex = comboBoxes.get(0).getSelectedIndex();
		int boundaryBehavior = comboBoxes.get(0).getSelectedIndex();
		if(spriteIndex == 0) {

			newSprite = new Ball(Color.BLUE, Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(height), Integer.parseInt(width),Integer.parseInt(dx),Integer.parseInt(dy));
			newSprite.setAutomaticMovement(new AutomaticMovement());
			if(boundaryBehavior == 0) {
				//set boundary behavior to bounce 
				   newSprite.setBoundaryMovement(new BoundaryBounce());
			}
			else if(boundaryBehavior == 1) {
				//rotate
				newSprite.setBoundaryMovement(new BoundaryRotate());
			}
			else if(boundaryBehavior == 2) {
				//vanish
			}
			for(Movement manual :manualMovements) {
				newSprite.setManualMovement(manual);
			}
		}
		
		else if(spriteIndex == 1) {
			newSprite = new Rectangle(Color.RED, Integer.parseInt(x), Integer.parseInt(y),  Integer.parseInt(width),Integer.parseInt(height),Integer.parseInt(dx),Integer.parseInt(dy) );
			newSprite.setAutomaticMovement(new AutomaticMovement());
			if(boundaryBehavior == 0) {
				
				   newSprite.setBoundaryMovement(new BoundaryBounce());
			}
			else if(boundaryBehavior == 1) {
				   newSprite.setBoundaryMovement(new BoundaryRotate());
			}
			else if(boundaryBehavior == 2) {
				//vanish
			}
			for(Movement manual :manualMovements) {
				newSprite.setManualMovement(manual);
			}
		}
		else if(spriteIndex == 3) {
			newSprite = new DigitalClock(Integer.parseInt(x), Integer.parseInt(y));
			newSprite.setAutomaticMovement(new ClockTick());
			
		}
		
		else if(spriteIndex == 2) {
			newSprite = new Picture( Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(height), Integer.parseInt(width),Integer.parseInt(dx),Integer.parseInt(dy));
			newSprite.setAutomaticMovement(new AutomaticMovement());
			
			
			if(boundaryBehavior == 0) {
				//set boundary behavior to bounce 
				   newSprite.setBoundaryMovement(new BoundaryBounce());
			}
			else if(boundaryBehavior == 1) {
				newSprite.setBoundaryMovement(new BoundaryRotate());
			}
			else if(boundaryBehavior == 2) {
				//vanish
			}
			maker.allItems.add(newSprite);
		}
		
		for(Movement manual :manualMovements) {
			newSprite.setManualMovement(manual);
		}
		maker.allItems.add(newSprite);
		//maker.getManualMovements().clear();
		
		JPanel listPanel = new ListPanel(maker.allItems);
		listPanel.setSize(200, 200);
		listPanel.setLocation(10, 500);
		maker.remove(maker.getListPanel());
		maker.setListPanel(listPanel);
		maker.add(listPanel);
		maker.setVisible(false);
		maker.setVisible(true);
	}

	
	
	void drawSpritePropertiesPanel()
	{
		maker.addLabel("Location", 10, 50,this);
		maker.addLabel("x", 10, 50,this); 
		addTextBox(200,50,this);  
		maker.addLabel("y", 280, 50,this); 
		addTextBox(300,50,this);
		
		
		maker.addLabel("Dimensions", 10, 70, this);
		maker.addLabel("Height", 140, 70, this); //4
		addTextBox(200,70, this);  //5
		maker.addLabel("Width", 250, 70,this); //6
		addTextBox(300,70,this); //7
		
		maker.addLabel("Automatic Movement", 10, 90,this ); //8
		maker.addLabel("dx", 180, 90, this); //9
		addTextBox(200,90, this); //10
		maker.addLabel("dy", 250, 90, this); //11
		addTextBox(270,90, this); //12
		maker.addLabel("Boundary Reaction", 10, 110, this); //13
		addCombobox(new ComboItem[] { new ComboItem("Bounce", 0) , new ComboItem("Rotate", 1) , new ComboItem("Vanish", 2)}, 200, 110,this); //2
		maker.addLabel("Keypress", 10, 170, this); //15
		addCombobox(new ComboItem[] { new ComboItem("Up", KeyEvent.VK_UP) , new ComboItem("Down", KeyEvent.VK_DOWN) , new ComboItem("Left",  KeyEvent.VK_LEFT), new ComboItem("Right", KeyEvent.VK_RIGHT)}, 200, 170,this); //2
		maker.addLabel("Movement", 10, 190, this); //17 
		
		addCombobox(new ComboItem[] { new ComboItem("Up", 0) , new ComboItem("Down", 1) , new ComboItem("Left", 2), new ComboItem("Right", 3)}, 200, 190,this); //2
		addButtonToPanel("Add Manual Movement", 10, 210,this); //19 //button 5
		
		addButtonToPanel("Add Component", 10, 320,this);//24 //button 6
		
		
		
//		maker.items = maker.allItems.getAllSprites(); 
//		
//		maker.componentNames = new String[maker.items.size()];
		
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		// TODO Auto-generated method stub
		if (arg0.getSource() == buttons.get(1)) {
			addSprite(maker.getCurrentSpriteIndex());
		}
		else if(arg0.getSource() == buttons.get(0)) {
			Object keyItem = comboBoxes.get(1).getSelectedItem();
			int keyCode = ((ComboItem)keyItem).getValue();
			Movement spriteManual = null;
			Object actionItem = comboBoxes.get(2).getSelectedItem();
			int itemCode = ((ComboItem)actionItem).getValue();
			if(itemCode == 0) {
				 spriteManual = new ManualUp(keyCode);
			}
			else if(itemCode == 1) {
				 spriteManual = new ManualDown(keyCode);
			}
			else if(itemCode == 2) {
				spriteManual = new ManualLeft(keyCode);
			}
			else if(itemCode == 3) {
			   spriteManual = new ManualRight(keyCode);
			}
			
			KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	        manager.addKeyEventDispatcher((KeyEventDispatcher) spriteManual);	
	        manualMovements.add(spriteManual);
		}
		
		
	}
		


}
