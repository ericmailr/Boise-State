import java.util.ArrayList;

public class MaxHeap {
	private ArrayList<Process> heap;
	private int largest;
	private Process temp, max;

	public MaxHeap() {
		this.heap = new ArrayList<Process>();
		this.heap.add(null);
	}

	public boolean isEmpty() {
		return this.size() == 0;
	}

	public void insert(Process p) {
		this.heap.add(p);
		this.maxHeapify_Up(this.size());
	}

	public Process extractMax() {
		if (this.size() < 1) {
			return null;
		}
		max = this.heap.get(1);
		this.heap.set(1, this.heap.get(this.size()));
		this.heap.remove(this.size());
		this.maxHeapify_Down(1);
		return max;

	}

	public void delete(int i) {

		this.heap.set(i, this.heap.get(this.size()));
		this.heap.remove(this.size());
		if (i > 1 && i <= this.size()) {
			if (this.heap.get(i).compareTo(this.heap.get(parent(i))) == 1) {
				this.maxHeapify_Up(i);
			} else {
				this.maxHeapify_Down(i);
			}
		} else {
			this.maxHeapify_Down(i);
		}

	}

	public Process getProcess(int i) {
		return this.heap.get(i);
	}

	private void maxHeapify_Down(int i) {
		int l = left(i);
		int r = right(i);
		if (l <= this.size() && this.heap.get(l).compareTo(this.heap.get(i)) == 1) {
			largest = l;
		} else {
			largest = i;
		}
		if (r <= this.size() && this.heap.get(r).compareTo(this.heap.get(largest)) == 1) {
			largest = r;
		}
		if (i != largest) {
			// swap
			temp = this.heap.get(i);
			this.heap.set(i, this.heap.get(largest));
			this.heap.set(largest, temp);
			maxHeapify_Down(largest);
		}
	}

	private void maxHeapify_Up(int i) {
		int p = parent(i);
		if (p > 0 && this.heap.get(i).compareTo(this.heap.get(p)) == 1) {
			// swap
			temp = this.heap.get(i);
			this.heap.set(i, this.heap.get(p));
			this.heap.set(p, temp);
			maxHeapify_Up(p);
		}
	}

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	private int parent(int i) {
		return i / 2;
	}

	public int size() {
		return this.heap.size() - 1;
	}

	public String toString() {
		String result = "{";
		for (Process value : this.heap) {
			if (value == null) {
				continue;
			}
			result += value.toString() + ", ";
		}
		return result.substring(0, result.length() - 2) + "}";
	}

}
