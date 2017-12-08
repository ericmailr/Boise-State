import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * A test class for DoubleLinkedList implementation of DoubleLinkedListADT.
 * 
 * 
 * 
 * @author mvail, Eric Miller
 */
public class DoubleLinkedListTester {
	private int passes = 0;
	private int failures = 0;
	private int total = 0;
	private final Integer i = new Integer(1);
	private final Integer i2 = new Integer(2);
	private final Integer i3 = new Integer(3);
	private final Integer i4 = new Integer(4);

	/**
	 * @param args
	 *            not used
	 */
	public static void main(String[] args) {
		// to avoid every method being static
		DoubleLinkedListTester tester = new DoubleLinkedListTester();
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
		System.out.printf("%-60s\t%s\n", testDesc, (result ? "   PASS"
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
		printTest("newList_testAddToFront", newList_testAddToFront());
		printTest("newList_testAddToRear", newList_testAddToRear());
		printTest("newList_testAddAfter", newList_testAddAfter());
		printTest("newList_testRemoveFirst", newList_testRemoveFirst());
		printTest("newList_testRemoveLast", newList_testRemoveLast());
		printTest("newList_testRemoveElement", newList_testRemoveElement());
		printTest("newList_testFirst", newList_testFirst());
		printTest("newList_testLast", newList_testLast());
		printTest("newList_testContains", newList_testContains());
		printTest("newList_testIsEmpty", newList_testIsEmpty());
		printTest("newList_testSize", newList_testSize());
		printTest("newList_testIterator", newList_testIterator());
		printTest("newList_testIteratorHasNext", newList_testIteratorHasNext());
		printTest("newList_testIteratorNext", newList_testIteratorNext());
		printTest("newList_testToString", newList_testToString());

		printTest("newList_testAddAtIndex", newList_testAddAtIndex());
		printTest("newList_testSet", newList_testSet());
		printTest("newList_testAdd", newList_testAdd());
		printTest("newList_testGet", newList_testGet());
		printTest("newList_testIndexOf", newList_testIndexOf());
		printTest("newList_testRemove", newList_testRemove());

		// TESTS ON A PREVIOUSLY EMPTY LIST WITH ONE ELEMENT ADDED TO THE FRONT
		printTest("noneToOne_addToFrontList_testAddToFront",
				noneToOne_addToFrontList_testAddToFront());
		printTest("noneToOne_addToFrontList_testAddToRear",
				noneToOne_addToFrontList_testAddToRear());
		printTest("noneToOne_addToFrontList_testAddAfter",
				noneToOne_addToFrontList_testAddAfter());
		printTest("noneToOne_addToFrontList_testAddAfter_ElementNotFound",
				noneToOne_addToFrontList_testAddAfter_ElementNotFound());
		printTest("noneToOne_addToFrontList_testRemoveFirst",
				noneToOne_addToFrontList_testRemoveFirst());
		printTest("noneToOne_addToFrontList_testRemoveLast",
				noneToOne_addToFrontList_testRemoveLast());
		printTest("noneToOne_addToFrontList_testRemove",
				noneToOne_addToFrontList_testRemove());
		printTest("noneToOne_addToFrontList_testRemove_ElementNotFound",
				noneToOne_addToFrontList_testRemove_ElementNotFound());
		printTest("noneToOne_addToFrontList_testFirst",
				noneToOne_addToFrontList_testFirst());
		printTest("noneToOne_addToFrontList_testLast",
				noneToOne_addToFrontList_testLast());
		printTest("noneToOne_addToFrontList_testContains",
				noneToOne_addToFrontList_testContains());
		printTest("noneToOne_addToFrontList_testContains_false",
				noneToOne_addToFrontList_testContains_false());
		printTest("noneToOne_addToFrontList_testIsEmpty",
				noneToOne_addToFrontList_testIsEmpty());
		printTest("noneToOne_addToFrontList_testSize",
				noneToOne_addToFrontList_testSize());
		printTest("noneToOne_addToFrontList_testIterator",
				noneToOne_addToFrontList_testIterator());
		printTest("noneToOne_addToFrontList_testToString",
				noneToOne_addToFrontList_testToString());

		printTest("noneToOne_addToFrontList_testAddAtIndex",
				noneToOne_addToFrontList_testAddAtIndex());
		printTest("noneToOne_addToFrontList_testAddAtIndex_IndexOutOfBounds",
				noneToOne_addToFrontList_testAddAtIndex_IndexOutOfBounds());
		printTest("noneToOne_addToFrontList_testSet",
				noneToOne_addToFrontList_testSet());
		printTest("noneToOne_addToFrontList_testSet_IndexOutOfBounds",
				noneToOne_addToFrontList_testSet_IndexOutOfBounds());
		printTest("noneToOne_addToFrontList_testAdd",
				noneToOne_addToFrontList_testAdd());
		printTest("noneToOne_addToFrontList_testGet",
				noneToOne_addToFrontList_testGet());
		printTest("noneToOne_addToFrontList_testGet_IndexOutOfBounds",
				noneToOne_addToFrontList_testGet_IndexOutOfBounds());
		printTest("noneToOne_addToFrontList_testIndexOf",
				noneToOne_addToFrontList_testIndexOf());
		printTest("noneToOne_addToFrontList_testIndexOf_ElementNotFound",
				noneToOne_addToFrontList_testIndexOf_ElementNotFound());

		// TESTS ON A PREVIOUSLY EMPTY LIST WITH ONE ELEMENT ADDED TO THE REAR
		printTest("noneToOne_addToRearList_testAddToFront",
				noneToOne_addToRearList_testAddToFront());
		printTest("noneToOne_addToRearList_testAddToRear",
				noneToOne_addToRearList_testAddToRear());
		printTest("noneToOne_addToRearList_testAddAfter",
				noneToOne_addToRearList_testAddAfter());
		printTest("noneToOne_addToRearList_testAddAfter_ElementNotFound",
				noneToOne_addToRearList_testAddAfter_ElementNotFound());
		printTest("noneToOne_addToRearList_testRemoveFirst",
				noneToOne_addToRearList_testRemoveFirst());
		printTest("noneToOne_addToRearList_testRemoveLast",
				noneToOne_addToRearList_testRemoveLast());
		printTest("noneToOne_addToRearList_testRemove",
				noneToOne_addToRearList_testRemove());
		printTest("noneToOne_addToRearList_testRemove_ElementNotFound",
				noneToOne_addToRearList_testRemove_ElementNotFound());
		printTest("noneToOne_addToRearList_testFirst",
				noneToOne_addToRearList_testFirst());
		printTest("noneToOne_addToRearList_testLast",
				noneToOne_addToRearList_testLast());
		printTest("noneToOne_addToRearList_testContains",
				noneToOne_addToRearList_testContains());
		printTest("noneToOne_addToRearList_testContains_false",
				noneToOne_addToRearList_testContains_false());
		printTest("noneToOne_addToRearList_testIsEmpty",
				noneToOne_addToRearList_testIsEmpty());
		printTest("noneToOne_addToRearList_testSize",
				noneToOne_addToRearList_testSize());
		printTest("noneToOne_addToRearList_testIterator",
				noneToOne_addToRearList_testIterator());
		printTest("noneToOne_addToRearList_testToString",
				noneToOne_addToRearList_testToString());

		printTest("noneToOne_addToRearList_testAddAtIndex",
				noneToOne_addToRearList_testAddAtIndex());
		printTest("noneToOne_addToRearList_testAddAtIndex_IndexOutOfBounds",
				noneToOne_addToRearList_testAddAtIndex_IndexOutOfBounds());
		printTest("noneToOne_addToRearList_testSet",
				noneToOne_addToRearList_testSet());
		printTest("noneToOne_addToRearList_testSet_IndexOutOfBounds",
				noneToOne_addToRearList_testSet_IndexOutOfBounds());
		printTest("noneToOne_addToRearList_testAdd",
				noneToOne_addToRearList_testAdd());
		printTest("noneToOne_addToRearList_testGet",
				noneToOne_addToRearList_testGet());
		printTest("noneToOne_addToRearList_testGet_IndexOutOfBounds",
				noneToOne_addToRearList_testGet_IndexOutOfBounds());
		printTest("noneToOne_addToRearList_testIndexOf",
				noneToOne_addToRearList_testIndexOf());
		printTest("noneToOne_addToRearList_testIndexOf_ElementNotFound",
				noneToOne_addToRearList_testIndexOf_ElementNotFound());

		// TESTS ON A LIST WITH ONE ELEMENT THAT IS REMOVED FROM THE FRONT
		printTest("oneToNone_removeFirstList_testAddToFront",
				oneToNone_removeFirstList_testAddToFront());
		printTest("oneToNone_removeFirstList_testAddToRear",
				oneToNone_removeFirstList_testAddToRear());
		printTest("oneToNone_removeFirstList_testAddAfter",
				oneToNone_removeFirstList_testAddAfter());
		printTest("oneToNone_removeFirstList_testRemoveFirst",
				oneToNone_removeFirstList_testRemoveFirst());
		printTest("oneToNone_removeFirstList_testRemoveLast",
				oneToNone_removeFirstList_testRemoveLast());
		printTest("oneToNone_removeFirstList_testRemoveElement",
				oneToNone_removeFirstList_testRemoveElement());
		printTest("oneToNone_removeFirstList_testFirst",
				oneToNone_removeFirstList_testFirst());
		printTest("oneToNone_removeFirstList_testLast",
				oneToNone_removeFirstList_testLast());
		printTest("oneToNone_removeFirstList_testContains",
				oneToNone_removeFirstList_testContains());
		printTest("oneToNone_removeFirstList_testIsEmpty",
				oneToNone_removeFirstList_testIsEmpty());
		printTest("oneToNone_removeFirstList_testSize",
				oneToNone_removeFirstList_testSize());
		printTest("oneToNone_removeFirstList_testIterator",
				oneToNone_removeFirstList_testIterator());
		printTest("oneToNone_removeFirstList_testToString",
				oneToNone_removeFirstList_testToString());

		printTest("oneToNone_removeFirstList_testAddAtIndex",
				oneToNone_removeFirstList_testAddAtIndex());
		printTest("oneToNone_removeFirstList_testSet",
				oneToNone_removeFirstList_testSet());
		printTest("oneToNone_removeFirstList_testAdd",
				oneToNone_removeFirstList_testAdd());
		printTest("oneToNone_removeFirstList_testGet",
				oneToNone_removeFirstList_testGet());
		printTest("oneToNone_removeFirstList_testIndexOf",
				oneToNone_removeFirstList_testIndexOf());
		printTest("oneToNone_removeFirstList_testRemove",
				oneToNone_removeFirstList_testRemove());

		// TESTS ON A LIST WITH ONE ELEMENT THAT IS REMOVED FROM THE REAR
		printTest("oneToNone_removeLastList_testAddToFront",
				oneToNone_removeLastList_testAddToFront());
		printTest("oneToNone_removeLastList_testAddToRear",
				oneToNone_removeLastList_testAddToRear());
		printTest("oneToNone_removeLastList_testAddAfter",
				oneToNone_removeLastList_testAddAfter());
		printTest("oneToNone_removeLastList_testRemoveFirst",
				oneToNone_removeLastList_testRemoveFirst());
		printTest("oneToNone_removeLastList_testRemoveLast",
				oneToNone_removeLastList_testRemoveLast());
		printTest("oneToNone_removeLastList_testRemoveElement",
				oneToNone_removeLastList_testRemoveElement());
		printTest("oneToNone_removeLastList_testFirst",
				oneToNone_removeLastList_testFirst());
		printTest("oneToNone_removeLastList_testLast",
				oneToNone_removeLastList_testLast());
		printTest("oneToNone_removeLastList_testContains",
				oneToNone_removeLastList_testContains());
		printTest("oneToNone_removeLastList_testIsEmpty",
				oneToNone_removeLastList_testIsEmpty());
		printTest("oneToNone_removeLastList_testSize",
				oneToNone_removeLastList_testSize());
		printTest("oneToNone_removeLastList_testIterator",
				oneToNone_removeLastList_testIterator());
		printTest("oneToNone_removeLastList_testToString",
				oneToNone_removeLastList_testToString());

		printTest("oneToNone_removeLastList_testAddAtIndex",
				oneToNone_removeLastList_testAddAtIndex());
		printTest("oneToNone_removeLastList_testSet",
				oneToNone_removeLastList_testSet());
		printTest("oneToNone_removeLastList_testAdd",
				oneToNone_removeLastList_testAdd());
		printTest("oneToNone_removeLastList_testGet",
				oneToNone_removeLastList_testGet());
		printTest("oneToNone_removeLastList_testIndexOf",
				oneToNone_removeLastList_testIndexOf());
		printTest("oneToNone_removeLastList_testRemove",
				oneToNone_removeLastList_testRemove());

		// TESTS ON A LIST WITH ONE TARGET ELEMENT REMOVED, LEAVING EMPTY LIST
		printTest("oneToNone_removeElementList_testAddToFront",
				oneToNone_removeElementList_testAddToFront());
		printTest("oneToNone_removeElementList_testAddToRear",
				oneToNone_removeElementList_testAddToRear());
		printTest("oneToNone_removeElementList_testAddAfter",
				oneToNone_removeElementList_testAddAfter());
		printTest("oneToNone_removeElementList_testRemoveFirst",
				oneToNone_removeElementList_testRemoveFirst());
		printTest("oneToNone_removeElementList_testRemoveLast",
				oneToNone_removeElementList_testRemoveLast());
		printTest("oneToNone_removeElementList_testRemoveElement",
				oneToNone_removeElementList_testRemoveElement());
		printTest("oneToNone_removeElementList_testFirst",
				oneToNone_removeElementList_testFirst());
		printTest("oneToNone_removeElementList_testLast",
				oneToNone_removeElementList_testLast());
		printTest("oneToNone_removeElementList_testContains",
				oneToNone_removeElementList_testContains());
		printTest("oneToNone_removeElementList_testIsEmpty",
				oneToNone_removeElementList_testIsEmpty());
		printTest("oneToNone_removeElementList_testSize",
				oneToNone_removeElementList_testSize());
		printTest("oneToNone_removeElementList_testIterator",
				oneToNone_removeElementList_testIterator());
		printTest("oneToNone_removeElementList_testToString",
				oneToNone_removeElementList_testToString());

		printTest("oneToNone_removeElementList_testAddAtIndex",
				oneToNone_removeElementList_testAddAtIndex());
		printTest("oneToNone_removeElementList_testSet",
				oneToNone_removeElementList_testSet());
		printTest("oneToNone_removeElementList_testAdd",
				oneToNone_removeElementList_testAdd());
		printTest("oneToNone_removeElementList_testGet",
				oneToNone_removeElementList_testGet());
		printTest("oneToNone_removeElementList_testIndexOf",
				oneToNone_removeElementList_testIndexOf());
		printTest("oneToNone_removeElementList_testRemove",
				oneToNone_removeElementList_testRemove());

		// TESTS ON ONE ELEMENT LIST WITH AN ELEMENT ADDED TO THE FRONT
		printTest("oneToTwo_addToFrontList_testAddAfter",
				oneToTwo_addToFrontList_testAddAfter());
		printTest("oneToTwo_addToFrontList_testAddAfter2",
				oneToTwo_addToFrontList_testAddAfter2());
		printTest("oneToTwo_addToFrontList_testAddAfter_ElementNotFound",
				oneToTwo_addToFrontList_testAddAfter_ElementNotFound());
		printTest("oneToTwo_addToFrontList_testRemoveFirst",
				oneToTwo_addToFrontList_testRemoveFirst());
		printTest("oneToTwo_addToFrontList_testRemoveLast",
				oneToTwo_addToFrontList_testRemoveLast());
		printTest("oneToTwo_addToFrontList_testRemove",
				oneToTwo_addToFrontList_testRemove());
		printTest("oneToTwo_addToFrontList_testRemove2",
				oneToTwo_addToFrontList_testRemove2());
		printTest("oneToTwo_addToFrontList_testRemove_ElementNotFound",
				oneToTwo_addToFrontList_testRemove_ElementNotFound());
		printTest("oneToTwo_addToFrontList_testFirst",
				oneToTwo_addToFrontList_testFirst());
		printTest("oneToTwo_addToFrontList_testLast",
				oneToTwo_addToFrontList_testLast());
		printTest("oneToTwo_addToFrontList_testContains",
				oneToTwo_addToFrontList_testContains());
		printTest("oneToTwo_addToFrontList_testContains_false",
				oneToTwo_addToFrontList_testContains_false());
		printTest("oneToTwo_addToFrontList_testIsEmpty",
				oneToTwo_addToFrontList_testIsEmpty());
		printTest("oneToTwo_addToFrontList_testSize",
				oneToTwo_addToFrontList_testSize());
		printTest("oneToTwo_addToFrontList_testIterator",
				oneToTwo_addToFrontList_testIterator());
		printTest("oneToTwo_addToFrontList_testToString",
				oneToTwo_addToFrontList_testToString());

		printTest("oneToTwo_addToFrontList_testAddAtIndex",
				oneToTwo_addToFrontList_testAddAtIndex());
		printTest("oneToTwo_addToFrontList_testAddAtIndex_IndexOutOfBounds",
				oneToTwo_addToFrontList_testAddAtIndex_IndexOutOfBounds());
		printTest("oneToTwo_addToFrontList_testSet",
				oneToTwo_addToFrontList_testSet());
		printTest("oneToTwo_addToFrontList_testSet_IndexOutOfBounds",
				oneToTwo_addToFrontList_testSet_IndexOutOfBounds());
		printTest("oneToTwo_addToFrontList_testAdd",
				oneToTwo_addToFrontList_testAdd());
		printTest("oneToTwo_addToFrontList_testGet",
				oneToTwo_addToFrontList_testGet());
		printTest("oneToTwo_addToFrontList_testGet_IndexOutOfBounds",
				oneToTwo_addToFrontList_testGet_IndexOutOfBounds());
		printTest("oneToTwo_addToFrontList_testIndexOf",
				oneToTwo_addToFrontList_testIndexOf());
		printTest("oneToTwo_addToFrontList_testIndexOf_ElementNotFound",
				oneToTwo_addToFrontList_testIndexOf_ElementNotFound());

		// TESTS ON ONE ELEMENT LIST WITH ANOTHER ELEMENT ADDED AFTER THE
		// ORIGINAL
		printTest("oneToTwo_addAfterOneList_testAddAfter_ElementNotFound",
				oneToTwo_addAfterOneList_testAddAfter_ElementNotFound());
		printTest("oneToTwo_addAfterOneList_testRemoveFirst",
				oneToTwo_addAfterOneList_testRemoveFirst());
		printTest("oneToTwo_addAfterOneList_testRemoveLast",
				oneToTwo_addAfterOneList_testRemoveLast());
		printTest("oneToTwo_addAfterOneList_testContains",
				oneToTwo_addAfterOneList_testContains());
		printTest("oneToTwo_addAfterOneList_testIsEmpty",
				oneToTwo_addAfterOneList_testIsEmpty());
		printTest("oneToTwo_addAfterOneList_testSize",
				oneToTwo_addAfterOneList_testSize());

		printTest("oneToTwo_addAfterOneList_testAddAtIndex",
				oneToTwo_addAfterOneList_testAddAtIndex());
		printTest("oneToTwo_addAfterOneList_testAddAtIndex_IndexOutOfBounds",
				oneToTwo_addAfterOneList_testAddAtIndex_IndexOutOfBounds());
		printTest("oneToTwo_addAfterOneList_testSet",
				oneToTwo_addAfterOneList_testSet());
		printTest("oneToTwo_addAfterOneList_testSet_IndexOutOfBounds",
				oneToTwo_addAfterOneList_testSet_IndexOutOfBounds());
		printTest("oneToTwo_addAfterOneList_testAdd",
				oneToTwo_addAfterOneList_testAdd());
		printTest("oneToTwo_addAfterOneList_testGet",
				oneToTwo_addAfterOneList_testGet());
		printTest("oneToTwo_addAfterOneList_testGet_IndexOutOfBounds",
				oneToTwo_addAfterOneList_testGet_IndexOutOfBounds());
		printTest("oneToTwo_addAfterOneList_testIndexOf",
				oneToTwo_addAfterOneList_testIndexOf());
		printTest("oneToTwo_addAfterOneList_testIndexOf_ElementNotFound",
				oneToTwo_addAfterOneList_testIndexOf_ElementNotFound());

		// TESTS ON TWO ELEMENT LIST WITH THE FIRST REMOVED
		printTest("twoToOne_removeFirstList_testRemoveFirst",
				twoToOne_removeFirstList_testRemoveFirst());
		printTest("twoToOne_removeFirstList_testRemoveLast",
				twoToOne_removeFirstList_testRemoveLast());
		printTest("twoToOne_removeFirstList_testContains",
				twoToOne_removeFirstList_testContains());
		printTest("twoToOne_removeFirstList_testSize",
				twoToOne_removeFirstList_testSize());

		printTest("twoToOne_removeFirstList_testAddAtIndex",
				twoToOne_removeFirstList_testAddAtIndex());
		printTest("twoToOne_removeFirstList_testAddAtIndex_IndexOutOfBounds",
				twoToOne_removeFirstList_testAddAtIndex_IndexOutOfBounds());
		printTest("twoToOne_removeFirstList_testSet",
				twoToOne_removeFirstList_testSet());
		printTest("twoToOne_removeFirstList_testSet_IndexOutOfBounds",
				twoToOne_removeFirstList_testSet_IndexOutOfBounds());
		printTest("twoToOne_removeFirstList_testAdd",
				twoToOne_removeFirstList_testAdd());
		printTest("twoToOne_removeFirstList_testGet",
				twoToOne_removeFirstList_testGet());
		printTest("twoToOne_removeFirstList_testGet_IndexOutOfBounds",
				twoToOne_removeFirstList_testGet_IndexOutOfBounds());
		printTest("twoToOne_removeFirstList_testIndexOf",
				twoToOne_removeFirstList_testIndexOf());
		printTest("twoToOne_removeFirstList_testIndexOf_ElementNotFound",
				twoToOne_removeFirstList_testIndexOf_ElementNotFound());

		// TESTS ON TWO ELEMENT LIST WITH THE TARGET ELEMENT (first) REMOVED
		printTest("twoToOne_removeElementList_testRemoveFirst",
				twoToOne_removeElementList_testRemoveFirst());
		printTest("twoToOne_removeElementList_testRemoveLast",
				twoToOne_removeElementList_testRemoveLast());
		printTest("twoToOne_removeElementList_testContains",
				twoToOne_removeElementList_testContains());
		printTest("twoToOne_removeElementList_testSize",
				twoToOne_removeElementList_testSize());

		printTest("twoToOne_removeElementList_testAddAtIndex",
				twoToOne_removeElementList_testAddAtIndex());
		printTest("twoToOne_removeElementList_testAddAtIndex_IndexOutOfBounds",
				twoToOne_removeElementList_testAddAtIndex_IndexOutOfBounds());
		printTest("twoToOne_removeElementList_testSet",
				twoToOne_removeElementList_testSet());
		printTest("twoToOne_removeElementList_testSet_IndexOutOfBounds",
				twoToOne_removeElementList_testSet_IndexOutOfBounds());
		printTest("twoToOne_removeElementList_testAdd",
				twoToOne_removeElementList_testAdd());
		printTest("twoToOne_removeElementList_testGet",
				twoToOne_removeElementList_testGet());
		printTest("twoToOne_removeElementList_testGet_IndexOutOfBounds",
				twoToOne_removeElementList_testGet_IndexOutOfBounds());
		printTest("twoToOne_removeElementList_testIndexOf",
				twoToOne_removeElementList_testIndexOf());
		printTest("twoToOne_removeElementList_testIndexOf_ElementNotFound",
				twoToOne_removeElementList_testIndexOf_ElementNotFound());

		// TESTS ON TWO ELEMENT LIST WITH THE THIRD ELEMENT ADDED TO REAR
		printTest("twoToThree_addToRearList_testRemoveFirst",
				twoToThree_addToRearList_testRemoveFirst());
		printTest("twoToThree_addToRearList_testRemoveLast",
				twoToThree_addToRearList_testRemoveLast());
		printTest("twoToThree_addToRearList_testContains",
				twoToThree_addToRearList_testContains());
		printTest("twoToThree_addToRearList_testSize",
				twoToThree_addToRearList_testSize());

		printTest("twoToThree_addToRearList_testAddAtIndex",
				twoToThree_addToRearList_testAddAtIndex());
		printTest("twoToThree_addToRearList_testAddAtIndex_IndexOutOfBounds",
				twoToThree_addToRearList_testAddAtIndex_IndexOutOfBounds());
		printTest("twoToThree_addToRearList_testSet",
				twoToThree_addToRearList_testSet());
		printTest("twoToThree_addToRearList_testSet_IndexOutOfBounds",
				twoToThree_addToRearList_testSet_IndexOutOfBounds());
		printTest("twoToThree_addToRearList_testAdd",
				twoToThree_addToRearList_testAdd());
		printTest("twoToThree_addToRearList_testGet",
				twoToThree_addToRearList_testGet());
		printTest("twoToThree_addToRearList_testGet_IndexOutOfBounds",
				twoToThree_addToRearList_testGet_IndexOutOfBounds());
		printTest("twoToThree_addToRearList_testIndexOf",
				twoToThree_addToRearList_testIndexOf());
		printTest("twoToThree_addToRearList_testIndexOf_ElementNotFound",
				twoToThree_addToRearList_testIndexOf_ElementNotFound());

		// TESTS ON TWO ELEMENT LIST WITH THE THIRD ELEMENT ADDED TO MIDDLE
		printTest("twoToThree_addAfterFirstList_testRemoveFirst",
				twoToThree_addAfterFirstList_testRemoveFirst());
		printTest("twoToThree_addAfterFirstList_testRemoveLast",
				twoToThree_addAfterFirstList_testRemoveLast());
		printTest("twoToThree_addAfterFirstList_testContains",
				twoToThree_addAfterFirstList_testContains());
		printTest("twoToThree_addAfterFirstList_testSize",
				twoToThree_addAfterFirstList_testSize());

		printTest("twoToThree_addAfterFirstList_testAddAtIndex",
				twoToThree_addAfterFirstList_testAddAtIndex());
		printTest(
				"twoToThree_addAfterFirstList_testAddAtIndex_IndexOutOfBounds",
				twoToThree_addAfterFirstList_testAddAtIndex_IndexOutOfBounds());
		printTest("twoToThree_addAfterFirstList_testSet",
				twoToThree_addAfterFirstList_testSet());
		printTest("twoToThree_addAfterFirstList_testSet_IndexOutOfBounds",
				twoToThree_addAfterFirstList_testSet_IndexOutOfBounds());
		printTest("twoToThree_addAfterFirstList_testAdd",
				twoToThree_addAfterFirstList_testAdd());
		printTest("twoToThree_addAfterFirstList_testGet",
				twoToThree_addAfterFirstList_testGet());
		printTest("twoToThree_addAfterFirstList_testGet_IndexOutOfBounds",
				twoToThree_addAfterFirstList_testGet_IndexOutOfBounds());
		printTest("twoToThree_addAfterFirstList_testIndexOf",
				twoToThree_addAfterFirstList_testIndexOf());
		printTest("twoToThree_addAfterFirstList_testIndexOf_ElementNotFound",
				twoToThree_addAfterFirstList_testIndexOf_ElementNotFound());

		// TESTS ON THREE ELEMENT LIST WITH THE FIRST REMOVED
		printTest("threeToTwo_removeFirstList_testRemoveFirst",
				threeToTwo_removeFirstList_testRemoveFirst());
		printTest("threeToTwo_removeFirstList_testRemoveLast",
				threeToTwo_removeFirstList_testRemoveLast());
		printTest("threeToTwo_removeFirstList_testContains",
				threeToTwo_removeFirstList_testContains());
		printTest("threeToTwo_removeFirstList_testSize",
				threeToTwo_removeFirstList_testSize());

		// TESTS ON AN EMPTY LIST WITH ONE ELEMENT ADD
		printTest("noneToOne_addList_testAddToFront",
				noneToOne_addList_testAddToFront());
		printTest("noneToOne_addList_testAddToRear",
				noneToOne_addList_testAddToRear());
		printTest("noneToOne_addList_testAddAfter",
				noneToOne_addList_testAddAfter());
		printTest("noneToOne_addList_testAddAfter_ElementNotFound",
				noneToOne_addList_testAddAfter_ElementNotFound());
		printTest("noneToOne_addList_testRemoveFirst",
				noneToOne_addList_testRemoveFirst());
		printTest("noneToOne_addList_testRemoveLast",
				noneToOne_addList_testRemoveLast());
		printTest("noneToOne_addList_testRemove",
				noneToOne_addList_testRemove());
		printTest("noneToOne_addList_testRemove_ElementNotFound",
				noneToOne_addList_testRemove_ElementNotFound());
		printTest("noneToOne_addList_testFirst", noneToOne_addList_testFirst());
		printTest("noneToOne_addList_testLast", noneToOne_addList_testLast());
		printTest("noneToOne_addList_testContains",
				noneToOne_addList_testContains());
		printTest("noneToOne_addList_testContains_false",
				noneToOne_addList_testContains_false());
		printTest("noneToOne_addList_testIsEmpty",
				noneToOne_addList_testIsEmpty());
		printTest("noneToOne_addList_testSize", noneToOne_addList_testSize());
		printTest("noneToOne_addList_testIterator",
				noneToOne_addList_testIterator());
		printTest("noneToOne_addList_testToString",
				noneToOne_addList_testToString());

		printTest("noneToOne_addList_testAddAtIndex",
				noneToOne_addList_testAddAtIndex());
		printTest("noneToOne_addList_testAddAtIndex_IndexOutOfBounds",
				noneToOne_addList_testAddAtIndex_IndexOutOfBounds());
		printTest("noneToOne_addList_testSet", noneToOne_addList_testSet());
		printTest("noneToOne_addList_testSet_IndexOutOfBounds",
				noneToOne_addList_testSet_IndexOutOfBounds());
		printTest("noneToOne_addList_testAdd", noneToOne_addList_testAdd());
		printTest("noneToOne_addList_testGet", noneToOne_addList_testGet());
		printTest("noneToOne_addList_testGet_IndexOutOfBounds",
				noneToOne_addList_testGet_IndexOutOfBounds());
		printTest("noneToOne_addList_testIndexOf",
				noneToOne_addList_testIndexOf());
		printTest("noneToOne_addList_testIndexOf_ElementNotFound",
				noneToOne_addList_testIndexOf_ElementNotFound());

		// TESTS ON EMPTY LIST WITH ONE ELEMENT ADDED AT INDEX 0
		printTest("noneToOne_addAtIndexZeroList_testAddToFront",
				noneToOne_addAtIndexZeroList_testAddToFront());
		printTest("noneToOne_addAtIndexZeroList_testAddToRear",
				noneToOne_addAtIndexZeroList_testAddToRear());
		printTest("noneToOne_addAtIndexZeroList_testAddAfter",
				noneToOne_addAtIndexZeroList_testAddAfter());
		printTest("noneToOne_addAtIndexZeroList_testAddAfter_ElementNotFound",
				noneToOne_addAtIndexZeroList_testAddAfter_ElementNotFound());
		printTest("noneToOne_addAtIndexZeroList_testRemoveFirst",
				noneToOne_addAtIndexZeroList_testRemoveFirst());
		printTest("noneToOne_addAtIndexZeroList_testRemoveLast",
				noneToOne_addAtIndexZeroList_testRemoveLast());
		printTest("noneToOne_addAtIndexZeroList_testRemove",
				noneToOne_addAtIndexZeroList_testRemove());
		printTest("noneToOne_addAtIndexZeroList_testRemove_ElementNotFound",
				noneToOne_addAtIndexZeroList_testRemove_ElementNotFound());
		printTest("noneToOne_addAtIndexZeroList_testFirst",
				noneToOne_addAtIndexZeroList_testFirst());
		printTest("noneToOne_addAtIndexZeroList_testLast",
				noneToOne_addAtIndexZeroList_testLast());
		printTest("noneToOne_addAtIndexZeroList_testContains",
				noneToOne_addAtIndexZeroList_testContains());
		printTest("noneToOne_addAtIndexZeroList_testContains_false",
				noneToOne_addAtIndexZeroList_testContains_false());
		printTest("noneToOne_addAtIndexZeroList_testIsEmpty",
				noneToOne_addAtIndexZeroList_testIsEmpty());
		printTest("noneToOne_addAtIndexZeroList_testSize",
				noneToOne_addAtIndexZeroList_testSize());
		printTest("noneToOne_addAtIndexZeroList_testIterator",
				noneToOne_addAtIndexZeroList_testIterator());
		printTest("noneToOne_addAtIndexZeroList_testToString",
				noneToOne_addAtIndexZeroList_testToString());

		printTest("noneToOne_addAtIndexZeroList_testAddAtIndex",
				noneToOne_addAtIndexZeroList_testAddAtIndex());
		printTest(
				"noneToOne_addAtIndexZeroList_testAddAtIndex_IndexOutOfBounds",
				noneToOne_addAtIndexZeroList_testAddAtIndex_IndexOutOfBounds());
		printTest("noneToOne_addAtIndexZeroList_testSet",
				noneToOne_addAtIndexZeroList_testSet());
		printTest("noneToOne_addAtIndexZeroList_testSet_IndexOutOfBounds",
				noneToOne_addAtIndexZeroList_testSet_IndexOutOfBounds());
		printTest("noneToOne_addAtIndexZeroList_testAdd",
				noneToOne_addAtIndexZeroList_testAdd());
		printTest("noneToOne_addAtIndexZeroList_testGet",
				noneToOne_addAtIndexZeroList_testGet());
		printTest("noneToOne_addAtIndexZeroList_testGet_IndexOutOfBounds",
				noneToOne_addAtIndexZeroList_testGet_IndexOutOfBounds());
		printTest("noneToOne_addAtIndexZeroList_testIndexOf",
				noneToOne_addAtIndexZeroList_testIndexOf());
		printTest("noneToOne_addAtIndexZeroList_testIndexOf_ElementNotFound",
				noneToOne_addAtIndexZeroList_testIndexOf_ElementNotFound());

		// TESTS ON ONE ELEMENT LIST WITH INDEX 0 REMOVED
		printTest("oneToNone_removeIndexZeroList_testAddToFront",
				oneToNone_removeIndexZeroList_testAddToFront());
		printTest("oneToNone_removeIndexZeroList_testAddToRear",
				oneToNone_removeIndexZeroList_testAddToRear());
		printTest("oneToNone_removeIndexZeroList_testAddAfter",
				oneToNone_removeIndexZeroList_testAddAfter());
		printTest("oneToNone_removeIndexZeroList_testRemoveFirst",
				oneToNone_removeIndexZeroList_testRemoveFirst());
		printTest("oneToNone_removeIndexZeroList_testRemoveLast",
				oneToNone_removeIndexZeroList_testRemoveLast());
		printTest("oneToNone_removeIndexZeroList_testRemoveElement",
				oneToNone_removeIndexZeroList_testRemoveElement());
		printTest("oneToNone_removeIndexZeroList_testFirst",
				oneToNone_removeIndexZeroList_testFirst());
		printTest("oneToNone_removeIndexZeroList_testLast",
				oneToNone_removeIndexZeroList_testLast());
		printTest("oneToNone_removeIndexZeroList_testContains",
				oneToNone_removeIndexZeroList_testContains());
		printTest("oneToNone_removeIndexZeroList_testIsEmpty",
				oneToNone_removeIndexZeroList_testIsEmpty());
		printTest("oneToNone_removeIndexZeroList_testSize",
				oneToNone_removeIndexZeroList_testSize());
		printTest("oneToNone_removeIndexZeroList_testIterator",
				oneToNone_removeIndexZeroList_testIterator());
		printTest("oneToNone_removeIndexZeroList_testToString",
				oneToNone_removeIndexZeroList_testToString());

		printTest("oneToNone_removeIndexZeroList_testAddAtIndex",
				oneToNone_removeIndexZeroList_testAddAtIndex());
		printTest("oneToNone_removeIndexZeroList_testSet",
				oneToNone_removeIndexZeroList_testSet());
		printTest("oneToNone_removeIndexZeroList_testAdd",
				oneToNone_removeIndexZeroList_testAdd());
		printTest("oneToNone_removeIndexZeroList_testGet",
				oneToNone_removeIndexZeroList_testGet());
		printTest("oneToNone_removeIndexZeroList_testIndexOf",
				oneToNone_removeIndexZeroList_testIndexOf());
		printTest("oneToNone_removeIndexZeroList_testRemove",
				oneToNone_removeIndexZeroList_testRemove());

		// TESTS ON TWO ELEMENT LIST WITH THE FIRST REMOVED
		printTest("oneToDiffOne_setIndexZeroList_testRemoveFirst",
				oneToDiffOne_setIndexZeroList_testRemoveFirst());
		printTest("oneToDiffOne_setIndexZeroList_testRemoveLast",
				oneToDiffOne_setIndexZeroList_testRemoveLast());
		printTest("oneToDiffOne_setIndexZeroList_testContains",
				oneToDiffOne_setIndexZeroList_testContains());
		printTest("oneToDiffOne_setIndexZeroList_testSize",
				oneToDiffOne_setIndexZeroList_testSize());

		printTest("oneToDiffOne_setIndexZeroList_testAddAtIndex",
				oneToDiffOne_setIndexZeroList_testAddAtIndex());
		printTest(
				"oneToDiffOne_setIndexZeroList_testAddAtIndex_IndexOutOfBounds",
				oneToDiffOne_setIndexZeroList_testAddAtIndex_IndexOutOfBounds());
		printTest("oneToDiffOne_setIndexZeroList_testSet",
				oneToDiffOne_setIndexZeroList_testSet());
		printTest("oneToDiffOne_setIndexZeroList_testSet_IndexOutOfBounds",
				oneToDiffOne_setIndexZeroList_testSet_IndexOutOfBounds());
		printTest("oneToDiffOne_setIndexZeroList_testAdd",
				oneToDiffOne_setIndexZeroList_testAdd());
		printTest("oneToDiffOne_setIndexZeroList_testGet",
				oneToDiffOne_setIndexZeroList_testGet());
		printTest("oneToDiffOne_setIndexZeroList_testGet_IndexOutOfBounds",
				oneToDiffOne_setIndexZeroList_testGet_IndexOutOfBounds());
		printTest("oneToDiffOne_setIndexZeroList_testIndexOf",
				oneToDiffOne_setIndexZeroList_testIndexOf());
		printTest("oneToDiffOne_setIndexZeroList_testIndexOf_ElementNotFound",
				oneToDiffOne_setIndexZeroList_testIndexOf_ElementNotFound());

		// TESTS ON ONE ELEMENT LIST WITH ANOTHER ELEMENT ADDED AT INDEX 1
		printTest("oneToTwo_addAtIndexOneList_testAddAfter_ElementNotFound",
				oneToTwo_addAtIndexOneList_testAddAfter_ElementNotFound());
		printTest("oneToTwo_addAtIndexOneList_testRemoveFirst",
				oneToTwo_addAtIndexOneList_testRemoveFirst());
		printTest("oneToTwo_addAtIndexOneList_testRemoveLast",
				oneToTwo_addAtIndexOneList_testRemoveLast());
		printTest("oneToTwo_addAtIndexOneList_testContains",
				oneToTwo_addAtIndexOneList_testContains());
		printTest("oneToTwo_addAtIndexOneList_testIsEmpty",
				oneToTwo_addAtIndexOneList_testIsEmpty());
		printTest("oneToTwo_addAtIndexOneList_testSize",
				oneToTwo_addAtIndexOneList_testSize());

		printTest("oneToTwo_addAtIndexOneList_testAddAtIndex",
				oneToTwo_addAtIndexOneList_testAddAtIndex());
		printTest("oneToTwo_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds",
				oneToTwo_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds());
		printTest("oneToTwo_addAtIndexOneList_testSet",
				oneToTwo_addAtIndexOneList_testSet());
		printTest("oneToTwo_addAtIndexOneList_testSet_IndexOutOfBounds",
				oneToTwo_addAtIndexOneList_testSet_IndexOutOfBounds());
		printTest("oneToTwo_addAtIndexOneList_testAdd",
				oneToTwo_addAtIndexOneList_testAdd());
		printTest("oneToTwo_addAtIndexOneList_testGet",
				oneToTwo_addAtIndexOneList_testGet());
		printTest("oneToTwo_addAtIndexOneList_testGet_IndexOutOfBounds",
				oneToTwo_addAtIndexOneList_testGet_IndexOutOfBounds());
		printTest("oneToTwo_addAtIndexOneList_testIndexOf",
				oneToTwo_addAtIndexOneList_testIndexOf());
		printTest("oneToTwo_addAtIndexOneList_testIndexOf_ElementNotFound",
				oneToTwo_addAtIndexOneList_testIndexOf_ElementNotFound());

		// TESTS ON 2 ELEMENT LIST WITH INDEX 1 REMOVED
		printTest("twoToOne_removeIndexOneList_testAddToFront",
				twoToOne_removeIndexOneList_testAddToFront());
		printTest("twoToOne_removeIndexOneList_testAddToRear",
				twoToOne_removeIndexOneList_testAddToRear());
		printTest("twoToOne_removeIndexOneList_testAddAfter",
				twoToOne_removeIndexOneList_testAddAfter());
		printTest("twoToOne_removeIndexOneList_testAddAfter_ElementNotFound",
				twoToOne_removeIndexOneList_testAddAfter_ElementNotFound());
		printTest("twoToOne_removeIndexOneList_testRemoveFirst",
				twoToOne_removeIndexOneList_testRemoveFirst());
		printTest("twoToOne_removeIndexOneList_testRemoveLast",
				twoToOne_removeIndexOneList_testRemoveLast());
		printTest("twoToOne_removeIndexOneList_testRemove",
				twoToOne_removeIndexOneList_testRemove());
		printTest("twoToOne_removeIndexOneList_testRemove_ElementNotFound",
				twoToOne_removeIndexOneList_testRemove_ElementNotFound());
		printTest("twoToOne_removeIndexOneList_testFirst",
				twoToOne_removeIndexOneList_testFirst());
		printTest("twoToOne_removeIndexOneList_testLast",
				twoToOne_removeIndexOneList_testLast());
		printTest("twoToOne_removeIndexOneList_testContains",
				twoToOne_removeIndexOneList_testContains());
		printTest("twoToOne_removeIndexOneList_testContains_false",
				twoToOne_removeIndexOneList_testContains_false());
		printTest("twoToOne_removeIndexOneList_testIsEmpty",
				twoToOne_removeIndexOneList_testIsEmpty());
		printTest("twoToOne_removeIndexOneList_testSize",
				twoToOne_removeIndexOneList_testSize());
		printTest("twoToOne_removeIndexOneList_testIterator",
				twoToOne_removeIndexOneList_testIterator());
		printTest("twoToOne_removeIndexOneList_testToString",
				twoToOne_removeIndexOneList_testToString());

		printTest("twoToOne_removeIndexOneList_testAddAtIndex",
				twoToOne_removeIndexOneList_testAddAtIndex());
		printTest(
				"twoToOne_removeIndexOneList_testAddAtIndex_IndexOutOfBounds",
				twoToOne_removeIndexOneList_testAddAtIndex_IndexOutOfBounds());
		printTest("twoToOne_removeIndexOneList_testSet",
				twoToOne_removeIndexOneList_testSet());
		printTest("twoToOne_removeIndexOneList_testSet_IndexOutOfBounds",
				twoToOne_removeIndexOneList_testSet_IndexOutOfBounds());
		printTest("twoToOne_removeIndexOneList_testAdd",
				twoToOne_removeIndexOneList_testAdd());
		printTest("twoToOne_removeIndexOneList_testGet",
				twoToOne_removeIndexOneList_testGet());
		printTest("twoToOne_removeIndexOneList_testGet_IndexOutOfBounds",
				twoToOne_removeIndexOneList_testGet_IndexOutOfBounds());
		printTest("twoToOne_removeIndexOneList_testIndexOf",
				twoToOne_removeIndexOneList_testIndexOf());
		printTest("twoToOne_removeIndexOneList_testIndexOf_ElementNotFound",
				twoToOne_removeIndexOneList_testIndexOf_ElementNotFound());

		// TESTS ON 2 ELEMENT LIST WITH A THIRD ADDED AT INDEX 1
		printTest("twoToThree_addAtIndexOneList_testAddToFront",
				twoToThree_addAtIndexOneList_testAddToFront());
		printTest("twoToThree_addAtIndexOneList_testAddToRear",
				twoToThree_addAtIndexOneList_testAddToRear());
		printTest("twoToThree_addAtIndexOneList_testAddAfter",
				twoToThree_addAtIndexOneList_testAddAfter());
		printTest("twoToThree_addAtIndexOneList_testAddAfter_ElementNotFound",
				twoToThree_addAtIndexOneList_testAddAfter_ElementNotFound());
		printTest("twoToThree_addAtIndexOneList_testRemoveFirst",
				twoToThree_addAtIndexOneList_testRemoveFirst());
		printTest("twoToThree_addAtIndexOneList_testRemoveLast",
				twoToThree_addAtIndexOneList_testRemoveLast());
		printTest("twoToThree_addAtIndexOneList_testRemove",
				twoToThree_addAtIndexOneList_testRemove());
		printTest("twoToThree_addAtIndexOneList_testRemove_ElementNotFound",
				twoToThree_addAtIndexOneList_testRemove_ElementNotFound());
		printTest("twoToThree_addAtIndexOneList_testFirst",
				twoToThree_addAtIndexOneList_testFirst());
		printTest("twoToThree_addAtIndexOneList_testLast",
				twoToThree_addAtIndexOneList_testLast());
		printTest("twoToThree_addAtIndexOneList_testContains",
				twoToThree_addAtIndexOneList_testContains());
		printTest("twoToThree_addAtIndexOneList_testContains_false",
				twoToThree_addAtIndexOneList_testContains_false());
		printTest("twoToThree_addAtIndexOneList_testIsEmpty",
				twoToThree_addAtIndexOneList_testIsEmpty());
		printTest("twoToThree_addAtIndexOneList_testSize",
				twoToThree_addAtIndexOneList_testSize());
		printTest("twoToThree_addAtIndexOneList_testIterator",
				twoToThree_addAtIndexOneList_testIterator());
		printTest("twoToThree_addAtIndexOneList_testToString",
				twoToThree_addAtIndexOneList_testToString());

		printTest("twoToThree_addAtIndexOneList_testAddAtIndex",
				twoToThree_addAtIndexOneList_testAddAtIndex());
		printTest(
				"twoToThree_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds",
				twoToThree_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds());
		printTest("twoToThree_addAtIndexOneList_testSet",
				twoToThree_addAtIndexOneList_testSet());
		printTest("twoToThree_addAtIndexOneList_testSet_IndexOutOfBounds",
				twoToThree_addAtIndexOneList_testSet_IndexOutOfBounds());
		printTest("twoToThree_addAtIndexOneList_testAdd",
				twoToThree_addAtIndexOneList_testAdd());
		printTest("twoToThree_addAtIndexOneList_testGet",
				twoToThree_addAtIndexOneList_testGet());
		printTest("twoToThree_addAtIndexOneList_testGet_IndexOutOfBounds",
				twoToThree_addAtIndexOneList_testGet_IndexOutOfBounds());
		printTest("twoToThree_addAtIndexOneList_testIndexOf",
				twoToThree_addAtIndexOneList_testIndexOf());
		printTest("twoToThree_addAtIndexOneList_testIndexOf_ElementNotFound",
				twoToThree_addAtIndexOneList_testIndexOf_ElementNotFound());

		// TESTS ON THREE ELEMENT LIST WITH INDEX 1 REMOVED
		printTest("threeToTwo_removeIndexOneList_testAddAfter_ElementNotFound",
				threeToTwo_removeIndexOneList_testAddAfter_ElementNotFound());
		printTest("threeToTwo_removeIndexOneList_testRemoveFirst",
				threeToTwo_removeIndexOneList_testRemoveFirst());
		printTest("threeToTwo_removeIndexOneList_testRemoveLast",
				threeToTwo_removeIndexOneList_testRemoveLast());
		printTest("threeToTwo_removeIndexOneList_testContains",
				threeToTwo_removeIndexOneList_testContains());
		printTest("threeToTwo_removeIndexOneList_testIsEmpty",
				threeToTwo_removeIndexOneList_testIsEmpty());
		printTest("threeToTwo_removeIndexOneList_testSize",
				threeToTwo_removeIndexOneList_testSize());

		printTest("threeToTwo_removeIndexOneList_testAddAtIndex",
				threeToTwo_removeIndexOneList_testAddAtIndex());
		printTest(
				"threeToTwo_removeIndexOneList_testAddAtIndex_IndexOutOfBounds",
				threeToTwo_removeIndexOneList_testAddAtIndex_IndexOutOfBounds());
		printTest("threeToTwo_removeIndexOneList_testSet",
				threeToTwo_removeIndexOneList_testSet());
		printTest("threeToTwo_removeIndexOneList_testSet_IndexOutOfBounds",
				threeToTwo_removeIndexOneList_testSet_IndexOutOfBounds());
		printTest("threeToTwo_removeIndexOneList_testAdd",
				threeToTwo_removeIndexOneList_testAdd());
		printTest("threeToTwo_removeIndexOneList_testGet",
				threeToTwo_removeIndexOneList_testGet());
		printTest("threeToTwo_removeIndexOneList_testGet_IndexOutOfBounds",
				threeToTwo_removeIndexOneList_testGet_IndexOutOfBounds());
		printTest("threeToTwo_removeIndexOneList_testIndexOf",
				threeToTwo_removeIndexOneList_testIndexOf());
		printTest("threeToTwo_removeIndexOneList_testIndexOf_ElementNotFound",
				threeToTwo_removeIndexOneList_testIndexOf_ElementNotFound());

		// TESTS ON 3 ELEMENT LIST WITH INDEX 1 SET TO A NEW ELEMENT
		printTest("threeToDiffThree_setIndexOneList_testAddToFront",
				threeToDiffThree_setIndexOneList_testAddToFront());
		printTest("threeToDiffThree_setIndexOneList_testAddToRear",
				threeToDiffThree_setIndexOneList_testAddToRear());
		printTest("threeToDiffThree_setIndexOneList_testAddAfter",
				threeToDiffThree_setIndexOneList_testAddAfter());
		printTest(
				"threeToDiffThree_setIndexOneList_testAddAfter_ElementNotFound",
				threeToDiffThree_setIndexOneList_testAddAfter_ElementNotFound());
		printTest("threeToDiffThree_setIndexOneList_testRemoveFirst",
				threeToDiffThree_setIndexOneList_testRemoveFirst());
		printTest("threeToDiffThree_setIndexOneList_testRemoveLast",
				threeToDiffThree_setIndexOneList_testRemoveLast());
		printTest("threeToDiffThree_setIndexOneList_testRemove",
				threeToDiffThree_setIndexOneList_testRemove());
		printTest(
				"threeToDiffThree_setIndexOneList_testRemove_ElementNotFound",
				threeToDiffThree_setIndexOneList_testRemove_ElementNotFound());
		printTest("threeToDiffThree_setIndexOneList_testFirst",
				threeToDiffThree_setIndexOneList_testFirst());
		printTest("threeToDiffThree_setIndexOneList_testLast",
				threeToDiffThree_setIndexOneList_testLast());
		printTest("threeToDiffThree_setIndexOneList_testContains",
				threeToDiffThree_setIndexOneList_testContains());
		printTest("threeToDiffThree_setIndexOneList_testContains_false",
				threeToDiffThree_setIndexOneList_testContains_false());
		printTest("threeToDiffThree_setIndexOneList_testIsEmpty",
				threeToDiffThree_setIndexOneList_testIsEmpty());
		printTest("threeToDiffThree_setIndexOneList_testSize",
				threeToDiffThree_setIndexOneList_testSize());
		printTest("threeToDiffThree_setIndexOneList_testIterator",
				threeToDiffThree_setIndexOneList_testIterator());
		printTest("threeToDiffThree_setIndexOneList_testToString",
				threeToDiffThree_setIndexOneList_testToString());

		printTest("threeToDiffThree_setIndexOneList_testAddAtIndex",
				threeToDiffThree_setIndexOneList_testAddAtIndex());
		printTest(
				"threeToDiffThree_setIndexOneList_testAddAtIndex_IndexOutOfBounds",
				threeToDiffThree_setIndexOneList_testAddAtIndex_IndexOutOfBounds());
		printTest("threeToDiffThree_setIndexOneList_testSet",
				threeToDiffThree_setIndexOneList_testSet());
		printTest("threeToDiffThree_setIndexOneList_testSet_IndexOutOfBounds",
				threeToDiffThree_setIndexOneList_testSet_IndexOutOfBounds());
		printTest("threeToDiffThree_setIndexOneList_testAdd",
				threeToDiffThree_setIndexOneList_testAdd());
		printTest("threeToDiffThree_setIndexOneList_testGet",
				threeToDiffThree_setIndexOneList_testGet());
		printTest("threeToDiffThree_setIndexOneList_testGet_IndexOutOfBounds",
				threeToDiffThree_setIndexOneList_testGet_IndexOutOfBounds());
		printTest("threeToDiffThree_setIndexOneList_testIndexOf",
				threeToDiffThree_setIndexOneList_testIndexOf());
		printTest(
				"threeToDiffThree_setIndexOneList_testIndexOf_ElementNotFound",
				threeToDiffThree_setIndexOneList_testIndexOf_ElementNotFound());

		// ---------------------------
		printTest("oneToTwo_addToFrontList_testListIteratorReference",
				oneToTwo_addToFrontList_testListIteratorReference());
		printTest("oneToTwo_addToFrontList_testListIterator",
				oneToTwo_addToFrontList_testListIterator());
		printTest("oneToTwo_addToFrontList_testListIteratorPrevious",
				oneToTwo_addToFrontList_testListIteratorPrevious());

		printTest("oneToTwo_addToFrontList_testListIteratorStart0",
				oneToTwo_addToFrontList_testListIteratorStart0());
		printTest("oneToTwo_addToFrontList_testListIteratorStart1",
				oneToTwo_addToFrontList_testListIteratorStart1());
		printTest("oneToTwo_addToFrontList_testListIteratorMix1",
				oneToTwo_addToFrontList_testListIteratorMix1());
		printTest("oneToTwo_addToFrontList_testListIteratorSet",
				oneToTwo_addToFrontList_testListIteratorSet());
		printTest("oneToTwo_addToFrontList_testListIteratorConcurrentMod",
				oneToTwo_addToFrontList_testListIteratorConcurrentMod());

		printTest("oneToTwo_addToFrontList_testListIteratorRemove",
				oneToTwo_addToFrontList_testListIteratorRemove());

		printTest("oneToTwo_addToFrontList_testListIteratorAdd",
				oneToTwo_addToFrontList_testListIteratorAdd());

		printTest("oneToTwo_addToFrontList_testListIteratorPreviousIndex",
				oneToTwo_addToFrontList_testListIteratorPreviousIndex());

		printTest("oneToTwo_addToFrontList_testListIteratorNextIndex",
				oneToTwo_addToFrontList_testListIteratorNextIndex());

		printTest("oneToTwo_addToFrontList_testListIteratorNextPrevious",
				oneToTwo_addToFrontList_testListIteratorNextPrevious());

		printTest("oneToTwo_addToFrontList_testListIteratorNext",
				oneToTwo_addToFrontList_testListIteratorNext());

		printTest(
				"oneToTwo_addToFrontList_testListIteratorPreviousNoSuchElement",
				oneToTwo_addToFrontList_testListIteratorPreviousNoSuchElement());

		printTest("oneToTwo_addToFrontList_testListIteratorHasPrevious",
				oneToTwo_addToFrontList_testListIteratorHasPrevious());

		printTest("oneToTwo_addToFrontList_testListIteratorRemoveIllegalState",
				oneToTwo_addToFrontList_testListIteratorRemoveIllegalState());

		// ///////////////
		// final verdict
		// ///////////////
		printFinalSummary();
	}

	/**
	 * Returns a DoubleLinkedlist for the "new empty list" scenario
	 *
	 * 
	 *
	 * @return a new UnorderedListADT
	 */
	private DoubleLinkedList<Integer> newList() {
		return new DoubleLinkedList<Integer>();
	}

	// List creator helper methods
	/**
	 * scenario: adds one element to the front of an empty list
	 * 
	 * @return list -list containing one element
	 */
	private DoubleLinkedList<Integer> noneToOne_addToFrontList() {
		DoubleLinkedList<Integer> list = newList();
		list.addToFront(i);
		return list;
	}

	/**
	 * scenario: adds one element to the rear of an empty list
	 * 
	 * @return list -list containing one element
	 */
	private DoubleLinkedList<Integer> noneToOne_addToRearList() {
		DoubleLinkedList<Integer> list = newList();
		list.addToRear(i);
		return list;
	}

	/**
	 * scenario: removes first element from list containing one element
	 * 
	 * @return list -an empty list
	 */
	private DoubleLinkedList<Integer> oneToNone_removeFirstList() {
		DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
		list.removeFirst();
		return list;
	}

	/**
	 * scenario: removes last element from list containing one element
	 * 
	 * @return list -an empty list
	 */
	private DoubleLinkedList<Integer> oneToNone_removeLastList() {
		DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
		list.removeLast();
		return list;
	}

	/**
	 * scenario: removes a target element from list containing one element
	 * 
	 * @return list -an empty list
	 * @throws ElementNotFoundException
	 */
	private DoubleLinkedList<Integer> oneToNone_removeElementList()
			throws ElementNotFoundException {
		DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
		list.remove(i);
		return list;
	}

	/**
	 * scenario: adds one element to front of list containing one element
	 * 
	 * @return list -list containing two elements (i2,i)
	 */
	private DoubleLinkedList<Integer> oneToTwo_addToFrontList() {
		DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
		list.addToFront(i2);
		return list;
	}

	/**
	 * scenario: adds one element after target element of a list containing one
	 * element
	 * 
	 * @return list -list containing two elements (i,i2)
	 * @throws ElementNotFoundException
	 */
	private DoubleLinkedList<Integer> oneToTwo_addAfterOneList()
			throws ElementNotFoundException {
		DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
		list.addAfter(i2, i);
		return list;
	}

	/**
	 * scenario: removes first element from list containing two elements
	 * 
	 * @return list -list containing one element (i2)
	 * @throws EmptyCollectionException
	 */
	private DoubleLinkedList<Integer> twoToOne_removeFirstList()
			throws EmptyCollectionException {
		DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
		list.removeFirst();
		return list;
	}

	/**
	 * scenario: removes target element from list containing two elements
	 * 
	 * @return list -list containing one element (i2)
	 * @throws ElementNotFoundException
	 */
	private DoubleLinkedList<Integer> twoToOne_removeElementList()
			throws ElementNotFoundException {
		DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
		list.remove(i);
		return list;
	}

	/**
	 * scenario: adds one element to rear of list containing two elements
	 * 
	 * @return list -list containing three elements (i,i2,i3)
	 */
	private DoubleLinkedList<Integer> twoToThree_addToRearList() {
		DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
		list.addToRear(i3);
		return list;
	}

	/**
	 * scenario: adds one element after first element of list containing two
	 * elements
	 * 
	 * @return list -list containing three elements (i,i3,i2)
	 * @throws ElementNotFoundException
	 */
	private DoubleLinkedList<Integer> twoToThree_addAfterFirstList()
			throws ElementNotFoundException {
		DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
		list.addAfter(i3, i);
		return list;
	}

	/**
	 * scenario: removes first element from list containing three elements
	 * 
	 * @return list -list containing two elements (i2,i3)
	 * @throws EmptyCollectionException
	 */
	private DoubleLinkedList<Integer> threeToTwo_removeFirstList()
			throws EmptyCollectionException {
		DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
		list.addToRear(i3);
		list.removeFirst();
		return list;
	}

	// --------------
	/**
	 * scenario: adds one element to empty list
	 * 
	 * @return list- list containing one element (i)
	 */
	private DoubleLinkedList<Integer> noneToOne_addList() {
		DoubleLinkedList<Integer> list = newList();
		list.add(i);
		return list;
	}

	/**
	 * scenario: adds one element to index 0 of an empty list
	 * 
	 * @return list- list containing one element (i)
	 */
	private DoubleLinkedList<Integer> noneToOne_addAtIndexZeroList() {
		DoubleLinkedList<Integer> list = newList();
		list.add(0, i);
		return list;
	}

	/**
	 * scenario: adds one element to empty list
	 * 
	 * @return list- list containing no elements
	 */
	private DoubleLinkedList<Integer> oneToNone_removeIndexZeroList() {
		DoubleLinkedList<Integer> list = newList();
		list.add(i);
		list.remove(0);
		return list;
	}

	/**
	 * scenario: sets index 0 of one element list to different element
	 * 
	 * @return list- list containing one element (i2)
	 */
	private DoubleLinkedList<Integer> oneToDiffOne_setIndexZeroList() {
		DoubleLinkedList<Integer> list = newList();
		list.add(i);
		list.set(0, i2);
		return list;
	}

	/**
	 * scenario: adds one element to index 0 of one element list
	 * 
	 * @return list- list containing two elements (i,i2)
	 */
	private DoubleLinkedList<Integer> oneToTwo_addAtIndexOneList() {
		DoubleLinkedList<Integer> list = newList();
		list.add(i2);
		list.add(0, i);
		return list;
	}

	/**
	 * scenario: removes index one of two element list
	 * 
	 * @return list- list containing one element (i)
	 */
	private DoubleLinkedList<Integer> twoToOne_removeIndexOneList() {
		DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
		list.remove(1);
		return list;
	}

	/**
	 * scenario: adds one element to index 1 of two element list
	 * 
	 * @return list- list containing three elements (i,i3,i2)
	 */
	private DoubleLinkedList<Integer> twoToThree_addAtIndexOneList() {
		DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
		list.add(1, i3);
		return list;
	}

	/**
	 * scenario: removes index 1 of three element list
	 * 
	 * @return list- list containing two elements (i,i2)
	 */
	private DoubleLinkedList<Integer> threeToTwo_removeIndexOneList() {
		DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
		list.remove(1);
		return list;
	}

	/**
	 * scenario: sets index 1 of three element list to new element
	 * 
	 * @return list- list containing three elements (i,i4,i2)
	 */
	private DoubleLinkedList<Integer> threeToDiffThree_setIndexOneList() {
		DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
		list.set(1, i4);
		return list;
	}

	// --------------------------------------------------------------------------------------
	/** @return test success */
	private boolean newList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = newList();
			Integer i = new Integer(1);
			list.addToFront(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = newList();
			Integer i = new Integer(1);
			list.addToRear(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.addAfter(new Integer(1), new Integer(2));
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"newList_testAddAfter", "ElementNotFoundException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.removeFirst();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"newList_testRemoveFirst", "EmptyCollectionException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.removeLast();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"newList_testRemoveLast", "EmptyCollectionException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testRemoveElement() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.remove(new Integer(3));
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"newList_testRemoveElement", "ElementNotFoundException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.first();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"newList_testFirst", "EmptyCollectionException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testLast() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.last();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"newList_testLast", "EmptyCollectionException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testContains() {
		try {
			DoubleLinkedList<Integer> list = newList();
			return (list.contains(new Integer(3)) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = newList();
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testSize() {
		try {
			DoubleLinkedList<Integer> list = newList();
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "newList_testSize",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean newList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = newList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testIterator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testIteratorHasNext() {
		try {
			DoubleLinkedList<Integer> list = newList();
			Iterator<Integer> it = list.iterator();
			return (it.hasNext() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testIterator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testIteratorNext() {
		try {
			DoubleLinkedList<Integer> list = newList();
			Iterator<Integer> it = list.iterator();
			it.next();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean newList_testToString() {
		try {
			DoubleLinkedList<Integer> list = newList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.add(0, i);
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testAddAtIndex", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testSet() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.set(0, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"newList_testSet", "IndexOutOfBoundsException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.add(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n", "newList_testAdd",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testGet() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.get(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"newList_testGet", "IndexOutOfBoundsException",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = newList();

			return list.indexOf(i) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"newList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean newList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = newList();
			list.remove(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"newList_testRemove", "IndexOutOfBoundsException",
					e.toString());
			return false;
		}
	}

	// noneToOne_addToFrontList---------------------------------

	/** @return test success */
	private boolean noneToOne_addToFrontList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.addToFront(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.addToRear(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.addAfter(i2, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontListList_testAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.addAfter(i2, i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"noneToOne_addToFrontList_testAddAfter_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.removeLast() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.remove(i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"noneToOne_addToFrontList_testRemove_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.last() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testContains() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.contains(i2) == false);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"noneToOne_addToFrontList_testContains_false",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testSize() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean noneToOne_addToFrontList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean noneToOne_addToFrontList_testToString() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.add(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.add(2, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addToFrontList_testAddAtIndex_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testSet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.set(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.set(1, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addToFrontList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.add(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testGet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addToFrontList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToFrontList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return list.indexOf(i2) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// noneToOne_addToRearList----------------------------------------------------

	/** @return test success */
	private boolean noneToOne_addToRearList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.addToFront(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.addToRear(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.addAfter(i2, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.addAfter(i2, i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"noneToOne_addToRearList_testAddAfter_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.removeLast() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.remove(i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"noneToOne_addToRearList_testRemove_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.last() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testContains() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.contains(i2) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testContains_false", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testSize() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean noneToOne_addToRearList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean noneToOne_addToRearList_testToString() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.add(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.add(2, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addToRearList_testAddAtIndex_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testSet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.set(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.set(1, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addToRearList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.add(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testGet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addToRearList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addToRearList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToRearList();
			return list.indexOf(i2) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToRearList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// oneToNone_removeFirstList--------------------------------------------------

	/** @return test success */
	private boolean oneToNone_removeFirstList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.addToFront(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.addToRear(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.addAfter(i, i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeFirstList_testAddAfter",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.removeFirst();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeFirstList_testRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.removeLast();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeFirstList_testRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testRemoveElement() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.remove(i);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeFirstList_testRemoveElement",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.first();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeFirstList_testFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.last();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeFirstList_testLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean oneToNone_removeFirstList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean oneToNone_removeFirstList_testToString() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.add(0, i);
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testAddAtIndex", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.set(0, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeFirstList_testSet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.add(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.get(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeFirstList_testGet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			return list.indexOf(i) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeFirstList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeFirstList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.remove(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeFirstList_testRemove",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	// oneToNone_removeLastList---------------------------------------------------

	/** @return test success */
	private boolean oneToNone_removeLastList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.addToFront(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.addToRear(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.addAfter(i, i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeLastList_testAddAfter",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.removeFirst();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeLastList_testRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.removeLast();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeLastList_testRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testRemoveElement() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.remove(i);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeLastList_testRemoveElement",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.first();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeLastList_testFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			list.last();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeLastList_testLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean oneToNone_removeLastList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean oneToNone_removeLastList_testToString() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeLastList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.add(0, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testAddAtIndex", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.set(0, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeLastList_testSet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.add(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.get(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeLastList_testGet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			return list.indexOf(i) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeLastList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeLastList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeFirstList();
			list.remove(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeLastList_testRemove",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	// oneToNone_removeElementList------------------------------------------------

	/** @return test success */
	private boolean oneToNone_removeElementList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.addToFront(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testAddToFront", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.addToRear(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.addAfter(i, i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeElementList_testAddAfter",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.removeFirst();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeElementList_testRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.removeLast();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeElementList_testRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testRemoveElement() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.remove(i);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeElementList_testRemoveElement",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.first();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeElementList_testFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.last();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeElementList_testLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean oneToNone_removeElementList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean oneToNone_removeElementList_testToString() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.add(0, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testAddAtIndex", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.set(0, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeElementList_testSet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.add(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.get(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeElementList_testGet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			return list.indexOf(i) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeElementList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeElementList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeElementList();
			list.remove(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeElementList_testRemove",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	// oneToTwo_addToFrontList
	// (i2,i)----------------------------------------------------

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.addAfter(i3, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testAddAfter2() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.addAfter(i3, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testAddAfter2", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.addAfter(i3, i4);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToTwo_addToFrontList_testAddAfter_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.removeFirst() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.removeLast() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testRemove2() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.remove(i2) == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testRemove2", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.remove(i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToTwo_addToFrontList_testRemove_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.first() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testLast() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.last() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.contains(i) == true && list.contains(i2));
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.contains(i3) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testContains_false", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			Iterator<Integer> it = list.iterator();
			return (it.hasNext() == true && it.next() == i2
					&& it.hasNext() == true && it.next() == i && it.hasNext() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean oneToTwo_addToFrontList_testToString() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.add(1, i3);
			return list.get(1) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.add(3, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addToFrontList_testAddAtIndex_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.set(0, i3);
			return list.get(0) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.set(2, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addToFrontList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.add(i3);
			return list.get(2) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return list.get(0) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			list.get(2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addToFrontList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return list.indexOf(i) == 1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			return list.indexOf(i3) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean oneToTwo_addToFrontList_testListIteratorReference() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorReference",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIterator() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			return (it.hasNext() == true && it.next() == i2
					&& it.hasNext() == true && it.next() == i && it.hasNext() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIterator", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorPrevious() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.previous();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"NoSuchElementException",
					"oneToTwo_addToFrontList_testListIteratorPrev",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorStart0() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator(0);
			return (it.previousIndex() == -1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorStart0",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorStart1() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator(1);
			return it.nextIndex() == 1 && it.hasNext() == true
					&& it.next() == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorStart1",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorMix1() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			System.out.println(list.toString());
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.set(i4);

			return list.size() == 1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorMix1",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorConcurrentMod() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> lit1 = list.listIterator();
			ListIterator<Integer> lit2 = list.listIterator();
			lit1.next();
			lit1.set(i3);
			lit2.previousIndex();
			return false;
		} catch (ConcurrentModificationException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorConcurrentMod",
					"ConcurrentModificationException", e.toString());
			return false;
		}
	}

	// oneToTwo_addAfterOneList
	// (i,i2)--------------------------------------------------

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			list.addAfter(i3, i4);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {

			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testAddAfter_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return (list.contains(i) == true && list.contains(i2) == true && list
					.contains(i3) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			list.add(0, i3);
			return list.get(1) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			list.add(3, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testAddAtIndex_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			list.set(1, i3);
			return list.get(1) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			list.set(2, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			list.add(i3);
			return list.get(2) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return list.get(1) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			list.get(2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAfterOneList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAfterOneList();
			return list.indexOf(i3) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAfterOneList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// twoToOne_removeFirstList (i2)---------------------------------

	/** @return test success */
	private boolean twoToOne_removeFirstList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return (list.removeFirst() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testContains() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return (list.contains(i2) == true && list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testSize() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.add(0, i);
			return list.get(0) == i && list.get(1) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.add(2, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToOne_removeFirstList_testAddAtIndex_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testSet() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.set(0, i);
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.set(1, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToOne_removeFirstList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.add(i);
			return list.get(1) == i && list.get(0) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testGet() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return list.get(0) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToOne_removeFirstList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return list.indexOf(i2) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeFirstList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return list.indexOf(i) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeFirstList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// twoToOne_removeElementList (i2)---------------------------------

	/** @return test success */
	private boolean twoToOne_removeElementList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeElementList();
			return (list.removeFirst() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeElementList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testContains() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeElementList();
			return (list.contains(i2) == true && list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testSize() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeElementList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.add(0, i);
			return list.get(0) == i && list.get(1) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.add(2, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"twoToOne_removeElementList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testSet() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.set(0, i);
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.set(1, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToOne_removeElementList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.add(i);
			return list.get(1) == i && list.get(0) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testGet() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return list.get(0) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToOne_removeElementList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return list.indexOf(i2) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeElementList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeFirstList();
			return list.indexOf(i) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeElementList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// twoToThree_addToRearList (i,i2,i3)---------------------------------

	/** @return test success */
	private boolean twoToThree_addToRearList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return (list.removeLast() == i3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testContains() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return (list.contains(i) == true && list.contains(i2) == true
					&& list.contains(i3) == true && list.contains(i4) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testSize() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			list.add(1, i4);
			return list.get(0) == i && list.get(1) == i4 && list.get(2) == i2
					&& list.get(3) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			list.add(4, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToThree_addToRearList_testAddAtIndex_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testSet() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			list.set(1, i4);
			return list.get(1) == i4;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			list.set(3, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToThree_addToRearList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			list.add(i4);
			return list.get(2) == i3 && list.get(3) == i4;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testGet() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return list.get(1) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			list.get(3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToThree_addToRearList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return list.indexOf(i) == 0 && list.indexOf(i2) == 1
					&& list.indexOf(i3) == 2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addToRearList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return list.indexOf(i4) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// twoToThree_addAfterFirstList (i,i3,i2)---------------------------------

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testRemoveFirst",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"twoToThree_addAfterFirstList_testRemoveLast",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testContains() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			return (list.contains(i) == true && list.contains(i2) == true
					&& list.contains(i3) == true && list.contains(i4) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testSize() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			list.add(1, i4);
			return list.get(0) == i && list.get(1) == i4 && list.get(2) == i3
					&& list.get(3) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			list.add(4, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"twoToThree_addAfterFirstList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testSet() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			list.set(1, i4);
			return list.get(1) == i4;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			list.set(3, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			list.add(i4);
			return list.get(2) == i2 && list.get(3) == i4;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testGet() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			return list.get(1) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			list.get(3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAfterFirstList();
			return list.indexOf(i) == 0 && list.indexOf(i2) == 2
					&& list.indexOf(i3) == 1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAfterFirstList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAfterFirstList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addToRearList();
			return list.indexOf(i4) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addToRearList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// threeToTwo_removeFirstList---------------------------------

	/** @return test success */
	private boolean threeToTwo_removeFirstList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeFirstList();
			return (list.removeFirst() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeFirstList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeFirstList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeFirstList();
			return (list.removeLast() == i3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeFirstList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeFirstList_testContains() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeFirstList();
			return (list.contains(i) == false && list.contains(i2) == true
					&& list.contains(i3) == true && list.contains(i4) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeFirstList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeFirstList_testSize() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeFirstList();
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeFirstList_testSize", e.toString());
			return false;
		}
	}

	// -------------------------------------------------------------------------------------
	// noneToOne_addList---------------------------------

	/** @return test success */
	private boolean noneToOne_addList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.addToFront(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.addToRear(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.addAfter(i2, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.addAfter(i2, i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"noneToOne_addList_testAddAfter_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.removeLast() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.remove(i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"noneToOne_addList_testRemove_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.last() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testContains() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.contains(i2) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testContains_false", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testSize() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean noneToOne_addList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean noneToOne_addList_testToString() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.add(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.add(2, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addList_testAddAtIndex_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testSet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.set(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.set(1, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.add(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testGet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addList();
			return list.indexOf(i2) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// noneToOne_addAtIndexZeroList
	// (i)-----------------------------------------------------------------------------
	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.addToFront(i2);
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"noneToOne_addAtIndexZeroList_testAddToFront",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.addToRear(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.addAfter(i2, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.addAfter(i2, i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught %s\n",
							"noneToOne_addAtIndexZeroList_testAddAfter_ElementNotFound",
							"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testRemoveFirst",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.removeLast() == i);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"noneToOne_addAtIndexZeroList_testRemoveLast",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.remove(i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"noneToOne_addAtIndexZeroList_testRemove_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testLast() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.last() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testContains() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.contains(i2) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testContains_false",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testSize() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean noneToOne_addAtIndexZeroList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean noneToOne_addAtIndexZeroList_testToString() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.add(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.add(3, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"noneToOne_addAtIndexZeroList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testSet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.set(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.set(1, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.add(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testGet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean noneToOne_addAtIndexZeroList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addAtIndexZeroList();
			return list.indexOf(i2) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addAtIndexZeroList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// oneToNone_removeIndexZeroList------------------------------------------------------------------------------
	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.addToFront(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testAddToFront",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.addToRear(i);
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"oneToNone_removeIndexZeroList_testAddToRear",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.addAfter(i, i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeIndexZeroList_testAddAfter",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.removeFirst();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeIndexZeroList_testRemoveFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.removeLast();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeIndexZeroList_testRemoveLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testRemoveElement() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.remove(i);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeIndexZeroList_testRemoveElement",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.first();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeIndexZeroList_testFirst",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testLast() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.last();
			return false;
		} catch (EmptyCollectionException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"oneToNone_removeIndexZeroList_testLast",
					"EmptyCollectionException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			return (list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			return (list.isEmpty() == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			return (list.size() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean oneToNone_removeIndexZeroList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean oneToNone_removeIndexZeroList_testToString() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.add(0, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testAddAtIndex",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.set(0, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testSet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.add(i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.get(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testGet",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			return list.indexOf(i) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToNone_removeIndexZeroList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = oneToNone_removeIndexZeroList();
			list.remove(0);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToNone_removeIndexZeroList_testRemove",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	// oneToDiffOne
	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			return (list.removeFirst() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testRemoveFirst",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testRemoveLast",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			return (list.contains(i2) == true && list.contains(i) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			list.add(0, i);
			return list.get(0) == i && list.get(1) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			list.add(2, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"oneToDiffOne_setIndexZeroList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			list.set(0, i);
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			list.set(1, i);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			list.add(i);
			return list.get(1) == i && list.get(0) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			return list.get(0) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			return list.indexOf(i2) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToDiffOne_setIndexZeroList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToDiffOne_setIndexZeroList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToDiffOne_setIndexZeroList();
			return list.indexOf(i) == -1;
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"oneToDiffOne_setIndexZeroList_testIndexOf_ElementNotFound",
							e.toString());
			return false;
		}
	}

	// oneToTwo_addAtIndexOneList
	// (i,i2)--------------------------------------------------

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			list.addAfter(i3, i4);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {

			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testAddAfter_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testRemoveFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testContains() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return (list.contains(i) == true && list.contains(i2) == true && list
					.contains(i3) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testSize() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			list.add(0, i3);
			return list.get(1) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			list.add(3, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"oneToTwo_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testSet() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			list.set(1, i3);
			return list.get(1) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			list.set(2, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			list.add(i3);
			return list.get(2) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testGet() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return list.get(1) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			list.get(2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addAtIndexOneList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addAtIndexOneList();
			return list.indexOf(i3) == -1;

		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addAtIndexOneList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// twoToOne_removeIndexOneList---------------------------------

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.addToFront(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.addToRear(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.addAfter(i2, i);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.addAfter(i2, i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"twoToOne_removeIndexOneList_testAddAfter_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"twoToOne_removeIndexOneList_testRemoveFirst",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.removeLast() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testRemoveLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.remove(i2);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"twoToOne_removeIndexOneList_testRemove_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testLast() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.last() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testContains() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.contains(i) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.contains(i2) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testContains_false",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testSize() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return (list.size() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean twoToOne_removeIndexOneList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean twoToOne_removeIndexOneList_testToString() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.add(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.add(2, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"twoToOne_removeIndexOneList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testSet() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.set(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.set(1, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.add(i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testGet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			list.get(1);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToOne_removeIndexOneList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToOne_removeIndexOneList();
			return list.indexOf(i2) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToOne_removeIndexOneList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// twoToThree_addAtIndexOneList (i,i3,i2)---------------------------------

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.addToFront(i4);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.addToRear(i4);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testAddToRear", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.addAfter(i4, i);
			return list.get(0) == i && list.get(1) == i4 && list.get(2) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testAddAfter", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.addAfter(i2, i4);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught %s\n",
							"twoToThree_addAtIndexOneList_testAddAfter_ElementNotFound",
							"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testRemoveFirst",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"twoToThree_addAtIndexOneList_testRemoveLast",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testRemove", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.remove(i4);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught %s\n",
					"twoToThree_addAtIndexOneList_testRemove_ElementNotFound",
					"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testLast() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.last() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testContains() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.contains(i3) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.contains(i4) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testContains_false",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testSize() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean twoToThree_addAtIndexOneList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testIterator", e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean twoToThree_addAtIndexOneList_testToString() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testToString", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.add(0, i4);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.add(4, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"twoToThree_addAtIndexOneList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testSet() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.set(0, i2);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.set(3, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.add(i4);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testGet() {
		try {
			DoubleLinkedList<Integer> list = noneToOne_addToFrontList();
			return list.get(0) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			list.get(3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return list.indexOf(i3) == 1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean twoToThree_addAtIndexOneList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = twoToThree_addAtIndexOneList();
			return list.indexOf(i4) == -1;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"twoToThree_addAtIndexOneList_testIndexOf_ElementNotFound",
					e.toString());
			return false;
		}
	}

	// threeToTwo_removeIndexOneList
	// (i,i2)--------------------------------------------------

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			list.addAfter(i3, i4);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {

			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"threeToTwo_removeIndexOneList_testAddAfter_ElementNotFound",
							"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testRemoveFirst",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testRemoveLast",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testContains() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return (list.contains(i) == true && list.contains(i2) == true && list
					.contains(i3) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testContains", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testSize() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return (list.size() == 2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			list.add(0, i3);
			return list.get(1) == i;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			list.add(3, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"threeToTwo_removeIndexOneList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testSet() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			list.set(1, i3);
			return list.get(1) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			list.set(2, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testSet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			list.add(i3);
			return list.get(2) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testGet() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return list.get(1) == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			list.get(2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out.printf("%s expected %s, caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testGet_IndexOutOfBounds",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return list.indexOf(i) == 0;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToTwo_removeIndexOneList_testIndexOf", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToTwo_removeIndexOneList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = threeToTwo_removeIndexOneList();
			return list.indexOf(i3) == -1;

		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"threeToTwo_removeIndexOneList_testIndexOf_ElementNotFound",
							e.toString());
			return false;
		}
	}

	// threeToDiffThree_setIndexOneList
	// (i,i4,i2)---------------------------------

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testAddToFront() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.addToFront(i3);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testAddToRear",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testAddToRear() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.addToRear(i3);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testAddToRear",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testAddAfter() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.addAfter(i3, i4);
			return list.get(0) == i && list.get(1) == i4 && list.get(2) == i3;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testAddAfter",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testAddAfter_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.addAfter(i2, i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught %s\n",
							"threeToDiffThree_setIndexOneList_testAddAfter_ElementNotFound",
							"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testRemoveFirst() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.removeFirst() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testRemoveFirst",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testRemoveLast() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.removeLast() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testRemoveLast",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testRemove() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.remove(i) == i);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"threeToDiffThree_setIndexOneList_testRemove",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testRemove_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.remove(i3);
			return false;
		} catch (ElementNotFoundException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught %s\n",
							"threeToDiffThree_setIndexOneList_testRemove_ElementNotFound",
							"ElementNotFoundException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testFirst() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testFirst", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testLast() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.last() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testLast", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testContains() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.contains(i4) == true);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testContains",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testContains_false() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.contains(i3) == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testContains_false",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testIsEmpty() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.isEmpty() == false);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"noneToOne_addToFrontList_testIsEmpty", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testSize() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return (list.size() == 3);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testSize", e.toString());
			return false;
		}
	}

	/** @return test success */
	@SuppressWarnings("unused")
	private boolean threeToDiffThree_setIndexOneList_testIterator() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			Iterator<Integer> it = list.iterator();
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testIterator",
					e.toString());
			return false;
		}
	}

	/**
	 * toString() is difficult to test - would like to confirm that the default
	 * address output has been overridden
	 * 
	 * @return test success
	 */
	private boolean threeToDiffThree_setIndexOneList_testToString() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			String str = list.toString();
			System.out.println("toString() output:\n" + str);
			if (str.length() == 0) {
				return false;
			}
			char lastChar = str.charAt(str.length() - 1);
			if (str.contains("@")
					&& !str.contains(" ")
					&& Character.isLetter(str.charAt(0))
					&& (Character.isDigit(lastChar) || (lastChar >= 'a' && lastChar <= 'f'))) {
				return false; // looks like default toString()
			}
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testToString",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testAddAtIndex() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.add(0, i3);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testAddAtIndex",
					"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testAddAtIndex_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.add(4, i3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"threeToDiffThree_setIndexOneList_testAddAtIndex_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testSet() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.set(0, i3);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testSet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testSet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.set(3, i2);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"threeToDiffThree_setIndexOneList_testSet_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testAdd() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.add(i3);
			return true;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testAdd", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testGet() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return list.get(1) == i4;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testGet", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testGet_IndexOutOfBounds() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			list.get(3);
			return false;
		} catch (IndexOutOfBoundsException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"threeToDiffThree_setIndexOneList_testGet_IndexOutOfBounds",
							"IndexOutOfBoundsException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testIndexOf() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return list.indexOf(i2) == 2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"threeToDiffThree_setIndexOneList_testIndexOf",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean threeToDiffThree_setIndexOneList_testIndexOf_ElementNotFound() {
		try {
			DoubleLinkedList<Integer> list = threeToDiffThree_setIndexOneList();
			return list.indexOf(i3) == -1;
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"threeToDiffThree_setIndexOneList_testIndexOf_ElementNotFound",
							e.toString());
			return false;
		}
	}

	// -------------
	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorRemoveIllegalState() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.remove();
			return false;
		} catch (IllegalStateException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"oneToTwo_addToFrontList_testListIteratorRemoveIllegalState",
							"IllegalStateException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorHasPrevious() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			return it.hasPrevious() == false;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorHasPrevious",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorPreviousNoSuchElement() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.previous();
			return false;
		} catch (NoSuchElementException e) {
			return true;
		} catch (Exception e) {
			System.out
					.printf("%s expected %s, caught unexpected %s\n",
							"oneToTwo_addToFrontList_testListIteratorPreviousNoSuchElement",
							"NoSuchElementException", e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorNext() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();

			return it.next() == i2;
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorNext",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorNextPrevious() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.next();
			return (it.hasPrevious() == true && it.previous() == i2);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorNextPrevious",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorNextIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			return (it.nextIndex() == 0);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorNextIndex",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorPreviousIndex() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.next();
			return (it.previousIndex() == 1);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorPreviousIndex",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorAdd() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.next();
			it.add(i4);
			return (list.last() == i4 && list.size() == 3);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"oneToTwo_addToFrontList_testListIteratorAdd",
							e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorRemove() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.remove();
			return (list.size() == 1 && list.first() == i);
		} catch (Exception e) {
			System.out.printf("%s caught unexpected %s\n",
					"oneToTwo_addToFrontList_testListIteratorRemove",
					e.toString());
			return false;
		}
	}

	/** @return test success */
	private boolean oneToTwo_addToFrontList_testListIteratorSet() {
		try {
			DoubleLinkedList<Integer> list = oneToTwo_addToFrontList();
			ListIterator<Integer> it = list.listIterator();
			it.next();
			it.previous();
			it.set(i4);
			return (list.first() == i4);
		} catch (Exception e) {
			System.out
					.printf("%s caught unexpected %s\n",
							"oneToTwo_addToFrontList_testListIteratorSet",
							e.toString());
			return false;
		}
	}

}// end class UnorderedListTester
