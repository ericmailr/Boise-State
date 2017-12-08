import java.util.Comparator;

/**
 * Comparator for integers that orders integers from least to greatest
 * 
 * @author Eric Miller
 *
 */
public class IntegerComparator implements Comparator {
	/**
	 * @returns -1 if first object is less than second object, 0 if equal, 1 if
	 *          greater
	 */
	@Override
	public int compare(Object o1, Object o2) {
		int i1 = ((Integer) o1);
		int i2 = ((Integer) o2);
		if (i1 < i2) {
			return -1;
		} else if (i1 == i2) {
			return 0;
		} else {
			return 1;
		}

	}

}
