package main;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {
	Clip clip;
	URL soundURL[] = new URL[30];
	
	public Sound() {
		soundURL[0] = getClass().getResource("/sound/HauntedForest.wav");
		soundURL[1] = getClass().getResource("/sound/Door.wav");
		soundURL[2] = getClass().getResource("/sound/creepyMusic.wav");
		soundURL[3] = getClass().getResource("/sound/knock.wav");
		soundURL[4] = getClass().getResource("/sound/whisper.wav");
		soundURL[5] = getClass().getResource("/sound/Runaway.wav");
		soundURL[6] = getClass().getResource("/sound/laugh.wav");
		soundURL[7] = getClass().getResource("/sound/goat.wav");
		soundURL[8] = getClass().getResource("/sound/noise.wav");
		
	}
	
	public void setFile(int i) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			
		}
	}
	
	public void play() {
		clip.start();
	}
	
	public void loop() {
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		clip.stop();
	}
}
