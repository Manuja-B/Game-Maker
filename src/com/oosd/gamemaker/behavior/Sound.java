package com.oosd.gamemaker.behavior;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class Sound {
	String audiopath;
	AudioStream audio;
	InputStream music;
	
	public Sound(String audiopath)
	{
		this.audiopath = audiopath;
	}
	
	public void playSound()
	{
			try {
				music = new FileInputStream(new File(audiopath));
				audio = new AudioStream(music);
				AudioPlayer.player.start(audio);
			} catch (IOException e) {
				System.out.println("Error playing sound"+e.getMessage());
			}		
		
	}
}
