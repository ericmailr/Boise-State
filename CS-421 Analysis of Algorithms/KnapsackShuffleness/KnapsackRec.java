import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author eric miller
 *
 */
public class KnapsackRec {
	public static void printUsage() {
		System.out.println(
				"Program requires 4 arguments: # of items, max weight, w.txt (weights data), v.txt (values data)");
	}

	public static void main(String[] args) {
		int n = 0, maxWeight = 0;
		String wFileName = "";
		String vFileName = "";
		ArrayList<Integer> weights = new ArrayList<Integer>(), values = new ArrayList<Integer>();

		if (args.length != 4) {
			printUsage();
			System.exit(1);
		}
		try {
			n = Integer.parseInt(args[0]);
			maxWeight = Integer.parseInt(args[1]);
			wFileName = args[2];
			vFileName = args[3];
		} catch (NumberFormatException e) {
			printUsage();
			System.exit(1);
		}
		String line;
		try (BufferedReader buff = new BufferedReader(new FileReader(wFileName))) {
			while ((line = buff.readLine()) != null) {
				line = line.replaceAll("\\s+", "");
				weights.add(Integer.parseInt(line));
			}
			buff.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try (BufferedReader buff1 = new BufferedReader(new FileReader(vFileName))) {
			while ((line = buff1.readLine()) != null) {
				line = line.replaceAll("\\s+", "");
				values.add(Integer.parseInt(line));
			}
			buff1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (n != weights.size()) {
			printUsage();
			System.exit(1);
		}
		Knapsack k = new Knapsack(n, maxWeight, weights, values);
		System.out.print("Optimal Value: " + k.knapRec(weights.size() - 1, maxWeight) + "\nItems Taken: ");
		Set<Integer> itemsTaken = new HashSet<Integer>();
		int[][] dTable = k.getDecisionTable();
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= maxWeight; j++) {
				if (dTable[i][j] == 1) {
					itemsTaken.add(i);
				}
			}
		}
		Set<Integer> solution = new HashSet<Integer>();
		int subProbW = maxWeight;
		for (int i = n; i > 0; i--) {
			if (dTable[i][subProbW] == 1) {
				subProbW = subProbW - weights.get(i - 1);
				solution.add(i);
			}
		}
		for (Integer i : solution) {
			System.out.print(i + " ");
		}
		System.out.println("\nRecursive Calls: " + k.getRecCount());

	}

	public static class Knapsack {
		private int maxWeight, n, recCount;
		private ArrayList<Integer> weights, values;
		private int[][] decisionTable;

		public Knapsack(int n, int maxWeight, ArrayList<Integer> weights, ArrayList<Integer> values) {
			this.maxWeight = maxWeight;
			this.n = n;
			this.weights = weights;
			this.values = values;
			this.decisionTable = new int[n + 1][maxWeight + 1];
			this.recCount = 0;
		}

		// decision table. if item is taken, then mark it as taken in the table
		// for the current subproblem (i.e. current i and W)
		public int knapRec(int i, int W) {
			recCount++;
			if (i < 0) {
				return 0;
			}
			if (this.weights.get(i) > W) {
				return knapRec(i - 1, W);
			} else {
				int skippedVal = knapRec(i - 1, W);
				int takenVal = knapRec(i - 1, W - weights.get(i)) + values.get(i);
				if (skippedVal < takenVal) {
					decisionTable[i + 1][W] = 1;
					return takenVal;
				} else {
					return skippedVal;
				}
			}
		}

		public int getRecCount() {
			return this.recCount - 1;
		}

		public int[][] getDecisionTable() {
			return this.decisionTable;
		}
	}
}