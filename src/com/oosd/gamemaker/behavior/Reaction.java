package com.oosd.gamemaker.behavior;

import com.oosd.gamemaker.models.Sprite;

public interface Reaction {
	boolean react(Sprite primary, Sprite secondary);
}
