package com.oosd.gamemaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.behavior.Reaction;

public class PanelMaker extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3231287640255472209L;
	protected ArrayList<String> keys = new ArrayList<String>() ;
	protected ArrayList<Movement> manualMovements = new ArrayList<Movement>() ;
	protected ArrayList<JTextField> textboxes = new ArrayList<JTextField>() ;
	protected ArrayList<JComboBox<ComboItem>> comboBoxes = new ArrayList<JComboBox<ComboItem>>() ;
	protected ArrayList<JButton> buttons = new ArrayList<JButton>();
	protected ArrayList<Reaction> reactions = new ArrayList<Reaction>();
	protected ArrayList<JLabel> labels=new ArrayList<JLabel>();
	protected ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();
	
	public void addLabel(String message, int x, int y, JPanel panel) {
		JLabel label = new JLabel(message);
		label.setBounds(x, y, 200, 20);
		panel.add(label);
		labels.add(label);
	}
	
	
	public void addTextBox(int x, int y, JPanel panel) {
		JTextField  textbox = new JTextField();
		textbox.setBounds(x,y,50,20);
		
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
	public void addCheckBox(String label, int x, int y, JPanel panel) {
		JCheckBox checkbox = new JCheckBox(label);
		checkbox.setBounds(x,y,150,40);
		checkBoxes.add(checkbox);
		panel.add(checkbox);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
