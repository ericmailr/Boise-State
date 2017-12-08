import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Represents information about a song.
 * 
 * @author amit
 *
 */
public class Song {
	private String title;
	private String artist;
	private int playTime; // in seconds
	private String fileName;

	/**
	 * Constructor: build a song using the given parameters.
	 * 
	 * @param title
	 *            song's title
	 * @param artist
	 *            song's artist
	 * @param playTime
	 *            song's length in seconds
	 * @param fileName
	 *            song file to load
	 */
	public Song(String title, String artist, int playTime, String fileName) {
		this.title = title;
		this.artist = artist;
		this.playTime = playTime;
		this.fileName = fileName;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @return the playTime
	 */
	public int getPlayTime() {
		return playTime;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%-20s %-20s %-25s %10s", title, artist, fileName,
				playTime);
	}

	/**
	 * 
	 * @throws InterruptedException
	 */
	public void play() throws InterruptedException {

		try {
			File soundFile = new File(fileName).getAbsoluteFile();
			AudioInputStream audioInputStream = AudioSystem
					.getAudioInputStream(soundFile);
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();

		} catch (Exception e) {
			System.out.println("PlayMusic: Error with playing sound:" + e);
			e.printStackTrace();
		}

		// there are better ways of waiting for a song to finish playing
		// but we will see them later
		int playTime = 30; // seconds
		for (int i = 0; i < playTime * 10; i++) {
			Thread.sleep(100); // in millisecs
			System.out.print(String.format("%-20s %-20s %-25s %10s", title,
					artist, fileName, playTime) + ":   " + i / 10.0 + "\r");
		}

	}
}
