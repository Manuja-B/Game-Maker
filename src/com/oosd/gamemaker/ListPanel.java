package com.oosd.gamemaker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.oosd.gamemaker.behavior.Movement;
import com.oosd.gamemaker.models.Composite;
import com.oosd.gamemaker.models.Sprite;

public class ListPanel extends JPanel implements ActionListener {
	//int pageSize;
	JButton buttonDelete;
	JButton buttonEdit;
	public ListPanel(Composite allSprites) {
		//this.setLayout(null);
		//this.pageSize = pageSize;
		
		List<Sprite> sprites = allSprites.getAllSprites();
		int count = sprites.size();
		//To Implement 3 jlists. one for all sprite names, another with edit and another with delete
		//Sprite value;
		String arraySprites[] = new String[count];
		for(int i = 0; i < count ; i++ ) {
			arraySprites[i] = sprites.get(i).getName();
			//System.out.println(arraySprites[i]);
		}
		JList<String> listSprite = new JList<String>(arraySprites);
		//listSprite.getSize();
		buttonDelete = new JButton("Delete");
		buttonEdit = new JButton("Edit");
		this.add(buttonDelete);
		this.add(buttonEdit);
		this.add(new JScrollPane(listSprite));
		
		
	}
	public ListPanel(ArrayList<Movement> movements) {
		//this.pageSize = pageSize;
		this.setLayout(null);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}

class ListItem
{
    private String label;
    private Object value;

    public ListItem(String label, Object value)
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


    public Object getValue()
    {
        return value;
    }
}