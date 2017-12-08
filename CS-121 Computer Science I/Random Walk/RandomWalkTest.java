import java.util.Scanner;

/**
 * @author Eric
 */
public class RandomWalkTest {
	private static int gridSize = 0;
	private static long seed = -1;
	private static RandomWalk walk;

	/**
	 * Asks user for grid size and seed
	 */
	private static void getInput() {
		Scanner scan = new Scanner(System.in);
		// These loops ensure the user enters a positive integer (or zero for
		// seed)
		// Otherwise, it gives an error message, including if letters were
		// entered
		while (gridSize <= 0) {
			System.out.println("Enter the grid size: ");
			if (scan.hasNextInt()) {
				gridSize = scan.nextInt();

				if (gridSize <= 0) {
					System.out
							.println("You must enter a positive integer. Try again.");
					scan.nextLine();
				}
			} else {
				System.out
						.println("Error. You must enter a positive integer. Try again. ");
				scan.nextLine();
			}
		}
		while (seed < 0) {
			System.out.println("Enter a seed value: ");
			if (scan.hasNextInt()) {
				seed = scan.nextInt();

				if (seed < 0) {
					System.out
							.println("You must enter a non-negative integer. Try again.");
					scan.nextLine();
				}
			} else {
				System.out
						.println("Error. You must enter a non-negative integer. Try again. ");
				scan.next();
				scan.nextLine();
			}
		}
		scan.close();

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// call getInput to process user input
		getInput();
		// create RandomWalk object using the appropriate constructor
		if (seed == 0) {
			walk = new RandomWalk(gridSize);
		} else {
			walk = new RandomWalk(gridSize, seed);
		}
		// create the random walk and then print it
		walk.createWalk();
		System.out.println(walk);

	}
}
