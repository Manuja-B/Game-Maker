package com.oosd.gamemaker;

import java.io.Serializable;
import java.util.ArrayList;

import com.oosd.gamemaker.behavior.Reaction;
import com.oosd.gamemaker.models.Composite;

public class LevelObject implements Serializable {
	static int level=0;
	String selectedPath;
	
	
	public LevelObject(ArrayList<Reaction> reactions, Composite allSprites, String selectedPath) {
		super();
		this.reactions = reactions;
		this.allSprites = allSprites;
		this.selectedPath = selectedPath;
	}
	ArrayList<Reaction> reactions = new ArrayList<Reaction>();
	Composite allSprites;
	
	public ArrayList<Reaction> getReactions() {
		return reactions;
	}
	public void addReaction(Reaction reaction) {
		this.reactions.add(reaction);
	}
	
	public Composite getSprites() {
		return allSprites;
	}
	
	public String getSelectedPath() {
		return selectedPath;
	}

	public void setSelectedPath(String selectedPath) {
		this.selectedPath = selectedPath;
	}

	
}
