import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Represents a 2D circuit board as read from an input file.
 * 
 * @author mvail, Eric Miller
 */
public class CircuitBoard {
	private char[][] board;
	private Point startingPoint;
	private Point endingPoint;

	private final int ROWS; // initialized in constructor
	private final int COLS; // initialized in constructor
	private final char OPEN = 'O';
	@SuppressWarnings("unused")
	private final char CLOSED = 'X';
	private final char TRACE = 'T';
	private final char START = '1';
	private final char END = '2';
	private final String ALLOWED_CHARS = "OXT12";

	/**
	 * Construct a CircuitBoard from a given board input file, where the first
	 * line contains the number of rows and columns as ints and each subsequent
	 * line is one row of characters representing the contents of that position.
	 * Valid characters are as follows: 'O' an open position 'X' an occupied,
	 * unavailable position '1' first of two components needing to be connected
	 * '2' second of two components needing to be connected 'T' is not expected
	 * in input files - represents part of the trace connecting components 1 and
	 * 2 in the solution
	 * 
	 * @param filename
	 *            file containing a grid of characters
	 * @throws FileNotFoundException
	 * @throws InvalidFileFormatException
	 */
	public CircuitBoard(String filename) throws FileNotFoundException,
			InvalidFileFormatException {
		File file = new File(filename);
		if (!file.canRead() || !file.exists()) {
			throw new FileNotFoundException();
		} else {
			Scanner fileScan = new Scanner(file);
			String tempLine = fileScan.nextLine();
			StringTokenizer toke = new StringTokenizer(tempLine, " ");
			if (toke.countTokens() != 2) {
				fileScan.close();
				throw new InvalidFileFormatException(
						"First line of file is not formatted correctly.");
			}
			try {
				ROWS = Integer.parseInt(toke.nextToken());
				COLS = Integer.parseInt(toke.nextToken());
			} catch (Exception e) {
				fileScan.close();
				throw new InvalidFileFormatException(
						"First line of file is not formatted correctly.");
			}
			board = new char[ROWS][COLS];
			int startEndCount = 0;
			int lineCount = 0;
			int numTokens = 0;
			boolean isValidChar;
			while (fileScan.hasNextLine()) {
				lineCount++;
				tempLine = fileScan.nextLine();
				toke = new StringTokenizer(tempLine, " ");
				numTokens = toke.countTokens();
				if (lineCount > ROWS || numTokens != COLS) {
					fileScan.close();
					throw new InvalidFileFormatException("Invalid File Format.");
				}
				for (int i = 0; i < numTokens; i++) {
					String tempToken = toke.nextToken();
					board[lineCount - 1][i] = tempToken.charAt(0);
					isValidChar = false;
					for (int j = 0; j < ALLOWED_CHARS.length(); j++) {
						if (tempToken.equals(ALLOWED_CHARS.substring(j, j + 1))) {
							isValidChar = true;
							break;
						}
					}
					if (!isValidChar) {
						fileScan.close();
						throw new InvalidFileFormatException(
								"Invalid character in file.");
					}

					if (tempToken.equals(Character.toString(START))) {
						startingPoint = new Point(lineCount - 1, i);
						startEndCount++;
					}
					if (tempToken.equals(Character.toString(END))) {
						endingPoint = new Point(lineCount - 1, i);
						startEndCount++;
					}

					if (startEndCount > 2
							|| tempToken.equals(Character.toString(TRACE))) {
						fileScan.close();
						throw new InvalidFileFormatException(
								"Invalid File Format.");
					}
				}
			}
			if (lineCount != ROWS || startEndCount != 2) {
				fileScan.close();
				throw new InvalidFileFormatException("Invalid File Format.");
			}
			fileScan.close();
		}
	}

	/**
	 * Copy constructor - duplicates original board
	 * 
	 * @param original
	 *            board to copy
	 */
	public CircuitBoard(CircuitBoard original) {
		board = original.getBoard();
		startingPoint = new Point(original.startingPoint);
		endingPoint = new Point(original.endingPoint);
		ROWS = original.numRows();
		COLS = original.numCols();
	}

	/**
	 * utility method for copy constructor
	 * 
	 * @return copy of board array
	 */
	private char[][] getBoard() {
		char[][] copy = new char[board.length][board[0].length];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				copy[row][col] = board[row][col];
			}
		}
		return copy;
	}

	/**
	 * Return the char at board position x,y
	 * 
	 * @param row
	 *            row coordinate
	 * @param col
	 *            col coordinate
	 * @return char at row, col
	 */
	public char charAt(int row, int col) {
		return board[row][col];
	}

	/**
	 * Return whether given board position is open
	 * 
	 * @param row
	 * @param col
	 * @return true if position at (row, col) is open
	 */
	public boolean isOpen(int row, int col) {
		if (row < 0 || row >= board.length || col < 0
				|| col >= board[row].length) {
			return false;
		}
		return board[row][col] == OPEN;
	}

	/**
	 * Set given position to be a 'T'
	 * 
	 * @param row
	 * @param col
	 * @throws OccupiedPositionException
	 *             if given position is not open
	 */
	public void makeTrace(int row, int col) {
		if (isOpen(row, col)) {
			board[row][col] = TRACE;
		} else {
			throw new OccupiedPositionException("row " + row + ", col " + col
					+ "contains '" + board[row][col] + "'");
		}
	}

	/** @return starting Point */
	public Point getStartingPoint() {
		return new Point(startingPoint);
	}

	/** @return ending Point */
	public Point getEndingPoint() {
		return new Point(endingPoint);
	}

	/** @return number of rows in this CircuitBoard */
	public int numRows() {
		return ROWS;
	}

	/** @return number of columns in this CircuitBoard */
	public int numCols() {
		return COLS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				str.append(board[row][col] + " ");
			}
			str.append("\n");
		}
		return str.toString();
	}

}// class CircuitBoard
