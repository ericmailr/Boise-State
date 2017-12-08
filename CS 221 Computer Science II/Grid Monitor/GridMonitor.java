import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Reads .txt file containing cell values for solar arrays and determines which
 * cells are at risk for explosion, if any.
 * 
 * @author Eric
 *
 */
public class GridMonitor implements GridMonitorInterface {
	private String filename, str;
	private File file;
	private int numRows, numColumns;
	private double runningSum, delta;
	private double[][] baseGrid, sumGrid, avgGrid, deltaGrid;
	private boolean[][] dangerGrid;

	/**
	 * Constructor for a particular Grid (solar array) object. Reads a file and
	 * collects info about cell values, creating a 2d array.
	 * 
	 * @param filename
	 *            name of file with data
	 * @throws FileNotFoundException
	 */
	public GridMonitor(String filename) throws FileNotFoundException {
		this.filename = filename;
		this.file = new File(this.filename);
		Scanner scan = new Scanner(file);
		this.numRows = scan.nextInt();
		this.numColumns = scan.nextInt();
		this.baseGrid = new double[this.numRows][this.numColumns];
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				this.baseGrid[row][col] = scan.nextDouble();
			}
		}
		scan.close();
	}

	/**
	 * creates a 2d array representing the original grid data
	 * 
	 * @return baseGridCopy 2d double array copy of actual 2d array (for
	 *         encapsulation)
	 */
	public double[][] getBaseGrid() {
		double[][] baseGridCopy = new double[numRows][numColumns];
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				baseGridCopy[row][col] = baseGrid[row][col];
			}
		}
		return baseGridCopy;
	}

	/**
	 * for each cell, calculates the sum of each adjacent cell. If the cell is
	 * on an edge, its own value is used in place of the missing cell. Stores
	 * cell in 2d array.
	 * 
	 * @return sumGrid 2d double array containing sums
	 */
	public double[][] getSurroundingSumGrid() {
		this.sumGrid = new double[this.numRows][this.numColumns];
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				this.sumGrid[row][col] = baseGrid[row][col];
			}
		}
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				runningSum = 0;
				if (row + 1 < numRows) {
					runningSum += baseGrid[row + 1][col];
				} else {
					runningSum += baseGrid[row][col];
				}
				if (row - 1 >= 0) {
					runningSum += baseGrid[row - 1][col];
				} else {
					runningSum += baseGrid[row][col];
				}
				if (col + 1 < numColumns) {
					runningSum += baseGrid[row][col + 1];
				} else {
					runningSum += baseGrid[row][col];
				}
				if (col - 1 >= 0) {
					runningSum += baseGrid[row][col - 1];
				} else {
					runningSum += baseGrid[row][col];
				}
				this.sumGrid[row][col] = runningSum;
			}
		}
		return this.sumGrid;
	}

	/**
	 * for each cell, calculates the average of the four adjacent cells by
	 * dividing each element in sumGrid by 4.
	 * 
	 * @return avgGrid 2d double array containing averages
	 */
	public double[][] getSurroundingAvgGrid() {
		this.avgGrid = getSurroundingSumGrid();
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				this.avgGrid[row][col] = this.avgGrid[row][col] / 4;
			}
		}
		return this.avgGrid;
	}

	/**
	 * calculates the max deviation (+ or - 50%) from the average cell value
	 * that a particular cell can have.
	 * 
	 * @return deltaGrid 2d double array containing max delta values
	 */
	public double[][] getDeltaGrid() {
		this.deltaGrid = getSurroundingAvgGrid();
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				this.deltaGrid[row][col] = this.avgGrid[row][col] / 2;
			}
		}
		return this.deltaGrid;
	}

	/**
	 * determines whether each cell is in danger of exploding or not (in danger
	 * if value exceeds max deviation from average of adjacent cells).
	 * 
	 * @return dangerGrid 2d boolean array containing true if the cell is at
	 *         risk
	 */
	public boolean[][] getDangerGrid() {
		this.dangerGrid = new boolean[this.numRows][numColumns];
		this.getDeltaGrid();
		this.getSurroundingAvgGrid();
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				this.delta = Math.abs(this.avgGrid[row][col]
						- this.baseGrid[row][col]);
				if (Math.abs(this.delta) > Math.abs(this.deltaGrid[row][col])) {
					this.dangerGrid[row][col] = true;
				} else {
					this.dangerGrid[row][col] = false;
				}
			}
		}
		return this.dangerGrid;
	}

	/**
	 * Returns original cell values as a string, as well as corresponding danger
	 * info (true = dangerous)
	 */
	@Override
	public String toString() {
		this.dangerGrid = this.getDangerGrid();
		this.str = "\nBase Grid:\n";
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				this.str += " " + this.baseGrid[row][col] + " ";
			}
			this.str += "\n";
		}
		this.str += "\nDanger Report:\n";
		for (int row = 0; row < numRows; row++) {
			for (int col = 0; col < numColumns; col++) {
				this.str += " " + this.dangerGrid[row][col] + " ";
			}
			this.str += "\n";
		}
		return this.str;
	}
}
