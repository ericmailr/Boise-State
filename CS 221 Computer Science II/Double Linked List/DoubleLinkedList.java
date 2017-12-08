import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * Implementation of the DoubleLinkedListADT
 * 
 * @author Eric Miller
 *
 * 
 */
public class DoubleLinkedList<T> implements DoubleLinkedListADT<T> {
	private int count;
	private LinearNode<T> head, tail;
	private int modCount;

	/**
	 * Adds the specified element to the front of this list.
	 *
	 * @param element
	 *            the element to be added to the front of this list
	 */
	@Override
	public void addToFront(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		newNode.setNext(head);
		newNode.setPrev(null);
		head = newNode;
		if (tail == null) {
			tail = head;
		}
		count++;
		modCount++;

	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the rear of this list
	 */
	@Override
	public void addToRear(T element) {
		LinearNode<T> newNode = new LinearNode<T>(element);
		if (isEmpty()) {
			head = tail = newNode;
		} else {
			tail.setNext(newNode);
			newNode.setPrev(tail);
			tail = newNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Adds the specified element after the specified target.
	 *
	 * @param element
	 *            the element to be added after the target
	 * @param target
	 *            the target is the item that the element will be added after
	 * @throws ElementNotFoundException
	 *             if target element is not in this list
	 */
	@Override
	public void addAfter(T element, T target) {
		LinearNode<T> current = head;
		while (current != null && !current.getElement().equals(target)) {
			current = current.getNext();
		}
		if (current == null) {
			throw new ElementNotFoundException("DoubleLinkedList");
		}
		LinearNode<T> newNode = new LinearNode<T>(element);
		newNode.setNext(current.getNext());
		newNode.setPrev(current);
		current.setNext(newNode);
		if (current == tail) {
			tail = newNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Removes and returns the first element from this list.
	 * 
	 * @return the first element from this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	@Override
	public T removeFirst() {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleLinkedList");
		}
		T retVal = head.getElement();
		if (head == tail) {
			head = tail = null;
		} else {
			head = head.getNext();
		}
		count--;
		modCount++;
		return retVal;
	}

	/**
	 * Removes and returns the last element from this list.
	 *
	 * @return the last element from this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	@Override
	public T removeLast() {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleLinkedList");
		}
		T retVal = tail.getElement();
		if (head == tail) {
			head = tail = null;
		} else {
			LinearNode<T> current = head;
			while (current.getNext() != tail) {
				current = current.getNext();
			}
			tail = current;
		}
		count--;
		modCount++;
		return retVal;
	}

	/**
	 * Removes and returns the specified element from this list.
	 *
	 * @param element
	 *            the element to be removed from the list
	 * @throws ElementNotFoundException
	 *             if element is not in this list
	 */
	@Override
	public T remove(T targetElement) throws ElementNotFoundException {
		if (isEmpty())
			throw new ElementNotFoundException("DoubleLinkedList");

		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;

		while (current != null && !found)
			if (targetElement.equals(current.getElement()))
				found = true;
			else {
				previous = current;
				current = current.getNext();
			}

		if (!found)
			throw new ElementNotFoundException("DoubleLinkedList");

		if (size() == 1) // only one element in the list
			head = tail = null;
		else if (current.equals(head)) // target is at the head
			head = current.getNext();
		else if (current.equals(tail)) // target is at the tail
		{
			tail = previous;
			tail.setNext(null);
		} else {
			// target is in the middle
			previous.setNext(current.getNext());
			current.getNext().setPrev(previous);
		}
		count--;
		modCount++;

		return current.getElement();
	}

	/**
	 * Returns a reference to the first element in this list.
	 *
	 * @return a reference to the first element in this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	@Override
	public T first() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleLinkedList");
		}
		return head.getElement();
	}

	/**
	 * Returns a reference to the last element in this list.
	 *
	 * @return a reference to the last element in this list
	 * @throws EmptyCollectionException
	 *             if list contains no elements
	 */
	@Override
	public T last() throws EmptyCollectionException {
		if (isEmpty()) {
			throw new EmptyCollectionException("DoubleLinkedList");
		}
		return tail.getElement();
	}

	/**
	 * Returns true if this list contains the specified target element.
	 *
	 * @param target
	 *            the target that is being sought in the list
	 * @return true if the list contains this element, else false
	 */
	@Override
	public boolean contains(T target) {
		boolean foundIt = false;
		LinearNode<T> current = head;
		while (current != null && !current.getElement().equals(target)) {
			current = current.getNext();
		}
		if (current != null) {
			foundIt = true;
		}
		return foundIt;
	}

	/**
	 * Returns true if this list contains no elements.
	 *
	 * @return true if this list contains no elements
	 */
	@Override
	public boolean isEmpty() {
		return (size() == 0);
	}

	/**
	 * Returns the number of elements in this list.
	 *
	 * @return the integer representation of number of elements in this list
	 */
	@Override
	public int size() {
		return count;
	}

	/**
	 * Inserts the specified element at the specified index.
	 * 
	 * @param index
	 *            the index into the array to which the element is to be
	 *            inserted.
	 * @param element
	 *            the element to be inserted into the array
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index > size())
	 */
	@Override
	public void add(int index, T element) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		}
		if (head == null) {
			head = tail = new LinearNode<T>(element);
		} else {
			LinearNode<T> previous = head;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.getNext();
			}
			LinearNode<T> newNode = new LinearNode<T>(element);
			if (index == 0) {
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			} else {
				newNode.setNext(previous.getNext());
				newNode.getNext().setPrev(newNode);
				previous.setNext(newNode);
				newNode.setPrev(previous);
			}
		}
		count++;
		modCount++;
	}

	/**
	 * Sets the element at the specified index.
	 *
	 * @param index
	 *            the index into the array to which the element is to be set
	 * @param element
	 *            the element to be set into the list
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	@Override
	public void set(int index, T element) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		}
		LinearNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		current.setElement(element);
	}

	/**
	 * Adds the specified element to the rear of this list.
	 *
	 * @param element
	 *            the element to be added to the rear of the list
	 */
	@Override
	public void add(T element) {
		if (head == null) {

			head = tail = new LinearNode<T>(element);
		} else {
			LinearNode<T> current = head;
			for (int i = 0; i < size() - 1; i++) {
				current = current.getNext();
			}
			LinearNode<T> newNode = new LinearNode<T>(element);
			current.setNext(newNode);

			// added
			newNode.setPrev(current);
			tail = newNode;
		}
		count++;
		modCount++;
	}

	/**
	 * Returns a reference to the element at the specified index.
	 *
	 * @param index
	 *            the index to which the reference is to be retrieved from
	 * @return the element at the specified index
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	@Override
	public T get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		}
		LinearNode<T> current = head;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getElement();
	}

	/**
	 * Returns the index of the specified element.
	 *
	 * @param element
	 *            the element for the index is to be retrieved
	 * @return the integer index for this element or -1 if element is not in the
	 *         list
	 */
	@Override
	public int indexOf(T element) {
		int index = 0;
		LinearNode<T> current = head;
		while (current != null && !current.getElement().equals(element)) {
			current = current.getNext();
			index++;
		}

		if (current == null) {
			index = -1;
		}
		return index;

	}

	/**
	 * Returns the element at the specified element.
	 *
	 * @param index
	 *            the index of the element to be retrieved
	 * @return the element at the given index
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index >= size())
	 */
	@Override
	public T remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException("DoubleLinkedList");
		}
		if (size() == 1) {
			T retVal = head.getElement();
			head = tail = null;
			count--;
			modCount++;
			return retVal;
		}
		LinearNode<T> current = head;
		for (int i = 0; i < index - 1; i++) {
			current = current.getNext();
		}
		T retVal = current.getNext().getElement();// 2
		LinearNode<T> temp = current.getNext();
		current.setNext(temp.getNext());
		temp.setPrev(current);

		if (current.getNext() == null) {
			tail = current;
		}
		count--;
		modCount++;
		return retVal;
	}

	/**
	 * Returns an iterator for the elements in this list.
	 *
	 * @return an iterator over the elements in this list
	 */
	@Override
	public Iterator<T> iterator() {
		return new DoubleLinkedList_ListIterator();
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence).
	 * 
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence)
	 */
	@Override
	public ListIterator<T> listIterator() {
		return new DoubleLinkedList_ListIterator();
	}

	/**
	 * Returns a list iterator over the elements in this list (in proper
	 * sequence), starting at the specified position in the list. The specified
	 * index indicates the first element that would be returned by an initial
	 * call to next. An initial call to previous would return the element with
	 * the specified index minus one.
	 * 
	 * @param startingIndex
	 *            index of the first element to be returned from the list
	 *            iterator (by a call to next)
	 * 
	 * @return a list iterator over the elements in this list (in proper
	 *         sequence), starting at the specified position in the list
	 * 
	 * @throws IndexOutOfBoundsException
	 *             if the index is out of range (index < 0 || index > size())
	 */
	@Override
	public ListIterator<T> listIterator(int startingIndex) {
		return new DoubleLinkedList_ListIterator(startingIndex);
	}

	private class DoubleLinkedList_ListIterator implements ListIterator<T> {

		private int iteratorModCount, currentIndex;
		private LinearNode<T> current;
		private boolean canRemoveSet, lastMoveNext;
		private final boolean addIsSupportedOperation = true,
				setIsSupportedOperation = true;

		/**
		 * Constructor for ListIterator
		 */
		public DoubleLinkedList_ListIterator() {
			current = head;
			iteratorModCount = modCount;
			currentIndex = 0;
		}

		/**
		 * constructor for ListIterator at starting index
		 * 
		 * @param startingIndex
		 */
		public DoubleLinkedList_ListIterator(int startingIndex) {
			current = head;
			iteratorModCount = modCount;
			currentIndex = startingIndex;
		}

		/**
		 * Inserts the specified element into the list (optional operation). The
		 * element is inserted immediately before the element that would be
		 * returned by next(), if any, and after the element that would be
		 * returned by previous(), if any. (If the list contains no elements,
		 * the new element becomes the sole element on the list.) The new
		 * element is inserted before the implicit cursor: a subsequent call to
		 * next would be unaffected, and a subsequent call to previous would
		 * return the new element. (This call increases by one the value that
		 * would be returned by a call to nextIndex or previousIndex.)
		 */
		@Override
		public void add(T element) throws ConcurrentModificationException,
				UnsupportedOperationException, ClassCastException,
				IllegalArgumentException {
			if (!addIsSupportedOperation) {
				throw new UnsupportedOperationException();
			}
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			LinearNode<T> newNode = new LinearNode<T>(element);
			if (!hasNext() && !hasPrevious()) {
				current.setPrev(newNode);
				current.setNext(null);
				head = tail = newNode;
			} else if (current == head) {
				current.setPrev(newNode);
				newNode.setNext(current);
				head = newNode;
			} else {
				current.getPrev().setNext(newNode);
				newNode.setNext(current);
				newNode.setPrev(current.getPrev());
				current.setPrev(newNode);
			}
			currentIndex++;
			modCount++;
			iteratorModCount++;
			count++;
			canRemoveSet = false;
		}

		/**
		 * Returns true if this list iterator has more elements when traversing
		 * the list in the forward direction. (In other words, returns true if
		 * next() would return an element rather than throwing an exception.)
		 * 
		 */
		public boolean hasNext() throws ConcurrentModificationException {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			return (current != null);
		}

		/**
		 * Returns true if this list iterator has more elements when traversing
		 * the list in the reverse direction. (In other words, returns true if
		 * previous() would return an element rather than throwing an
		 * exception.)
		 */
		@Override
		public boolean hasPrevious() throws ConcurrentModificationException {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			return current.getPrev() != null;
		}

		public T next() throws ConcurrentModificationException {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			T result = current.getElement();
			current = current.getNext();
			currentIndex++;
			canRemoveSet = true;
			lastMoveNext = true;
			return result;
		}

		/**
		 * Returns the index of the element that would be returned by a
		 * subsequent call to next(). (Returns list size if the list iterator is
		 * at the end of the list.)
		 * 
		 * @return currentIndex index of current node
		 */
		@Override
		public int nextIndex() throws ConcurrentModificationException {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			if (current.getNext() == null) {
				return size();
			} else {
				return currentIndex;
			}
		}

		/**
		 * Returns the previous element in the list and moves the cursor
		 * position backwards. This method may be called repeatedly to iterate
		 * through the list backwards, or intermixed with calls to next() to go
		 * back and forth. (Note that alternating calls to next and previous
		 * will return the same element repeatedly.)
		 * 
		 * @return T previous element
		 */
		@Override
		public T previous() throws ConcurrentModificationException,
				NoSuchElementException {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}
			T result = current.getPrev().getElement();
			current = current.getPrev();
			currentIndex--;
			canRemoveSet = true;
			lastMoveNext = false;
			return result;
		}

		/**
		 * Returns the index of the element that would be returned by a
		 * subsequent call to previous(). (Returns -1 if the list iterator is at
		 * the beginning of the list.)
		 */
		@Override
		public int previousIndex() throws ConcurrentModificationException {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			if (!hasPrevious()) {
				return -1;
			} else {

				return currentIndex - 1;
			}
		}

		/**
		 * Removes from the list the last element that was returned by next() or
		 * previous() (optional operation). This call can only be made once per
		 * call to next or previous. It can be made only if add(E) has not been
		 * called after the last call to next or previous.
		 */
		@Override
		public void remove() throws ConcurrentModificationException,
				IllegalStateException {
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			if (!canRemoveSet) {
				throw new IllegalStateException();
			}
			if (head == tail) {
				head = tail = null;
			} else if (lastMoveNext) {
				if (head.getNext() == current) {
					head = head.getNext();
					head.setPrev(null);
				} else {
					LinearNode<T> prevPrev = head;
					while (prevPrev.getNext().getNext() != current) {
						prevPrev = prevPrev.getNext();
					}
					prevPrev.setNext(current);

					if (current == null) {
						tail = prevPrev;
					} else {
						current.setPrev(prevPrev);
					}
				}
			} else {
				if (head == current) {
					head = head.getNext();
					head.setPrev(null);
				} else {
					LinearNode<T> prev = head;
					while (prev.getNext() != current) {
						prev = prev.getNext();
					}
					prev.setNext(current.getNext());
					if (tail == current) {
						tail = prev;
					} else {
						current.getNext().setPrev(prev);
					}
				}
			}
			modCount++;
			iteratorModCount++;
			count--;
			canRemoveSet = false;
			if (lastMoveNext) {
				currentIndex--;
			}

		}

		/**
		 * Replaces the last element returned by next() or previous() with the
		 * specified element (optional operation). This call can be made only if
		 * neither remove() nor add(E) have been called after the last call to
		 * next or previous.
		 * 
		 * @param e
		 *            element
		 */
		@Override
		public void set(T e) throws ConcurrentModificationException,
				UnsupportedOperationException, ClassCastException,
				IllegalArgumentException, IllegalStateException {
			if (!setIsSupportedOperation) {
				throw new UnsupportedOperationException();
			}
			if (!canRemoveSet) {
				throw new IllegalStateException();
			}
			if (iteratorModCount != modCount) {
				throw new ConcurrentModificationException();
			}
			LinearNode<T> newNode = new LinearNode<T>(e);
			if (head == tail) {
				head = tail = newNode;
			} else if (lastMoveNext) {
				current.getPrev().setElement(e);
			}

			else {
				current.setElement(e);
			}
			modCount++;
			iteratorModCount++;
			canRemoveSet = false;
		}
	}

	/**
	 * returns string representation of the list
	 * 
	 * @return str string representation of the list
	 */
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		LinearNode<T> current = head;
		while (current != null) {
			str.append(current.getElement() + ", ");
			current = current.getNext();
		}
		if (!isEmpty()) {
			str.delete(str.length() - 2, str.length());
		}
		str.append("]");
		return str.toString();
	}

}
