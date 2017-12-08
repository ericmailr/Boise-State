import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * Creates 3 song objects created from user input and displays song info in a
 * playlist Also plays snippet from each song.
 * 
 * @author Eric
 *
 */
public class PlayList {

	public static void main(String[] args) throws InterruptedException {

		Scanner scan = new Scanner(System.in);

		String title, artist, fileName;
		int playTime;

		System.out.println();

		System.out.print("Enter the song title: ");
		title = scan.nextLine();

		System.out.print("Enter the song artist: ");
		artist = scan.nextLine();

		System.out.print("Enter the song length (mm:ss): ");
		String timeString = scan.nextLine();
		int colonIndex = timeString.indexOf(':');

		playTime = Integer.parseInt(timeString.substring(0, colonIndex)) * 60
				+ Integer.parseInt(timeString.substring(colonIndex + 1));

		System.out.print("Enter the file name: ");
		fileName = scan.nextLine();

		Song song1 = new Song(title, artist, playTime, fileName);

		// ---------------------------------------------------------------------------------------------------------------------------------
		System.out.print("\nEnter the song title: ");
		title = scan.nextLine();

		System.out.print("Enter the song artist: ");
		artist = scan.nextLine();

		System.out.print("Enter the song length (mm:ss): ");
		timeString = scan.nextLine();
		colonIndex = timeString.indexOf(':');

		playTime = Integer.parseInt(timeString.substring(0, colonIndex)) * 60
				+ Integer.parseInt(timeString.substring(colonIndex + 1));

		System.out.print("Enter the file name: ");
		fileName = scan.nextLine();

		Song song2 = new Song(title, artist, playTime, fileName);

		// -------------------------------------------------------------------------------------------------------------------------------
		System.out.print("\nEnter the song title: ");
		title = scan.nextLine();

		System.out.print("Enter the song artist: ");
		artist = scan.nextLine();

		System.out.print("Enter the song length (mm:ss): ");
		timeString = scan.nextLine();
		colonIndex = timeString.indexOf(':');

		playTime = Integer.parseInt(timeString.substring(0, colonIndex)) * 60
				+ Integer.parseInt(timeString.substring(colonIndex + 1));

		System.out.print("Enter the file name: ");
		fileName = scan.nextLine();

		Song song3 = new Song(title, artist, playTime, fileName);

		// ----------------------------------------------------------------------------------------------------------------------------------
		DecimalFormat timeFormat = new DecimalFormat("0.00");

		double averagePlayTime = (double) (song1.getPlayTime()
				+ song2.getPlayTime() + song3.getPlayTime()) / 3;

		System.out.println("\n\nAverage play Time: "
				+ timeFormat.format(averagePlayTime) + " seconds");

		int playTimeOfInterest = 240;

		int song1TimeDiff = Math.abs(song1.getPlayTime() - playTimeOfInterest);
		int song2TimeDiff = Math.abs(song2.getPlayTime() - playTimeOfInterest);
		int song3TimeDiff = Math.abs(song3.getPlayTime() - playTimeOfInterest);

		int leastTimeDiff = Math.min(song1TimeDiff,
				Math.min(song2TimeDiff, song3TimeDiff));

		System.out.print("Song(s) with playtime closest to 240 secs:");

		if (leastTimeDiff == song1TimeDiff) {

			System.out.print(" \"" + song1.getTitle() + "\"");
		}

		if (leastTimeDiff == song2TimeDiff) {
			System.out.print(" \"" + song2.getTitle() + "\"");
		}

		if (leastTimeDiff == song3TimeDiff) {
			System.out.print(" \"" + song3.getTitle() + "\"");
		}
		System.out.println();

		System.out
				.println("==============================================================================");
		System.out.printf("%-20s %-20s %-25s %10s", "Title", "Artist",
				"Filename", "Playtime");
		System.out
				.println("\n==============================================================================");

		if (song1.getPlayTime() <= song2.getPlayTime()
				&& song1.getPlayTime() <= song3.getPlayTime()) {
			System.out.println(song1.toString());

			if (song2.getPlayTime() <= song3.getPlayTime()) {

				System.out.println(song2.toString());

				System.out.println(song3.toString());

				System.out
						.println("\n==============================================================================");

				System.out.println();

				song1.play();
				song2.play();
				song3.play();
			} else {
				System.out.println(song3.toString());

				System.out.println(song2.toString());

				System.out
						.println("\n==============================================================================");

				System.out.println();

				song1.play();
				song3.play();
				song2.play();
			}
		}

		if (song2.getPlayTime() < song1.getPlayTime()
				&& song2.getPlayTime() <= song3.getPlayTime()) {
			System.out.println(song2.toString());

			if (song1.getPlayTime() <= song3.getPlayTime()) {

				System.out.println(song1.toString());

				System.out.println(song3.toString());

				System.out
						.println("\n==============================================================================");

				System.out.println();

				song2.play();
				song1.play();
				song3.play();
			} else {
				System.out.println(song3.toString());

				System.out.println(song1.toString());

				System.out
						.println("\n==============================================================================");

				System.out.println();

				song2.play();
				song3.play();
				song1.play();
			}
		}

		if (song3.getPlayTime() < song1.getPlayTime()
				&& song3.getPlayTime() <= song2.getPlayTime()) {
			System.out.println(song3.toString());

			if (song1.getPlayTime() <= song2.getPlayTime()) {

				System.out.println(song1.toString());

				System.out.println(song2.toString());

				System.out
						.println("\n==============================================================================");

				System.out.println();

				song3.play();
				song1.play();
				song2.play();
			} else {
				System.out.println(song2.toString());

				System.out.println(song1.toString());

				System.out
						.println("\n==============================================================================");

				System.out.println();

				song3.play();
				song2.play();
				song1.play();

			}
		}
		scan.close();

	}
}
