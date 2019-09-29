package com.oosd.gamemaker.behavior;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import javax.swing.JFileChooser;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
public class Sound {
	String audiopath;
	AudioStream audio;
	InputStream music;
	
	public Sound(String audiopath)
	{
		this.audiopath = audiopath;
		//System.out.println("Inside sound constructer : "+this.audiopath);
	}
	
	public void playSound()
	{
			//System.out.println("Inside Sound if : "+audiopath);
			try {
				music = new FileInputStream(new File(audiopath));
				audio = new AudioStream(music);
				//System.out.println("below AudioStream(music)");
				AudioPlayer.player.start(audio);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		
	}
}
