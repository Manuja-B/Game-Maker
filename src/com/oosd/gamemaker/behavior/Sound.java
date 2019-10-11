package com.oosd.gamemaker.behavior;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Sound {
	
	static final Logger logger = Logger.getLogger(Sound.class);
	private String audiopath;
	private AudioStream audio;
	private InputStream music;
	
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
				logger.debug("Exception occured while playing sound: " + e.getMessage());
			}		
		
	}
}
