import java.util.Comparator;
import java.util.ListIterator;

/**
 * Class for sorting DoubleLinkedLists using either natural order or a
 * Comparator.
 *
 * @author spanter, mvail, Eric Miller
 * 
 */
public class MergeSort {

	/**
	 * Sorts a list that implements the DoubleLinkedListADT using the natural
	 * ordering of list elements. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The data type in the list must extend Comparable
	 * @param list
	 *            The list that will be sorted
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> void sort(
			DoubleLinkedListADT<T> list) {
		DoubleLinkedListADT<T> list1 = new WrappedDLL<T>();
		DoubleLinkedListADT<T> list2 = new WrappedDLL<T>();
		if (list.size() > 1) {

			int l1Size = list.size() / 2;
			int l2Size = list.size() - l1Size;

			ListIterator<T> it = list.listIterator();
			for (int i = 0; i < l1Size; i++) {
				list1.add(it.next());
			}
			for (int i = l1Size; i < l1Size + l2Size; i++) {
				list2.add(it.next());
			}

			sort(list1);
			sort(list2);
			DoubleLinkedListADT<T> temp = new WrappedDLL<T>();
			temp = merge(list1, list2);
			ListIterator<T> tempIt = temp.listIterator();
			while (tempIt.hasNext()) {
				list.removeFirst();
				list.add(tempIt.next());
			}
		}

	}

	/**
	 * Sorts a DoubleLinkedListADT with the provided Comparator. DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of list to sort
	 * @param list
	 *            The list to sort
	 * @param c
	 *            The Comparator to use
	 * @see DoubleLinkedListADT
	 */
	public static <T> void sort(DoubleLinkedListADT<T> list, Comparator<T> c) {
		DoubleLinkedListADT<T> list1 = new WrappedDLL<T>();
		DoubleLinkedListADT<T> list2 = new WrappedDLL<T>();
		if (list.size() > 1) {

			int l1Size = list.size() / 2;
			int l2Size = list.size() - l1Size;

			ListIterator<T> it = list.listIterator();
			for (int i = 0; i < l1Size; i++) {
				list1.add(it.next());
			}
			for (int i = l1Size; i < l1Size + l2Size; i++) {
				list2.add(it.next());
			}

			sort(list1, c);
			sort(list2, c);
			DoubleLinkedListADT<T> temp = new WrappedDLL<T>();
			temp = merge(list1, list2, c);
			ListIterator<T> tempIt = temp.listIterator();
			while (tempIt.hasNext()) {
				list.removeFirst();
				list.add(tempIt.next());
			}
		}

	}

	/**
	 * Merges two already ordered lists into a single list with natural ordering
	 * 
	 * @param list1
	 * @param list2
	 * @return mergedList combined, natural-ordered list of list1 and list1
	 */
	private static <T extends Comparable<T>> DoubleLinkedListADT<T> merge(
			DoubleLinkedListADT<T> list1, DoubleLinkedListADT<T> list2) {

		DoubleLinkedListADT<T> mergedList = new WrappedDLL<T>();
		ListIterator<T> it1 = list1.listIterator();
		ListIterator<T> it2 = list2.listIterator();
		while (it1.hasNext() && it2.hasNext()) {
			if (it1.next().compareTo(it2.next()) < 1) {
				mergedList.add(it1.previous());
				it1.next();
				it2.previous();
			} else {
				mergedList.add(it2.previous());
				it2.next();
				it1.previous();
			}
		}

		while (it1.hasNext()) {
			mergedList.add(it1.next());
		}
		while (it2.hasNext()) {
			mergedList.add(it2.next());
		}

		return mergedList;
	}

	/**
	 * Merges two ordered lists into one list that is ordered using a Custom
	 * Comparator
	 * 
	 * @param list1
	 * @param list2
	 * @param c
	 * @return mergedList combined list of the elements from list1 and list2 in
	 *         the order specified by the provided Comparator
	 */
	private static <T> DoubleLinkedListADT<T> merge(
			DoubleLinkedListADT<T> list1, DoubleLinkedListADT<T> list2,
			Comparator<T> c) {

		DoubleLinkedListADT<T> mergedList = new WrappedDLL<T>();
		ListIterator<T> it1 = list1.listIterator();
		ListIterator<T> it2 = list2.listIterator();
		while (it1.hasNext() && it2.hasNext()) {
			if (c.compare(it1.next(), it2.next()) < 1) {
				mergedList.add(it1.previous());
				it1.next();
				it2.previous();
			} else {
				mergedList.add(it2.previous());
				it2.next();
				it1.previous();
			}
		}

		while (it1.hasNext()) {
			mergedList.add(it1.next());
		}
		while (it2.hasNext()) {
			mergedList.add(it2.next());
		}

		return mergedList;
	}

	/**
	 * Finds the smallest element in a list according to the natural ordering of
	 * list elements. Does not alter the order of list elements. DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The smallest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findSmallest(
			DoubleLinkedListADT<T> list) {
		if (list.size() == 1) {
			return list.first();
		} else if (list.isEmpty()) {
			return null;
		}
		ListIterator<T> it = list.listIterator();
		T min = it.next();
		return minRecursive(it, min);
	}

	/**
	 * Finds the smallest element in a list with a Custom comparator. Does not
	 * alter the order of list elements. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The smallest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findSmallest(DoubleLinkedListADT<T> list,
			Comparator<T> c) {

		if (list.size() == 1) {
			return list.first();
		} else if (list.isEmpty()) {
			return null;
		}

		ListIterator<T> it = list.listIterator();
		T min = it.next();
		return minRecursive(it, min, c);
	}

	/**
	 * Recursively finds the minimum element for a given ListIterator and
	 * current minimum
	 * 
	 * @param it
	 *            - provided ListIterator
	 * @param min
	 *            - some minimum element to compare elements in the List
	 *            Iterator to
	 * @return min the minimum element from the ListIterator
	 */
	private static <T extends Comparable<T>> T minRecursive(ListIterator<T> it,
			T min) {

		if (!it.hasNext()) {
			return it.previous();
		}

		T val = minRecursive(it, it.next());

		if (it.previous().compareTo(val) < 1) {
			return it.next();
		} else {
			return val;
		}
	}

	/**
	 * Recursively finds the minimum element for a given ListIterator and
	 * current minimum using a custom Comparator
	 * 
	 * @param it
	 *            - provided ListIterator
	 * @param min
	 *            - some minimum element to compare elements in the List
	 *            Iterator to
	 * @return min the minimum element from the ListIterator
	 */
	private static <T> T minRecursive(ListIterator<T> it, T min, Comparator<T> c) {

		if (!it.hasNext()) {
			return it.previous();
		}

		T val = minRecursive(it, it.next(), c);
		if (c.compare(it.previous(), val) < 1) {
			return it.next();
		} else {
			return val;
		}
	}

	/**
	 * Finds the largest element in a list according to the natural ordering of
	 * list elements. Does not alter the order of list elements. DO NOT MODIFY
	 * THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @return The largest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T extends Comparable<T>> T findLargest(
			DoubleLinkedListADT<T> list) {

		if (list.size() == 1) {
			return list.first();
		} else if (list.isEmpty()) {
			return null;
		}
		ListIterator<T> it = list.listIterator();
		T max = it.next();
		return maxRecursive(it, max);
	}

	/**
	 * Finds the largest element in a list with a Custom comparator. Does not
	 * alter the order of list elements. DO NOT MODIFY THIS METHOD SIGNATURE
	 * 
	 * @param <T>
	 *            The type of object we are comparing
	 * @param list
	 *            The list we are passed
	 * @param c
	 *            The comparator to use
	 * @return The largest element or null if list is empty
	 * @see DoubleLinkedListADT
	 */
	public static <T> T findLargest(DoubleLinkedListADT<T> list, Comparator<T> c) {

		if (list.size() == 1) {
			return list.first();
		} else if (list.isEmpty()) {
			return null;
		}
		ListIterator<T> it = list.listIterator();
		T max = it.next();
		return maxRecursive(it, max, c);
	}

	/**
	 * Recursively finds the biggest element for a given ListIterator and
	 * current maximum using natural ordering
	 * 
	 * @param it
	 *            - provided ListIterator
	 * @param max
	 *            - some maximum element to compare elements in the List
	 *            Iterator to
	 * @return max the biggest element from the ListIterator
	 */
	private static <T extends Comparable<T>> T maxRecursive(ListIterator<T> it,
			T max) {

		if (!it.hasNext()) {
			return it.previous();
		}
		T val = maxRecursive(it, it.next());

		if (it.previous().compareTo(val) > -1) {
			return it.next();
		} else {
			return val;
		}
	}

	/**
	 * Recursively finds the biggest element for a given ListIterator and
	 * current maximum using a custom Comparator
	 * 
	 * @param it
	 *            - provided ListIterator
	 * @param max
	 *            - some maximum element to compare elements in the List
	 *            Iterator to
	 * @param c
	 *            Custom Comparator
	 * @return max the biggest element from the ListIterator
	 */
	private static <T> T maxRecursive(ListIterator<T> it, T max, Comparator<T> c) {

		if (!it.hasNext()) {
			return it.previous();
		}
		T val = maxRecursive(it, it.next(), c);
		if (c.compare(it.previous(), val) > -1) {
			return it.next();
		} else {
			return val;
		}
	}
}
