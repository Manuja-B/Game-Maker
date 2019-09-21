package com.oosd.gamemaker.layouts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.oosd.gamemaker.commmands.Command;
import com.oosd.gamemaker.models.Composite;


public class ButtonContainer extends JPanel implements ActionListener {
	//Manager atariManager = new AtariManager();
	ControllerLayout layout;
	ArrayList<JButton> buttons = new ArrayList<JButton>();
	ArrayList<Command> commands = new ArrayList<Command>();
	Composite allSprites;

	public ButtonContainer(Composite allSprites, ControllerLayout layout) {
		this.layout = layout;
		this.allSprites = allSprites;
	}

	public void addButton(String name, Command command, ControllerLayout layout) {
		JButton jbutton = new JButton(name);
		//jbutton.setFocusable(false);
		jbutton.addActionListener(this);
		buttons.add(jbutton);
		commands.add(command);
		layout.addComponentToLayout(jbutton);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (int i = 0; i < buttons.size(); i++) {
			System.out.println(i);
			if (arg0.getSource() == buttons.get(i)) {
				allSprites.notifyComponents(commands.get(i));
			}
		}

	}

}