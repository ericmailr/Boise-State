import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.StringTokenizer;

public class HashTest {

	public static void main(String[] args) throws FileNotFoundException {
		int probeCount = 0;
		final int rangeLow = 95500, rangeHigh = 96000;
		Random rand = new Random();
		int inputType = 0, debugLevel = 0;
		double loadFactor = 0;
		int[] probeCountArrayL, probeCountArrayH;

		// Check for correct arguments
		if (args.length >= 2 && args.length < 4) {
			try {
				inputType = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument \"" + args[0] + "\" must be a 1, 2, or 3.");
				System.exit(1);
			}
			try {
				loadFactor = Double.parseDouble(args[1]);
			} catch (NumberFormatException e) {
				System.err.println("Argument \"" + args[1] + "\" must be the load factor (1 >= number >= 0).");
				System.exit(1);
			}
			if (args.length == 3) {
				try {
					debugLevel = Integer.parseInt(args[2]);
				} catch (NumberFormatException e) {
					System.err.println("Argument \"" + args[2] + "\" must be a 0, 1, or 2 (or nothing).");
					System.exit(1);
				}
			}
		} else {
			System.err.println("Usage:\njava HashTest <input type> <load factor> [<debug level>]");
			System.exit(1);
		}
		// find table size (prime between 95500 and 96000 that is 2 away from
		// another prime)
		int tableSize;
		double numKeys;
		TableSize ts = new TableSize(rangeLow, rangeHigh);
		tableSize = ts.getTableSize();
		numKeys = loadFactor * tableSize;
		probeCountArrayL = new int[(int) numKeys + 1];
		probeCountArrayH = new int[(int) numKeys + 1];
		// linear probing
		HashTable<Object> linearPTable = new HashTable<Object>(true, tableSize, inputType);
		HashTable<Object> doubleHTable = new HashTable<Object>(false, tableSize, inputType);

		BufferedReader buff = new BufferedReader(new FileReader("word-list"));
		StringTokenizer toke;
		long tempKeySec = System.currentTimeMillis();

		int count = 0;
		int dupCount = 0;
		while (doubleHTable.getInsertionCount() < numKeys) {
			if (inputType == 1) {
				int tempKey = Math.abs(rand.nextInt(214738785));
				HashObject<Integer> hObj = new HashObject<Integer>(new Integer(tempKey));
				linearPTable.insert(hObj);
				doubleHTable.insert(hObj);
				probeCountArrayL[count] = linearPTable.getTempProbeCount() + 1;
				probeCountArrayH[count] = doubleHTable.getTempProbeCount() + 1;
				if (dupCount != linearPTable.getDuplicateCount()) {
					dupCount++;
				} else {
					count++;
				}
			} else if (inputType == 2) {
				tempKeySec++;
				HashObject<Long> hObj = new HashObject<Long>(new Long(tempKeySec));
				linearPTable.insert(hObj);
				doubleHTable.insert(hObj);
				probeCountArrayL[count] = linearPTable.getTempProbeCount() + 1;
				probeCountArrayH[count] = doubleHTable.getTempProbeCount() + 1;
				if (dupCount != linearPTable.getDuplicateCount()) {
					dupCount++;
				} else {
					count++;
				}
			} else if (inputType == 3) {
				String tempKey = "";
				try {
					tempKey = buff.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
				HashObject<String> hObj = new HashObject<String>(new String(tempKey));
				linearPTable.insert(hObj);
				doubleHTable.insert(hObj);
				probeCountArrayL[count] = linearPTable.getTempProbeCount() + 1;
				probeCountArrayH[count] = doubleHTable.getTempProbeCount() + 1;
				if (dupCount != linearPTable.getDuplicateCount()) {
					dupCount++;
				} else {
					count++;
				}
			}
		}
		double avgProbesL = ((long) (linearPTable.getProbeCount() + linearPTable.getInsertionCount()) / numKeys);
		double avgProbesD = ((long) (doubleHTable.getProbeCount() + doubleHTable.getInsertionCount()) / numKeys);

		if (debugLevel == 0) {
			String dataSource;
			if (inputType == 1)
				dataSource = "random number generator";
			else if (inputType == 2)
				dataSource = "current time";
			else
				dataSource = "word-list";
			System.out.println("A good table size is found: " + tableSize);
			System.out.println("Data source type:  " + dataSource + "\n");
			System.out.println("Using Linear Hashing...\nInserted " + linearPTable.getInsertionCount()
					+ " elements, of which " + linearPTable.getDuplicateCount() + " duplicates");
			System.out.println("load factor = " + loadFactor + ", Avg. no. of probes: " + avgProbesL + "\n\n");
			System.out.println("Using Double Hashing...\nInserted " + doubleHTable.getInsertionCount()
					+ " elements, of which " + doubleHTable.getDuplicateCount() + " duplicates");
			System.out.println("load factor = " + loadFactor + ", Avg. no. of probes: " + avgProbesD);
		} else if (debugLevel == 1) {
			System.out.println(linearPTable.toString());
		} else if (debugLevel == 2) {
			for (int i = 0; i < (int) numKeys; i++) {
				System.out.println("Linear Probing Insert # " + i + ": " + probeCountArrayL[i]);
				System.out.println("Double Hashing Insert # " + i + ": " + probeCountArrayH[i]);
			}
		}
	}
}