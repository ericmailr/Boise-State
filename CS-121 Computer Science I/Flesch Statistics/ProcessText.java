import java.io.File;

public class ProcessText {

	public static void main(String args[]) {

		String filename;
		if (args.length == 0) {
			System.err
					.println("ProcessText Usage: java ProcessText file1 [file2 ...]");
			System.exit(1);
		}

		for (int i = 0; i < args.length; i++) {

			filename = args[i];
			File file = new File(filename);
			if (file.exists() && file.canRead()) {

				FleschStatistics stats = new FleschStatistics(file);
				System.out.println(stats);

			} else {
				System.err.println("Invalid filename: " + args[i] + ".");

			}

		}

	}
}