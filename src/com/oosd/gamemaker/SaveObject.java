package com.oosd.gamemaker;

import java.io.Serializable;
import java.util.ArrayList;

import com.oosd.gamemaker.behavior.Reaction;
import com.oosd.gamemaker.models.Composite;

public class SaveObject implements Serializable {
	public SaveObject(ArrayList<Reaction> reactions, Composite allSprites) {
		super();
		this.reactions = reactions;
		this.allSprites = allSprites;
	}
	ArrayList<Reaction> reactions = new ArrayList<Reaction>();
	Composite allSprites;
	
	public ArrayList<Reaction> getReactions() {
		return reactions;
	}
	
	public Composite getAllSprites() {
		return allSprites;
	}
	
}
