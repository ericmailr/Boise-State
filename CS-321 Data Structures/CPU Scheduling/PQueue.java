
public class PQueue {
	MaxHeap m;
	Process temp;

	public PQueue() {
		this.m = new MaxHeap();
	}

	public void enPQueue(Process p) {
		this.m.insert(p);
	}

	public Process dePQueue() {
		return this.m.extractMax();
	}

	public boolean isEmpty() {
		return this.m.isEmpty();
	}

	public void update(int timeToIncrementPriority, int maxLevel) {

		for (int i = 1; i <= this.m.size(); i++) {
			this.m.getProcess(i).incrementTimeNotProcessed();
			if (this.m.getProcess(i).getTimeNotProcessed() >= timeToIncrementPriority) {
				if (this.m.getProcess(i).getPriority() < maxLevel) {
					this.m.getProcess(i).incrementPriority();
					this.m.getProcess(i).resetTimeNotProcessed();
				}
			}
		}
		for (int i = 1; i <= this.m.size(); i++) {
			if (this.m.getProcess(i).getTimeNotProcessed() == 0) {
				temp = this.m.getProcess(i);
				this.m.delete(i);
				this.m.insert(temp);
			}
		}
	}

	public void delete(int i) {
		this.m.delete(i);
	}

	public String toString() {
		return this.m.toString();
	}
}
