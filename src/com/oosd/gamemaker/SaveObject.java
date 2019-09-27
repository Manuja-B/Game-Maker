package com.oosd.gamemaker;

import java.io.Serializable;
import java.util.ArrayList;

public class SaveObject implements Serializable {
	ArrayList<LevelObject> lo = new ArrayList<LevelObject>();
	
	public SaveObject(ArrayList<LevelObject> lo) {
		super();
		this.lo = lo;
	}

	
	

}
