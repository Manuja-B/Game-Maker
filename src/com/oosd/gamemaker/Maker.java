package com.oosd.gamemaker;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.oosd.gamemaker.behavior.AutomaticMovement;
import com.oosd.gamemaker.behavior.BounceBack;
import com.oosd.gamemaker.behavior.ManualMovement;
import com.oosd.gamemaker.behavior.ManualRight;
import com.oosd.gamemaker.behavior.ManualUp;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.Reaction;
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
import java.awt.Desktop;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;

public class Maker extends JPanel implements ActionListener {
	JPanel makerPanel = new JPanel();
	Composite allItems;
	Sprite newSprite;
	int x,y,dx,dy;
	String boundaryReaction;
	private  String selectedpath;
	Image image;
	
	ArrayList<String> keys = new ArrayList<String>() ;
	ArrayList<Movement> manualMovements = new ArrayList<Movement>() ;
	ArrayList<JTextField> textboxes = new ArrayList<JTextField>() ;
	ArrayList<JComboBox<ComboItem>> comboBoxes = new ArrayList<JComboBox<ComboItem>>() ;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<Reaction> reactions = new ArrayList<Reaction>();
	public void addReaction(Reaction reaction) {
		this.reactions.add(reaction);
	}

	public ArrayList<Reaction> getReactions() {
		return reactions;
	}
	
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

	public void makeGame() {
		SpritePropertiesPanel spritePropertyPanelObject=new SpritePropertiesPanel(this); 
		addLabel("Add a new Component", 10, 10,this);
		addLabel("Component Type", 10, 30,this);
		
		addButtonToPanel("Circle",10,70,this);//button 0
		addButtonToPanel("Rectangle",10,100,this);//button 1
		addButtonToPanel("Image",200,70,this);//button 2
		addButtonToPanel("Clock",200,100,this);//button 3
		//addButtonToPanel("Add Component", 10, 300,this); //24
		addButtonToPanel("Add Reaction", 10, 320,this); //23
		addButtonToPanel("Choose Theme",10, 340,this); //25
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
		else if(arg0.getSource() == getButtons().get(4)) {
			JFrame nextFrame = new JFrame();
			JPanel nextPanel = new NextPanel(this);
			nextFrame.add(nextPanel);
//			nextPanel.setPreferredSize(new Dimension(400, 150 ));
			//nextPanel.setPreferredSize(new Dimension(150, 170));
			nextPanel.setSize(400, 400);
			nextFrame.setLocation(150, 100);
			nextFrame.setSize(400, 400);
			nextFrame.setVisible(true);
			//nextFrame.pack();
			
		}
		else if(arg0.getSource() == getButtons().get(2)) {
			
		}
		else if(arg0.getSource() == getButtons().get(5)) {
			
			String path = "C:\\Users\\Maruti\\OneDrive\\Pictures\\Saved Pictures";
			JFileChooser jfc = new JFileChooser(new File(path));
//			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
			
			jfc.setDialogTitle("Multiple file and directory selection:");
			jfc.setMultiSelectionEnabled(true);
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File[] files = jfc.getSelectedFiles();
				 File selectedFile = jfc.getSelectedFile();
				 this.selectedpath = selectedFile.getAbsolutePath();
				 System.out.println(selectedpath);
				 
				Arrays.asList(files).forEach(x -> {
					if (x.isFile()) {
						System.out.println(x.getName());
					}
				});
			}
		}
			
		}
	
	public String getSelectedpath() {
		return selectedpath;
	}
	
	
	public ArrayList<Movement> getManualMovements() {
		return manualMovements;
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
