package com.oosd.gamemaker.panels;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.oosd.gamemaker.LevelObject;
import com.oosd.gamemaker.SaveObject;
import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.Reaction;
import com.oosd.gamemaker.models.Composite;
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Maker extends PanelMaker implements ActionListener {
	private static final long serialVersionUID = 1L;
	private Composite allItems;
	private String path ;
	private  String selectedpath;
	JPanel listPanel = new JPanel();
	Image image;
	private ArrayList<LevelObject> levelObjects=new ArrayList<>();
	int currentLevel=0;
	int currentSpriteIndex=-1;	
	private final String userDir = "user.dir";
	
	public Maker() {
		allItems = new Composite();
		this.setLayout(null);
	}
	public JPanel getListPanel() {
		return listPanel;
	}
	public void setListPanel(JPanel listPanel) {
		this.listPanel = listPanel;
	}
	public ArrayList<LevelObject> getLevelObjects() {
		return levelObjects;
	}
	public void setLevelObjects(ArrayList<LevelObject> levelObjects) {
		this.levelObjects = levelObjects;
	}
	public void addReaction(Reaction reaction) {
		this.reactions.add(reaction);
	}
	public List<Reaction> getReactions() {
		return reactions;
	}

	public int getCurrentSpriteIndex() {
		return currentSpriteIndex;
	}
	public void makeGame() {
		levelObjects.add(new LevelObject(reactions,getAllItems(),selectedpath));
		addLabel("You are creating level "+currentLevel,10,10,this);
		addLabel("Add a new Component", 10, 30,this);
		addLabel("Component Type", 10, 50,this);
		addButtonToPanel("Circle",60,70,this);
		addButtonToPanel("Rectangle",60,120,this);
		addButtonToPanel("Image",200,70,this);
		addButtonToPanel("Clock",200,120,this);
		addButtonToPanel("Add Reaction", 120, 200,this);
		addButtonToPanel("Choose Theme",120, 240,this); 
		addButtonToPanel("Add Level", 120, 280, this);
		addButtonToPanel("Save", 120, 320, this);
		addButtonToPanel("Load", 120, 360, this);
		addTextBox(60,410, this);
		addButtonToPanel("Go To Level", 120,400, this);
	}
	@Override	
	public void addTextBox(int x, int y, JPanel panel) {
		JTextField  textbox = new JTextField();
		textbox.setBounds(x,y,50,20);
		textbox.addActionListener(this);
		textboxes.add(textbox);
		panel.add(textbox);
		
	}
	@Override
	public void addButtonToPanel(String name, int x, int y, JPanel panel) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(x, y, 110, 40);
		button.setFont(new Font("Monaco", Font.PLAIN, 13));
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
			JFrame frame1 = new JFrame();
			if(arg0.getSource()==buttons.get(0))
			{
				frame1.setTitle("New Circle");
				currentSpriteIndex=0;
			}
			else if(arg0.getSource()==buttons.get(1))
			{	
				frame1.setTitle("New Rectange");
				currentSpriteIndex=1;
			}
			else if(arg0.getSource()==buttons.get(2))
			{	
				frame1.setTitle("New Image");
				currentSpriteIndex=2;
			}
			else if(arg0.getSource()==buttons.get(3))
			{
				frame1.setTitle("New Clock");
				currentSpriteIndex=3;
			}
			frame1.setSize(400,400);
			SpritePropertiesPanel spritePropertiesPanelObject=new SpritePropertiesPanel(this);
			spritePropertiesPanelObject.setSize(200,800);
			spritePropertiesPanelObject.setLocation(10,10);
			spritePropertiesPanelObject.setBackground(Color.decode("#ADD8E6"));
			frame1.add(spritePropertiesPanelObject);
			frame1.setVisible(true);
			spritePropertiesPanelObject.drawSpritePropertiesPanel();	
		}
		else if(arg0.getSource() == getButtons().get(4)) {
			JFrame nextFrame = new JFrame();
			JPanel nextPanel = new NextPanel(this);
			nextFrame.add(nextPanel);
			nextPanel.setSize(400, 400);
			nextFrame.setLocation(0, 0);
			nextFrame.setSize(400, 400);
			nextPanel.setBackground(Color.decode("#ADD8E6"));
			nextFrame.setVisible(true);
		}
		else if(arg0.getSource() == getButtons().get(5)) {
			
			path = System.getProperty(userDir);
			JFileChooser jfc = new JFileChooser(new File(path));
			jfc.setDialogTitle("Choose Background Theme");
			jfc.setMultiSelectionEnabled(true);
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				 File selectedFile = jfc.getSelectedFile();
				 this.selectedpath = selectedFile.getAbsolutePath();
				 levelObjects.get(currentLevel).setSelectedPath(this.selectedpath);
			}
		}
		else if(arg0.getSource() == getButtons().get(6))
		{
			allItems=new Composite();
			reactions=new ArrayList<Reaction>();
			selectedpath = null;
			levelObjects.add(new LevelObject(reactions, getAllItems(),selectedpath));
			currentLevel++;
			labels.get(0).setText("You are on level "+currentLevel);
		}
		else if(arg0.getSource() == getButtons().get(7)) {
			SaveObject saveobject = new SaveObject(levelObjects);
			WriteObjectToFile(saveobject);
		}
		else if(arg0.getSource() == getButtons().get(8)) {
			ReadObjectFromFile("test");
		}
		else if(arg0.getSource() == getButtons().get(9)) {
			String goToLevel = textboxes.get(0).getText().isEmpty()?"0":textboxes.get(0).getText();
			currentLevel=Integer.parseInt(goToLevel);
			labels.get(0).setText("You are on level "+currentLevel);
		}
	}
	
	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}

	public String getSelectedpath() {
		return selectedpath;
	}
	
	
	public List<Movement> getManualMovements() {
		return manualMovements;
	}

	public ArrayList<JButton> getButtons() {
		return buttons;
	}
	
	public void WriteObjectToFile(Object serObj) {
		path = System.getProperty(userDir);
        try(FileOutputStream fileOut = new FileOutputStream(path+"/test"); ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
        	objectOut.writeObject(serObj);
            objectOut.close();
            fileOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
	
	public void ReadObjectFromFile(String filename) {
		path = System.getProperty(userDir);
		try(FileInputStream fi = new FileInputStream(new File(path+"/test")); ObjectInputStream oi =new ObjectInputStream(fi); ) {
			SaveObject so = (SaveObject)oi.readObject();
			this.levelObjects = so.getLevelObjects();
		} catch (FileNotFoundException e) {
			System.out.println("File Not found"+e.getMessage());
		}
		 catch (IOException e) {
			 System.out.println("IO Exception"+e.getMessage());
		}
		catch (ClassNotFoundException e) {
			System.out.println("Class not found"+e.getMessage());
		}
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