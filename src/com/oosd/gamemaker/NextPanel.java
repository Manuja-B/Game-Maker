package com.oosd.gamemaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import com.oosd.gamemaker.ComboItem;
import com.oosd.gamemaker.behavior.BounceBack;
import com.oosd.gamemaker.behavior.Explode;
import com.oosd.gamemaker.models.Composite;

public class NextPanel extends JPanel implements ActionListener{
	ArrayList<JComboBox<ComboItem>> comboBoxes = new ArrayList<JComboBox<ComboItem>>() ;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	Maker maker;
	
	public NextPanel(Maker maker) {
		// TODO Auto-generated constructor stubs
		int spriteCount = maker.getAllItems().getAllSprites().size();
		ComboItem[] sprites = new ComboItem[spriteCount];
		for(int i = 0; i < spriteCount; i++) {
			sprites[i] = new ComboItem(maker.getAllItems().getAllSprites().get(i).getName(),i);
		}
		addCombobox(new ComboItem[] { new ComboItem("Bounce Back", 0) , new ComboItem("Explode", 1)} , 10, 10, this);
		addCombobox(sprites, 30, 10, this);
		addCombobox(sprites, 50, 10, this);
		
		addButtonToPanel("Add Reaction", 30, 30, this);
		this.maker=maker;
	}
	
	public void addCombobox(ComboItem items[], int x, int y, JPanel panel) {
		JComboBox<ComboItem> combo = new JComboBox<ComboItem>(items);
		combo.setBounds(x, y, 100, 20);
		combo.setMaximumSize(combo.getPreferredSize());
		comboBoxes.add(combo);
		panel.add(combo);
	}
	public void addButtonToPanel(String name, int x, int y, JPanel panel) {
		JButton button = new JButton(name);
		button.addActionListener(this);
		button.setVisible(true);
		button.setBounds(x, y, 200, 20);
		panel.add(button);
		buttons.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object reactionItem = comboBoxes.get(0).getSelectedItem();
		int reactionCode = ((ComboItem)reactionItem).getValue();
		Object spriteItem1 = comboBoxes.get(1).getSelectedItem();
		int spriteCode1 = ((ComboItem)spriteItem1).getValue();
		Object spriteItem2 = comboBoxes.get(2).getSelectedItem();
		int spriteCode2 = ((ComboItem)spriteItem2).getValue();
		if(reactionCode == 0) {
			
			maker.addReaction((new BounceBack(maker.getAllItems().getAllSprites().get(spriteCode1), maker.getAllItems().getAllSprites().get(spriteCode2))));
		}
		else if(reactionCode == 1) {
			
			maker.addReaction((new Explode(maker.getAllItems().getAllSprites().get(spriteCode1), maker.getAllItems().getAllSprites().get(spriteCode2))));
		}
		
	}
}
