package com.oosd.gamemaker.behavior;
import com.oosd.gamemaker.Playground;
import com.oosd.gamemaker.models.Sprite;

public interface BoundaryBehavior {
	public abstract void reactWithBoundary(Sprite sprite, Playground playground);

}

