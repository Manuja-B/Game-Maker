package com.oosd.gamemaker;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2701683955089965424L;
	ArrayList<LevelObject> levelObjects = new ArrayList<LevelObject>();
	
	public ArrayList<LevelObject> getLevelObjects() {
		return levelObjects;
	}

	public SaveObject(ArrayList<LevelObject> levelObjects) {
		super();
		this.levelObjects = levelObjects;
	}

}
