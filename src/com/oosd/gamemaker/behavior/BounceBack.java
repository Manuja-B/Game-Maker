package com.oosd.gamemaker.behavior;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import com.oosd.gamemaker.models.Sprite;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class BounceBack implements Reaction {

	Sprite primary;
	Sprite secondary;
	
	
	
	public BounceBack(Sprite primary, Sprite secondary) {
		super();
		this.primary = primary;
		this.secondary = secondary;
	}
	@Override
	public boolean react() {
		// TODO Auto-generated method stub
		//System.out.println("yo");
		int primaryXmin = primary.getX();
		int primaryYmin = primary.getY();
		int secondaryXmin = secondary.getX();
		int secondaryYmin = secondary.getY();
		int primaryYmax = primaryYmin + primary.getHeight();
		int primaryXmax = primaryXmin + primary.getWidth();
		int secondaryXmax = secondaryXmin + primary.getWidth();
		int secondaryYmax = secondaryYmin + primary.getHeight();
		
//		InputStream music = null;
//		try {
//			music = new FileInputStream(new File("/Users/juhi/Desktop/OOSD/Ball_Bounce.wav"));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		AudioStream audio = null;
//		try {
//			audio = new AudioStream(music);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		if((primaryYmin - secondary.getHeight())<= secondaryYmin 
				&& secondaryYmin <= primaryYmax 
				&& secondaryXmin >= (primaryXmin - secondary.getWidth())
				&& secondaryXmin <= primaryXmax)
		{

			int secondaryXCenter = secondary.getX() + secondary.getWidth()/2;
			int secondaryYCenter = secondary.getY() + secondary.getHeight()/2;
			if(primaryYmin <= secondaryYCenter && secondaryYCenter <= primaryYmax ) {
				secondary.setDx(-secondary.getDx());
				//AudioPlayer.player.start(audio);
			}
			else {
				secondary.setDy(-(secondary.getDy()));
				//AudioPlayer.player.start(audio);
			}
			//System.out.println("yo");
			return true;
		}
		
		return false;
	}

}
