import java.util.Random;

public class Process implements Comparable<Process> {
	private int priorityLevel, timeRemaining, arrivalTime, timeNotProcessed;
	Random rando = new Random();

	public Process(int currentTime, int maxProcessTime, int maxLevel) {
		this.priorityLevel = rando.nextInt(maxLevel) + 1;
		this.timeRemaining = rando.nextInt(maxProcessTime) + 1;
		this.arrivalTime = currentTime;
		this.timeNotProcessed = 0;

	}

	public int getTimeRemaining() {
		return this.timeRemaining;
	}

	public int getPriority() {
		return this.priorityLevel;
	}

	// I added this one
	public void incrementPriority() {
		this.priorityLevel++;
	}

	public int getArrivalTime() {
		return this.arrivalTime;
	}

	public void reduceTimeRemaining() {
		if (this.timeRemaining > 0)
			this.timeRemaining--;
	}

	// I added this one
	public void incrementTimeNotProcessed() {
		this.timeNotProcessed++;
	}

	// and this one
	public int getTimeNotProcessed() {
		return this.timeNotProcessed;
	}

	public boolean finish() {
		return this.getTimeRemaining() == 0;
	}

	public void resetTimeNotProcessed() {
		this.timeNotProcessed = 0;

	}

	@Override
	public int compareTo(Process p) {
		if (this.priorityLevel > p.getPriority()) {
			return 1;
		}
		if (this.priorityLevel < p.getPriority()) {
			return -1;
		}
		if (this.priorityLevel == p.getPriority()) {
			if (this.arrivalTime < p.getArrivalTime()) {
				return 1;
			} else if (this.arrivalTime > p.getArrivalTime()) {
				return -1;
			}
		}
		return 0;
	}

	public String toString() {
		return "(" + this.priorityLevel + ", " + this.arrivalTime + ")";
	}

}
