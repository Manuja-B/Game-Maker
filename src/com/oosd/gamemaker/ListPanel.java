package com.oosd.gamemaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.models.Composite;

public class ListPanel extends JPanel implements ActionListener {
	int pageSize;
	public ListPanel(Composite allSprites, int pageSize) {
		this.setLayout(null);
		this.pageSize = pageSize;
		int count = allSprites.getAllSprites().size();
		//To Implement 3 jlists. one for all sprite names, another with edit and another with delete
		
	}
	public ListPanel(ArrayList<Movement> movements, int pageSize) {
		this.pageSize = pageSize;
		this.setLayout(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
