package com.oosd.gamemaker.layouts;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class BorderLayoutClass extends JPanel implements ControllerLayout {
	int count;
	//JPanel buttonsPanel;

	public BorderLayoutClass() {
		this.setLayout(null);
		//this.buttonsPanel = buttonsPanel;
		BorderLayout border = new BorderLayout();
		this.count = 0;
		this.setLayout(border);

	}

	public void addComponentToLayout(JComponent component) {
		if (count >= 5) {
			return;
		}

		if (count == 0) {
			this.add(component, BorderLayout.PAGE_START);
		} else if (count == 1) {
			this.add(component, BorderLayout.LINE_END);
		} else if (count == 2) {
			this.add(component, BorderLayout.PAGE_END);
		} else if (count == 3) {
			this.add(component, BorderLayout.LINE_START);
		} else if (count == 4) {
			this.add(component, BorderLayout.CENTER);
		}
		count++;
	}

}