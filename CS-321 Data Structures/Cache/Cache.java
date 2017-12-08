
import java.util.LinkedList;

/**
 * 
 * @author eric miller Implements a cache using LinkedList.
 * @param <T>
 */
public class Cache<T> {
	private LinkedList<T> t;
	private int size;

	/**
	 * Constructor with given max cache size.
	 * 
	 * @param size
	 */
	public Cache(int size) {
		this.t = new LinkedList<T>();
		this.size = size;
	}

	/**
	 * Adds object to the cache. Checks size and removes extra object if
	 * necessary.
	 * 
	 * @param object
	 */
	public void addObject(T object) {
		this.t.addFirst(object);
		if (this.t.size() > this.size) {
			this.t.removeLast();
		}
	}

	/**
	 * Removes specified object.
	 * 
	 * @param object
	 */
	public void removeObject(T object) {
		this.t.remove(object);

	}

	/**
	 * Clears the cache.
	 */
	public void clearCache() {
		this.t.clear();
	}

	/**
	 * 
	 * @return t, the LinkedList representing the cache.
	 */
	public LinkedList<T> getCache() {
		return this.t;
	}
}