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
		System.out.println("Inside sound constructer : "+this.audiopath);
	}
	
	public void playSound()
	{
			System.out.println("Inside Sound if : "+audiopath);
			try {
				music = new FileInputStream(new File(audiopath));
			//AudioStream audio = null;
				audio = new AudioStream(music);
				System.out.println("below AudioStream(music)");
				AudioPlayer.player.start(audio);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			
		
//		String path = "C:\\Users\\Maruti\\OneDrive\\Pictures\\Saved Pictures";
//		JFileChooser jfc = new JFileChooser(new File(path));
////		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
//		
//		jfc.setDialogTitle("Choose Background Sound");
//		jfc.setMultiSelectionEnabled(true);
//		jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
//		int returnValue = jfc.showOpenDialog(null);
//		if (returnValue == JFileChooser.APPROVE_OPTION) {
//			File[] files = jfc.getSelectedFiles();
//			 File selectedFile = jfc.getSelectedFile();
//			 this.audiopath = selectedFile.getAbsolutePath();
//			 System.out.println("Music selected is : "+audiopath);
//			 
//			Arrays.asList(files).forEach(x -> {
//				if (x.isFile()) {
//					System.out.println(x.getName());
//				}
//			});
//		}
		
	}

}
