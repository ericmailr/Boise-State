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
public class KnapsackDP {
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
		k.fillTable();
		TableEntry[][] table = k.getTable();
		System.out.print("  ");
		for (int i = 0; i <= maxWeight; i++) {
			System.out.printf("%3d" + "  ", i);
		}
		System.out.println();
		for (int i = 0; i <= maxWeight; i++) {
			System.out.print("-----");
		}
		System.out.println();
		for (int i = 0; i <= n; i++) {
			System.out.print(i + "|");
			for (int j = 0; j <= maxWeight; j++) {
				System.out.printf("%3d", table[i][j].getVal());
				if (table[i][j].getTaken()) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		Set<Integer> solution = new HashSet<Integer>();
		int tempW = maxWeight;
		for (int i = n; i > 0; i--) {
			if (table[i][tempW].getTaken()) {
				solution.add(i);
				tempW = tempW - weights.get(i - 1);
			}
		}
		System.out.print("Optimal Value: " + table[n][maxWeight].getVal() + "\nItems Taken: ");
		for (Integer i : solution) {
			System.out.print(i + " ");
		}
		System.out.println("\nTable References: " + k.getRefCount());

	}

	public static class Knapsack {
		private int maxWeight, n, refCount;
		private ArrayList<Integer> weights, values;
		private TableEntry[][] table;

		public Knapsack(int n, int maxWeight, ArrayList<Integer> weights, ArrayList<Integer> values) {
			this.maxWeight = maxWeight;
			this.n = n;
			this.weights = weights;
			this.values = values;
			this.table = new TableEntry[n + 1][maxWeight + 1];
			this.refCount = 0;
		}

		public void fillTable() {
			for (int i = 0; i <= this.n; i++) {
				for (int j = 0; j <= this.maxWeight; j++) {
					if (i == 0 || j == 0) {
						this.table[i][j] = new TableEntry(0, false);
					} else if (this.weights.get(i - 1) > j) {
						refCount++;
						this.table[i][j] = new TableEntry(this.table[i - 1][j].getVal(), false);
					} else {
						refCount += 2;
						if (this.table[i - 1][j].getVal() < this.table[i - 1][j - this.weights.get(i - 1)].getVal()
								+ this.values.get(i - 1)) {
							this.table[i][j] = new TableEntry(
									this.table[i - 1][j - this.weights.get(i - 1)].getVal() + this.values.get(i - 1),
									true);
						} else {
							this.table[i][j] = new TableEntry(this.table[i - 1][j].getVal(), false);
						}
					}
				}
			}
		}

		public int getRefCount() {
			return this.refCount;
		}

		public TableEntry[][] getTable() {
			return this.table;
		}
	}

	public static class TableEntry {
		private int val;
		private boolean taken;

		public TableEntry(int val, boolean taken) {
			this.val = val;
			this.taken = taken;
		}

		public int getVal() {
			return this.val;
		}

		public boolean getTaken() {
			return this.taken;
		}
	}
}