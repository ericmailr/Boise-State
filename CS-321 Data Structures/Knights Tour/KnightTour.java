import java.util.Arrays;

/**
 * Driver class for solving the Knight's Tour problem using exhaustive search
 * with backtracking.
 * 
 * @author eric miller
 *
 */
public class KnightTour {
	public static void printUsage() {
		System.out.println(
				"Program requires 4 arguments: <0/1/2 (no/heuristicI/heuristicII search)> <n> <x> <y> where n is the size of the chess board (n > 2), (x, y) is the starting position at x row and y column.");
	}

	public static void main(String[] args) {
		String[] heuristics = { "0", "1", "2" };
		int heuristic = -1, size = -1, startRow = -1, startCol = -1;

		// collect/check command line arguments
		if (args.length != 4 || !Arrays.asList(heuristics).contains(args[0])) {
			printUsage();
			System.exit(1);
		}
		try {
			heuristic = Integer.parseInt(args[0]);
			size = Integer.parseInt(args[1]);
			startRow = Integer.parseInt(args[2]);
			startCol = Integer.parseInt(args[3]);
			if (startRow >= size || startCol >= size) {
				printUsage();
				System.exit(1);
			}
		} catch (NumberFormatException e) {
			printUsage();
			System.exit(1);
		}
		if (size <= 2) {
			printUsage();
			System.exit(1);
		}

		// create board
		KnightBoard board = new KnightBoard(size, startRow, startCol);
		boolean solutionExists = false;
		switch (heuristic) {
		case 0:
			if (board.basicSearch(new Position(startRow, startCol))) {
				solutionExists = true;
			}
			break;
		case 1:
			if (board.heuristicOneSearch(new Position(startRow, startCol))) {
				solutionExists = true;
			}
			break;
		case 2:
			if (board.heuristicTwoSearch(new Position(startRow, startCol))) {
				solutionExists = true;
			}
			break;
		default:
			break;

		}
		if (solutionExists) {
			board.getPosition(startRow, startCol).setMoveNumber(1);
			System.out.println(board);
		} else {
			System.out.println("No Solution");
		}
		System.out.println("Total number of moves checked: " + board.getTotalMovesChecked());
	}
}
