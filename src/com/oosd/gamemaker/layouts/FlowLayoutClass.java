package com.oosd.gamemaker.layouts;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class FlowLayoutClass extends JPanel implements ControllerLayout {

	public FlowLayoutClass() {
		this.setLayout(null);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.setLayout(new FlowLayout());
	}

	@Override
	public void addComponentToLayout(JComponent component) {
		this.add(component);

	}

}