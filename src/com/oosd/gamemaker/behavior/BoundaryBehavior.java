package com.oosd.gamemaker.behavior;
import java.io.Serializable;

import com.oosd.gamemaker.models.Sprite;
import com.oosd.gamemaker.panels.Playground;

public interface BoundaryBehavior extends Serializable {
	public abstract void reactWithBoundary(Sprite sprite, Playground playground);
}

