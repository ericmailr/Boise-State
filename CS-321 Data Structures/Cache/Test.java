import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Tester for Cache class. Counts cache hits/misses and calculates hit ratios.
 * 
 * @author eric miller
 *
 */
public class Test {

	public static void main(String[] args) {

		int numCaches = 0, sizeCache1 = 0, sizeCache2 = 0, nH = 0, nH1 = 0, nH2 = 0, nR = 0, nR2 = 0;
		String fileName = null;
		StringTokenizer toke;
		boolean twoLevel = false;

		// Check for correct arguments
		if (args.length > 0 && args.length < 5) {
			try {
				numCaches = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument \"" + args[0] + "\" must be a 1 or a 2.");
				System.exit(1);
			}
			if (numCaches == 1 && args.length == 3) {
				try {
					sizeCache1 = Integer.parseInt(args[1]);
				} catch (NumberFormatException e) {
					System.err.println("Argument \"" + args[1] + "\" must be an integer indicating cache size.");
					System.exit(1);
				}
				fileName = args[2];
			} else if (numCaches == 2 && args.length == 4) {
				try {
					twoLevel = true;
					sizeCache1 = Integer.parseInt(args[1]);
					sizeCache2 = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					System.err.println("Arguments \"" + args[1] + "\" and \"" + args[2]
							+ "\" must be integers describing cache sizes.");
					System.exit(1);
				}
				fileName = args[3];
			} else {
				System.err.println(
						"Usage:\njava Test 1 <cache size> <input textfile name> OR\njava Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>");
				System.exit(1);
			}

		} else {
			System.err.println(
					"Usage:\njava Test 1 <cache size> <input textfile name> OR\njava Test 2 <1st-level cache size> <2nd-level cache size> <input textfile name>");
			System.exit(1);
		}

		Cache<String> cache1 = new Cache<String>(sizeCache1);
		Cache<String> cache2 = new Cache<String>(sizeCache2);
		// read file, check cache for words, keep track of hits/misses
		try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
			String line;
			String currentToken;
			while ((line = buff.readLine()) != null) {
				toke = new StringTokenizer(line, " \t");
				while (toke.hasMoreTokens()) {
					nR++;
					currentToken = toke.nextToken();
					if (!cache1.getCache().contains(currentToken)) {

						cache1.addObject(currentToken);

						if (twoLevel) {
							nR2++;
							if (!cache2.getCache().contains(currentToken)) {
								cache2.addObject(currentToken);
							} else {
								nH2++;
								nH++;
								cache2.removeObject(currentToken);
								cache2.addObject(currentToken);
							}
						}
					} else {
						cache1.removeObject(currentToken);
						cache1.addObject(currentToken);
						nH++;
						nH1++;
						if (twoLevel) {
							cache2.removeObject(currentToken);
							cache2.addObject(currentToken);
						}

					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// print results
		System.out.println("Total number of references: " + nR);
		System.out.println("Total number of cache hits: " + nH);
		if (!twoLevel) {
			System.out.println("The global hit ratio: " + (double) nH / nR);
		} else {
			System.out.println("The global hit ratio: " + (double) (nH1 + nH2) / nR);
		}
		System.out.println("Number of 1st-level cache hits: " + nH1);
		System.out.println("1st-level cache hit ratio: " + (double) nH1 / nR);
		System.out.println("Number of 2nd-level cache hits: " + nH2);
		System.out.println("2nd-level cache hit ratio: " + (double) nH2 / nR2);

	}

}
