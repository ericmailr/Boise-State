import java.util.Random;

public class ProcessGenerator {
	private double probability;
	Random rand = new Random();

	public ProcessGenerator(double probability) {
		this.probability = probability;
	}

	/**
	 * 
	 * @return true if random double is <= Process probability
	 */
	public boolean query() {
		return rand.nextDouble() <= probability;
	}

	public Process getNewProcess(int currentTime, int maxProcessTime, int maxLevel) {

		return new Process(currentTime, maxProcessTime, maxLevel);
	}

}
