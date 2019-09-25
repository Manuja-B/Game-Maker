package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.oosd.gamemaker.behavior.AutomaticMovement;
import com.oosd.gamemaker.behavior.ManualMovement;
import com.oosd.gamemaker.behavior.ManualRight;
import com.oosd.gamemaker.behavior.ManualUp;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.BoundaryBounce;
import com.oosd.gamemaker.behavior.BoundaryRotate;
import com.oosd.gamemaker.behavior.ClockTick;
import com.oosd.gamemaker.behavior.ManualDown;
import com.oosd.gamemaker.behavior.ManualLeft;
import com.oosd.gamemaker.models.Ball;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.DigitalClock;

import com.oosd.gamemaker.models.Picture;
import com.oosd.gamemaker.models.Rectangle;
import com.oosd.gamemaker.models.Sprite;

public class Maker extends JPanel implements ActionListener {
	JPanel makerPanel = new JPanel();
	Composite allItems;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	int currentSpriteIndex=-1;
	public int getCurrentSpriteIndex() {
		return currentSpriteIndex;
	}

	public Maker() {
		allItems = new Composite();
		this.setLayout(null);
	}

	public void addLabel(String message, int x, int y, JPanel panel) {
		JLabel label = new JLabel(message);
		label.setBounds(x, y, 200, 20);
		panel.add(label);
	}
	
	public void addButtonToPanel(String name, int x, int y, JPanel panel) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(x, y, 200, 20);
		panel.add(button);
		buttons.add(button);
	}


	public void makeGame() {
		SpritePropertiesPanel spritePropertyPanelObject=new SpritePropertiesPanel(this); 
		addLabel("Add a new Component", 10, 10,this);
		addLabel("Component Type", 10, 30,this);
		
		addButtonToPanel("Circle",10,70,this);//button 0
		addButtonToPanel("Rectangle",10,100,this);//button 1
		addButtonToPanel("Image",200,70,this);//button 2
		addButtonToPanel("Clock",200,100,this);//button 3
		
		
		
		//addCombobox(new ComboItem[] { new ComboItem("Ball", 0) , new ComboItem("Rectangle", 1) , new ComboItem("Image", 2) , new ComboItem("Clock", 3)  }, 200, 30,this); //2
		
		
		//addLabel("Location", 10, 50,this);
		//addLabel("x", 180, 50,this); 
		//addTextBox(200,50,this);  
		//addLabel("y", 280, 50,this); 
		//addTextBox(300,50,this);
		
		//addLabel("Dimensions", 10, 70,this);
		//addLabel("Height", 140, 70,this); //4
		//addTextBox(200,70,this);  //5
		//addLabel("Width", 250, 70,this); //6
		//addTextBox(300,70,this); //7
		
		//addLabel("Automatic Movement", 10, 90,this ); //8
		//addLabel("dx", 180, 90,this); //9
//		addTextBox(200,90,this); //10
//		addLabel("dy", 250, 90,this); //11
//		addTextBox(270,90,this); //12
//		addLabel("Boundary Reaction", 10, 110,this); //13
//		addCombobox(new ComboItem[] { new ComboItem("Bounce", 0) , new ComboItem("Rotate", 1) , new ComboItem("Vanish", 2)}, 200, 110,this); //2
//		addLabel("Keypress", 10, 170,this); //15
//		addCombobox(new ComboItem[] { new ComboItem("Up", KeyEvent.VK_UP) , new ComboItem("Down", KeyEvent.VK_DOWN) , new ComboItem("Left",  KeyEvent.VK_LEFT), new ComboItem("Right", KeyEvent.VK_RIGHT)}, 200, 170,this); //2
//		addLabel("Movement", 10, 190,this); //17 
//		addButtonToPanel("Add Manual Movement", 10, 210,this); //19
//		addCombobox(new ComboItem[] { new ComboItem("Up", 0) , new ComboItem("Down", 1) , new ComboItem("Left", 2), new ComboItem("Right", 3)}, 200, 190,this); //2
//		addLabel("Reactions", 10, 260,this); //20
//		ArrayList<Sprite> items =  (ArrayList)allItems.getAllSprites(); 
//		String componentNames[] = new String[items.size()]; 
//		for(int i = 0; i < items.size();i++) {
	//		componentNames[i] = items.get(i).getName();
		//}
//		addButtonToPanel("Add Component", 10, 300,this); //24
//		addButtonToPanel("Add Reaction", 10, 320,this); //23
//		
	}
	
	
	
	
		
		
	public Composite getAllItems() {
		return allItems;
	}

	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==buttons.get(0) || arg0.getSource()==buttons.get(1) ||arg0.getSource()==buttons.get(2) ||arg0.getSource()==buttons.get(3))
		{	
			if(arg0.getSource()==buttons.get(0))
				currentSpriteIndex=0;
			else if(arg0.getSource()==buttons.get(1))
				currentSpriteIndex=1;
			else if(arg0.getSource()==buttons.get(2))
				currentSpriteIndex=2;
			else if(arg0.getSource()==buttons.get(3))
				currentSpriteIndex=3;
			JFrame frame1 = new JFrame();
			frame1.setSize(400,400);
			SpritePropertiesPanel spritePropertiesPanelObject=new SpritePropertiesPanel(this);
			spritePropertiesPanelObject.setSize(200,800);
			spritePropertiesPanelObject.setLocation(10,10);
			spritePropertiesPanelObject.setBackground(Color.LIGHT_GRAY);
			//whitePanel = maker;
		
			//JPanel playgroundPanel = new Playground((spritePropertiesPanelObject));
			//playgroundPanel.setSize(400, 800);
			//playgroundPanel.setLocation(400,0);
			//frame.add(playgroundPanel);
			frame1.add(spritePropertiesPanelObject);
			//frame.pack();
			//frame.add(whitePanel);
			System.out.println(frame1.getComponentCount());
			frame1.setVisible(true);
		
			spritePropertiesPanelObject.drawSpritePropertiesPanel();
		
		}

	}
	
	
	public ArrayList<JButton> getButtons() {
		return buttons;
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
