package com.oosd.gamemaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import com.oosd.gamemaker.ComboItem;
import com.oosd.gamemaker.behavior.BounceBack;
import com.oosd.gamemaker.behavior.ChangeDirection;
import com.oosd.gamemaker.behavior.Explode;
import com.oosd.gamemaker.behavior.Sound;

import sun.audio.AudioStream;

public class NextPanel extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6529035796591203451L;
	ArrayList<JComboBox<ComboItem>> comboBoxes = new ArrayList<JComboBox<ComboItem>>() ;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	Maker maker;
	Sound sound;
	String audiopath;
	AudioStream audio = null;
	
	public NextPanel(Maker maker) {
		int spriteCount = maker.getAllItems().getAllSprites().size();
		ComboItem[] sprites = new ComboItem[spriteCount];
		for(int i = 0; i < spriteCount; i++) {
			sprites[i] = new ComboItem(maker.getAllItems().getAllSprites().get(i).getName(),i);
		}
		addCombobox(new ComboItem[] { new ComboItem("Bounce Back", 0) , new ComboItem("Explode", 1), new ComboItem("Change Direction", 2)} , 10, 10, this);
		addCombobox(sprites, 30, 10, this);
		addCombobox(sprites, 50, 10, this);
		
		addButtonToPanel("Add Sound", 50, 120, this);
		addButtonToPanel("Add Reaction", 60, 30, this);
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
		if(e.getSource()==buttons.get(1))
		{
			Object reactionItem = comboBoxes.get(0).getSelectedItem();
			int reactionCode = ((ComboItem)reactionItem).getValue();
			Object spriteItem1 = comboBoxes.get(1).getSelectedItem();
			int spriteCode1 = ((ComboItem)spriteItem1).getValue();
			Object spriteItem2 = comboBoxes.get(2).getSelectedItem();
			int spriteCode2 = ((ComboItem)spriteItem2).getValue();
			if(reactionCode == 0) {
			
				maker.addReaction((new BounceBack(maker.getAllItems().getAllSprites().get(spriteCode1), maker.getAllItems().getAllSprites().get(spriteCode2), sound)));
			}
			else if(reactionCode == 1) {
			
				maker.addReaction((new Explode(maker.getAllItems().getAllSprites().get(spriteCode1), maker.getAllItems().getAllSprites().get(spriteCode2), sound)));
			}else if(reactionCode == 2) {
				maker.addReaction(new ChangeDirection(maker.getAllItems().getAllSprites().get(spriteCode1), maker.getAllItems().getAllSprites().get(spriteCode2), sound));
			}
		}
		
		else if(e.getSource()==buttons.get(0))
		{
			String path = "Music";
			JFileChooser jfc = new JFileChooser(new File(path));
			jfc.setDialogTitle("Choose Background Sound");
			jfc.setMultiSelectionEnabled(true);
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int returnValue = jfc.showOpenDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				 File selectedFile = jfc.getSelectedFile();
				 this.audiopath = selectedFile.getAbsolutePath();
				 sound = new Sound(audiopath);
			}
		}
	}

	public String getAudiopath() {
		return audiopath;
	}
		
}
