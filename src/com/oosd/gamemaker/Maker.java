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
import com.oosd.gamemaker.behavior.ManualRight;
import com.oosd.gamemaker.behavior.ManualUp;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.BoundaryBounce;
import com.oosd.gamemaker.behavior.ClockTick;
import com.oosd.gamemaker.behavior.ManualDown;
import com.oosd.gamemaker.behavior.ManualLeft;
import com.oosd.gamemaker.models.Ball;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.DigitalClock;
import com.oosd.gamemaker.models.Rectangle;
import com.oosd.gamemaker.models.Sprite;

public class Maker extends JPanel implements ActionListener {
	JPanel makerPanel = new JPanel();
	Composite allItems;
	Sprite newSprite;
	int x,y,dx,dy;
	String boundaryReaction;
	ArrayList<String> keys = new ArrayList<String>() ;
	ArrayList<Movement> manualMovements = new ArrayList<Movement>() ;
	ArrayList<JTextField> textboxes = new ArrayList<JTextField>() ;
	ArrayList<JComboBox<ComboItem>> comboBoxes = new ArrayList<JComboBox<ComboItem>>() ;
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
		addCombobox(new ComboItem[] { new ComboItem("Ball", 0) , new ComboItem("Rectangle", 1) , new ComboItem("Image", 2) , new ComboItem("Clock", 3)  }, 200, 30); //2
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
		addCombobox(new ComboItem[] { new ComboItem("Bounce", 0) , new ComboItem("Rotate", 1) , new ComboItem("Vanish", 2)}, 200, 110); //2
		addLabel("Keypress", 10, 170); //15
		addCombobox(new ComboItem[] { new ComboItem("Up", KeyEvent.VK_UP) , new ComboItem("Down", KeyEvent.VK_DOWN) , new ComboItem("Left",  KeyEvent.VK_LEFT), new ComboItem("Right", KeyEvent.VK_RIGHT)}, 200, 170); //2
		addLabel("Movement", 10, 190); //17 
		addButtonToPanel("Add Manual Movement", 10, 210); //19
		addCombobox(new ComboItem[] { new ComboItem("Up", 0) , new ComboItem("Down", 1) , new ComboItem("Left", 2), new ComboItem("Right", 3)}, 200, 190); //2
		addLabel("Reactions", 10, 260); //20
		ArrayList<Sprite> items =  (ArrayList)allItems.getAllSprites(); 
		String componentNames[] = new String[items.size()]; 
		for(int i = 0; i < items.size();i++) {
			componentNames[i] = items.get(i).getName();
		}
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
		int componentIndex = comboBoxes.get(0).getSelectedIndex();
		int boundaryBehavior = comboBoxes.get(1).getSelectedIndex();
		if(componentIndex == 0) {

			newSprite = new Ball(Color.BLUE, Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(height), Integer.parseInt(width),Integer.parseInt(dx),Integer.parseInt(dy));
			newSprite.setAutomaticMovement(new AutomaticMovement());
			if(boundaryBehavior == 0) {
				//set boundary behavior to bounce 
				   newSprite.setBoundaryMovement(new BoundaryBounce());
			}
			else if(boundaryBehavior == 1) {
				//rotate
			}
			else if(boundaryBehavior == 2) {
				//vanish
			}
			for(Movement manual :manualMovements) {
				newSprite.setManualMovement(manual);
			}
		}
		
		else if(componentIndex == 1) {
			newSprite = new Rectangle(Color.RED, Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(height), Integer.parseInt(width),Integer.parseInt(dx),Integer.parseInt(dy) );
			newSprite.setAutomaticMovement(new AutomaticMovement());
			if(boundaryBehavior == 0) {
				//set boundary behavior to bounce 
				   newSprite.setBoundaryMovement(new BoundaryBounce());
			}
			else if(boundaryBehavior == 1) {
				//rotate
			}
			else if(boundaryBehavior == 2) {
				//vanish
			}
			for(Movement manual :manualMovements) {
				newSprite.setManualMovement(manual);
			}
		}
		else if(componentIndex == 3) {
			newSprite = new DigitalClock(Integer.parseInt(x), Integer.parseInt(y));
			newSprite.setAutomaticMovement(new ClockTick());
			
		}
		for(Movement manual :manualMovements) {
			newSprite.setManualMovement(manual);
		}
		allItems.add(newSprite);
		manualMovements.clear();
	}
	
	public Composite getAllItems() {
		return allItems;
	}

	public void addCombobox(ComboItem items[], int x, int y) {
		JComboBox<ComboItem> combo = new JComboBox<ComboItem>(items);
		combo.setBounds(x, y, 100, 20);
		combo.setMaximumSize(combo.getPreferredSize());
		comboBoxes.add(combo);
		this.add(combo);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == buttons.get(2)) {
			addSprite();
		}
		else if(arg0.getSource() == buttons.get(0)) {
			Object keyItem = comboBoxes.get(2).getSelectedItem();
			int keyCode = ((ComboItem)keyItem).getValue();
			Movement spriteManual = null;
			Object actionItem = comboBoxes.get(3).getSelectedItem();
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
	
	class ComboItem
	{
	    private String label;
	    private int value;

	    public ComboItem(String label, int value)
	    {
	        this.label = label;
	        this.value = value;
	    }

	    @Override
	    public String toString()
	    {
	        return label;
	    }

	    public String getKey()
	    {
	        return label;
	    }

	    public int getValue()
	    {
	        return value;
	    }
	}
}
