import java.util.ListIterator;

/**
 * Driver class for testing MergeSort.java
 * 
 * @author Eric Miller
 *
 */
public class MergeSortTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;

	public static void main(String[] args) {
		MergeSortTester tester = new MergeSortTester();
		tester.runTests();
	}

	/**
	 * Print test results in a consistent format
	 * 
	 * @param testDesc
	 *            description of the test
	 * @param result
	 *            indicates if the test passed or failed
	 */
	private void printTest(String testDesc, boolean result) {
		total++;
		if (result) {
			passes++;
		} else {
			failures++;
		}
		System.out.printf("%-48s\t%s\n", testDesc, (result ? "   PASS"
				: "***FAIL***"));
	}

	/** Print a final summary */
	private void printFinalSummary() {
		System.out.printf("\nTotal Tests: %d,  Passed: %d,  Failed: %d\n",
				total, passes, failures);
	}

	/**
	 * Run tests to confirm required functionality from list constructors and
	 * methods
	 */
	private void runTests() {
		// TESTS ON A NEW, EMPTY LIST
		printTest("newList_testFindLargest_Comparator",
				newList_testFindLargest_Comparator());
		printTest("newList_testFindLargest", newList_testFindLargest());
		printTest("newList_testFindSmallest_Comparator",
				newList_testFindSmallest_Comparator());
		printTest("newList_testFindSmallest", newList_testFindSmallest());
		printTest("oneList_testSort", oneList_testSort());
		printTest("nineList_testFindSmallest", nineList_testFindSmallest());
		printTest("nineList_testFindLargest", nineList_testFindLargest());
		printTest("nineList_testSort", nineList_testSort());
		printTest("nineList_testSort_CustomComparator",
				nineList_testSort_CustomComparator());

		printFinalSummary();
	}

	/**
	 * Returns an empty DoubleLinkedList for testing
	 *
	 * @return a new DoubleLinkedList
	 */
	private WrappedDLL<Integer> newList() {
		return new WrappedDLL<Integer>();
	}

	/**
	 * Returns a new list containing one integer (1)
	 * 
	 * @return list (1)
	 */
	private WrappedDLL<Integer> oneList() {
		WrappedDLL<Integer> list = newList();
		list.add(1);
		return list;
	}

	/**
	 * Returns list with three elements (3,2,1)
	 * 
	 * @return list (3,2,1)
	 */
	private WrappedDLL<Integer> threeList() {
		WrappedDLL<Integer> list = oneList();
		list.addToFront(2);
		list.addToFront(3);
		return list;
	}

	/**
	 * creates list with 9 integers [5,4,6,9,10,3,2,1,7]
	 * 
	 * @return list
	 */
	private WrappedDLL<Integer> nineList() {
		WrappedDLL<Integer> list = threeList();
		list.addToFront(10);
		list.addToFront(9);
		list.addToRear(7);
		list.addToFront(6);
		list.addToFront(4);
		list.addToFront(5);
		return list;
	}

	// TEST METHODS
	/** @return test success */
	@SuppressWarnings("unchecked")
	private boolean newList_testFindLargest_Comparator() {
		WrappedDLL<Integer> list = newList();
		IntegerComparator c = new IntegerComparator();
		try {
			return (MergeSort.findLargest(list, c) == null);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testFindLargest_Comparator()", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testFindLargest() {
		WrappedDLL<Integer> list = newList();
		try {
			return (MergeSort.findLargest(list) == null);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testFindLargest", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unchecked")
	private boolean newList_testFindSmallest_Comparator() {
		WrappedDLL<Integer> list = newList();
		IntegerComparator c = new IntegerComparator();
		try {
			return (MergeSort.findSmallest(list, c) == null);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testFindSmallest_Comparator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testFindSmallest() {
		WrappedDLL<Integer> list = newList();
		try {
			return (MergeSort.findSmallest(list) == null);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testFindSmallest", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneList_testSort() {
		WrappedDLL<Integer> list = oneList();
		MergeSort.sort(list);
		try {
			return (list.first() == 1 && list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneList_testSort()", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unchecked")
	private boolean nineList_testFindSmallest() {
		WrappedDLL<Integer> list = nineList();
		IntegerComparator c = new IntegerComparator();
		try {
			return (MergeSort.findSmallest(list) == 1 && MergeSort
					.findSmallest(list, c) == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"nineList_testFindSmallest", e.toString());
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	private boolean nineList_testFindLargest() {
		WrappedDLL<Integer> list = nineList();
		IntegerComparator c = new IntegerComparator();
		try {
			return (MergeSort.findLargest(list) == 10 && MergeSort.findLargest(
					list, c) == 10);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"nineList_testFindLargest", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean nineList_testSort() {
		WrappedDLL<Integer> list = nineList();
		MergeSort.sort(list);
		ListIterator<Integer> it = list.listIterator();
		try {
			return (it.next() == 1 && it.next() == 2 && it.next() == 3
					&& it.next() == 4 && it.next() == 5 && it.next() == 6
					&& it.next() == 7 && it.next() == 9);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "nineList_testSort",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unchecked")
	private boolean nineList_testSort_CustomComparator() {
		WrappedDLL<Integer> list = nineList();
		IntegerComparator c = new IntegerComparator();
		MergeSort.sort(list, c);
		ListIterator<Integer> it = list.listIterator();
		try {
			return (it.next() == 1 && it.next() == 2 && it.next() == 3
					&& it.next() == 4 && it.next() == 5 && it.next() == 6
					&& it.next() == 7 && it.next() == 9);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"nineList_testSort_CustomComparator", e.toString());
			return false;
		}
	}

}
