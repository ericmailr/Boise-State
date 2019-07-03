/**
 * 
 * @author eric miller
 *
 */
public class ShuffleRec {
	public static void printUsage() {
		System.out.println(
				"Program requires 3 string arguments X Y Z, where the length of Z is the sum of the lengths of X and Y");
	}

	public static void main(String[] args) {
		String x = "";
		String y = "";
		String z = "";

		if (args.length != 3) {
			printUsage();
			System.exit(1);
		}
		try {
			x = args[0];
			y = args[1];
			z = args[2];
		} catch (NumberFormatException e) {
			printUsage();
			System.exit(1);
		}
		if (x.length() + y.length() != z.length()) {
			printUsage();
			System.exit(1);
		}

		Shuffle s = new Shuffle(x, y, z);
		if (s.t(x.length() - 1, y.length() - 1)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		System.out.println("Recursive Calls: " + s.getRecCount());
	}

	public static class Shuffle {
		private String x, y, z;
		private int recCount;

		public Shuffle(String x, String y, String z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.recCount = 0;
		}

		public boolean t(int i, int j) {
			this.recCount++;
			if (i == -1 && j == -1) {
				return true;
			}
			if (i == -1 && j > -1) {
				return t(-1, j - 1) && b(y.charAt(j), z.charAt(j));
			}
			if (i > -1 && j == -1) {
				return t(i - 1, -1) && b(x.charAt(i), z.charAt(i));
			}
			if (i > -1 && j > -1) {
				return (t(i, j - 1) && b(y.charAt(j), z.charAt(i + j + 1)))
						|| (t(i - 1, j) && b(x.charAt(i), z.charAt(i + j + 1)));
			}
			System.out.println("Error");
			return false;
		}

		public boolean b(char c1, char c2) {
			return c1 == c2;
		}

		public int getRecCount() {
			return this.recCount;
		}
	}
}
