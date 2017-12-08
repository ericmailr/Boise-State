
public class HashObject<T> {
	private int frequency;
	private T key;

	public HashObject(T t) {
		this.key = t;
		this.frequency = 0;
	}

	public T getKey() {
		return this.key;
	}

	public void incrementFrequency() {
		this.frequency++;
	}

	public boolean equal(HashObject<T> h) {
		return (this.key.equals(h.getKey()));
	}

	public String toString() {
		return this.key + " " + this.frequency;
	}
}
