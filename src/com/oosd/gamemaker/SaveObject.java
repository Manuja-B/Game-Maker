package com.oosd.gamemaker;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SaveObject implements Serializable {
	private static final long serialVersionUID = -2701683955089965424L;
	List<LevelObject> levelObjects = new ArrayList<LevelObject>();
	
	public SaveObject(List<LevelObject> levelObjects2) {
		super();
		this.levelObjects = levelObjects2;
	}
	
	public List<LevelObject> getLevelObjects() {
		return levelObjects;
	}
	
	public void setLevelObjects(List<LevelObject> levelObjects) {
		this.levelObjects = levelObjects;
	}
}
