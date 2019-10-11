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
<<<<<<< HEAD
	
	public void setLevelObjects(List<LevelObject> levelObjects) {
		this.levelObjects = levelObjects;
	}
=======
>>>>>>> 7265382676d2a4490d74437e4a42294bc4a498e3
}
