import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Search for shortest paths between start and end points on a circuit board as
 * read from an input file using either a stack or queue as the underlying
 * search state storage structure and displaying output to the console or to a
 * GUI according to options specified via command-line arguments.
 * 
 * @author mvail, Eric Miller
 */
public class CircuitTracer {
	private CircuitBoard board;
	private Storage<TraceState> stateStore;
	private ArrayList<TraceState> bestPaths;

	/**
	 * launch the program
	 * 
	 * @param args
	 *            three required arguments: first arg: -s for stack or -q for
	 *            queue second arg: -c for console output or -g for GUI output
	 *            third arg: input file name
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			printUsage();
			System.exit(1);
		}
		try {
			new CircuitTracer(args); // create this with args
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	/** Print instructions for running CircuitTracer from the command line. */
	private static void printUsage() {
		System.out
				.println("Usage:\njava CircuitTracer <dataStructure> <displayMode> <inputFileNameCircuitBoard>\nWhere:\n"
						+ "    <dataStructure> is the data structure that will be used to find the circuit, and should be either:\n"
						+ "        -s, for using stack\n        -q, for using queue\n    <displayMode> is the display mode for the output, "
						+ "which should be either:\n        -c, for using a console\n        -g, for using a GUI\n    <inputFileNameCircuitBoard> "
						+ "is the file name for the input circuit board\nExample:    java CircuitTracer -s -g circuit1.dat\n");
	}

	/**
	 * Set up the CircuitBoard and all other components based on command line
	 * arguments.
	 * 
	 * @param args
	 *            command line arguments passed through from main()
	 * @throws FileNotFoundException
	 *             , InvalidFileFormatException
	 */
	private CircuitTracer(String[] args) throws FileNotFoundException,
			InvalidFileFormatException {
		// parse command line args
		String storageType = args[0];
		String outputType = args[1];
		String fileName = args[2];
		// initialize the Storage to use either a stack or queue
		if (storageType.equals("-s")) {
			stateStore = Storage.getStackInstance();
		} else if (storageType.equals("-q")) {
			stateStore = Storage.getQueueInstance();
		} else {
			printUsage();
			System.exit(1);
		}
		// read in the CircuitBoard from the given file

		board = new CircuitBoard(fileName);

		int startingX = board.getStartingPoint().x;
		int startingY = board.getStartingPoint().y;
		// search for best paths
		for (int addX = -1; addX < 2; addX++) {
			for (int addY = -1; addY < 2; addY++) {
				if (Math.abs(addX) + Math.abs(addY) < 2) {
					if (board.isOpen(startingX + addX, startingY + addY)) {
						stateStore.store(new TraceState(board,
								startingX + addX, startingY + addY));
					}
				}
			}
		}

		int bestPathLength = Integer.MAX_VALUE;
		bestPaths = new ArrayList<TraceState>();
		while (!stateStore.isEmpty()) {
			TraceState currentState = stateStore.retrieve();
			int currentPathLength = currentState.pathLength();
			if (currentState.isComplete()) {
				if (currentPathLength <= bestPathLength) {
					bestPaths.add(currentState);
					if (currentPathLength < bestPathLength) {
						bestPathLength = currentPathLength;
						bestPaths.clear();
						bestPaths.add(currentState);
					}
				}
			} else {

				for (int addX = -1; addX < 2; addX++) {
					for (int addY = -1; addY < 2; addY++) {
						if (Math.abs(addX) + Math.abs(addY) < 2
								&& Math.abs(addX) + Math.abs(addY) != 0) {
							if (currentState.getBoard().isOpen(
									currentState.getRow() + addX,
									currentState.getCol() + addY)) {
								stateStore.store(new TraceState(currentState,
										currentState.getRow() + addX,
										currentState.getCol() + addY));
							}
						}
					}
				}

			}

		}

		// output results to console or GUI, according to specified choice
		if (outputType.equals("-c")) {
			for (TraceState state : bestPaths)
				System.out.println(state.toString());
		} else if (outputType.equals("-g")) {
			System.out
					.println("Sorry, a GUI for this program has not yet been implemented. Here is the text output:");
			for (TraceState state : bestPaths)
				System.out.println(state.toString());
		} else {
			printUsage();
			System.exit(1);
		}
	}
} // class CircuitTracer
