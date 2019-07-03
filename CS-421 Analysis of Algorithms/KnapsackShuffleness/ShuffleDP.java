/**
 * 
 * @author eric miller
 *
 */
public class ShuffleDP {

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
		boolean[][] table = s.fillTable();
		System.out.print("    ");
		for (int i = 0; i <= y.length(); i++) {
			System.out.print(i + "   ");
		}
		System.out.println();
		for (int i = 0; i <= x.length(); i++) {
			System.out.print(i + "  ");
			for (int j = 0; j <= y.length(); j++) {
				if (table[i][j]) {
					System.out.print("yes ");
				} else {
					System.out.print("no  ");
				}
			}
			System.out.println();
		}
		System.out.print("Solution: ");
		if (table[x.length()][y.length()]) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
		System.out.println("Table References: " + s.getRefCount());
	}

	public static class Shuffle {
		private String x, y, z;
		private int refCount;
		private boolean[][] table;

		public Shuffle(String x, String y, String z) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.table = new boolean[x.length() + 1][y.length() + 1];
			this.refCount = 0;
		}

		public boolean b(char c1, char c2) {
			return c1 == c2;
		}

		public boolean[][] fillTable() {
			for (int i = 0; i <= this.x.length(); i++) {
				for (int j = 0; j <= this.y.length(); j++) {
					if (i == 0 && j == 0) {
						this.table[i][j] = true;
					}
					if (i == 0 && j > 0) {
						this.table[i][j] = this.table[0][j - 1] && b(this.y.charAt(j - 1), this.z.charAt(j - 1));
						refCount++;
					}
					if (i > 0 && j == 0) {
						this.table[i][j] = this.table[i - 1][0] && b(this.x.charAt(i - 1), this.z.charAt(i - 1));
						refCount++;
					}
					if (i > 0 && j > 0) {
						if (this.table[i][j - 1] && b(this.y.charAt(j - 1), this.z.charAt(i + j - 1))) {
							// refCount++;
							this.table[i][j] = true;
						} else if (this.table[i - 1][j] && b(this.x.charAt(i - 1), this.z.charAt(i + j - 1))) {
							refCount += 1;
							this.table[i][j] = true;
						} else {
							refCount += 1;
						}
					}
				}
			}
			return this.table;
		}

		public int getRefCount() {
			return this.refCount;
		}
	}
}
