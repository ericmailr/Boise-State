import java.util.Arrays;

public class HashTable<T> {
	@SuppressWarnings("rawtypes")
	private HashObject[] table;
	private boolean linearProbing;
	private int tableSize, insertionCount, probeCount, tempProbeCount, inputType;
	private long duplicateCount;
	@SuppressWarnings("rawtypes")
	private HashObject prevHObj;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public HashTable(boolean linearProbing, int tableSize, int inputType) {
		table = new HashObject[tableSize];
		this.inputType = inputType;
		for (int i = 0; i < tableSize; i++) {
			if (inputType == 1)
				Arrays.fill(table, new HashObject(-1));
			else if (inputType == 2)
				Arrays.fill(table, new HashObject(new Long(-1)));
			else if (inputType == 3)
				Arrays.fill(table, new HashObject(new String("-1")));
		}
		this.linearProbing = linearProbing;
		this.tableSize = tableSize;
		this.insertionCount = 0;
		this.probeCount = 0;
		this.duplicateCount = 0;
		this.prevHObj = new HashObject(new Integer(-2));
		this.tempProbeCount = 0;
	}

	public int getInsertionCount() {
		return this.insertionCount;
	}

	public int getProbeCount() {
		return this.probeCount;
	}

	public long getDuplicateCount() {
		return this.duplicateCount;
	}

	@SuppressWarnings("rawtypes")
	private void setPrevKey(HashObject h) {
		this.prevHObj = h;
	}

	@SuppressWarnings({ "unused", "rawtypes" })
	private HashObject getPrevKey() {
		return this.prevHObj;
	}

	public int getTempProbeCount() {
		return this.tempProbeCount;
	}

	@SuppressWarnings("rawtypes")
	public void insert(HashObject h) {
		Object newSlotKey;
		Object key = h.getKey();
		this.tempProbeCount = 0;

		if (inputType == 1) {
			int index = ((int) key) % tableSize;
			int doubleH = (int) key % (tableSize - 2);
			while ((int) (newSlotKey = table[index].getKey()) != -1 && !key.equals(newSlotKey)) {
				this.tempProbeCount++;
				if (linearProbing) {
					index = (index + 1) % tableSize;
				} else {
					index = (index + 1 + doubleH) % tableSize;
				}
			}
			if (key.equals(newSlotKey)) {
				table[index].incrementFrequency();
				duplicateCount++;
				return;
			} else {

				table[index] = h;
				insertionCount++;
				probeCount += this.tempProbeCount;
			}
		} else if (inputType == 2) {
			long longKey = (long) key;
			long longIndex = (longKey) % tableSize;
			int index = (int) longIndex;
			if (this.prevHObj.equals(h)) {
				table[index].incrementFrequency();
				duplicateCount++;
				return;
			} else {
				setPrevKey(h);
			}
			long doubleH = (longKey % (tableSize - 2));
			while (!(newSlotKey = table[index].getKey()).equals(new Long(-1)) && !key.equals(newSlotKey)) {
				this.tempProbeCount++;
				if (linearProbing) {
					index = (index + 1) % tableSize;
				} else {
					longIndex = (index + 1 + doubleH) % tableSize;
					index = (int) longIndex;
				}
			}
			if (key.equals(newSlotKey)) {
				table[index].incrementFrequency();
				duplicateCount++;
				return;
			} else {
				for (int i = 0; i < tableSize; i++) {
					if (table[i].getKey().equals(key)) {
						table[i].incrementFrequency();
						duplicateCount++;
						return;
					}
				}
				table[index] = h;
				insertionCount++;
				probeCount += this.tempProbeCount;
			}
		} else {
			long stringInt = (long) Math.abs(h.getKey().hashCode());
			long longIndex = stringInt % tableSize;
			int index = (int) longIndex;
			long doubleH = (stringInt % (tableSize - 2));

			while (!(newSlotKey = table[index].getKey()).equals(new String("-1")) && !key.equals(newSlotKey)) {
				this.tempProbeCount++;
				if (linearProbing) {
					index = (index + 1) % tableSize;
				} else {
					index = (int) ((index + 1 + doubleH) % tableSize);
				}
			}
			if (key.equals(newSlotKey)) {
				table[index].incrementFrequency();
				duplicateCount++;
				return;
			} else {
				for (int i = 0; i < tableSize; i++) {
					if (table[i].getKey().equals(key)) {
						table[i].incrementFrequency();
						duplicateCount++;
						return;
					}
				}
				table[index] = h;
				insertionCount++;
				probeCount += this.tempProbeCount;
			}
		}
	}

	public String toString() {
		String ret = "";
		for (int i = 0; i < tableSize; i++) {
			if (inputType == 1) {
				if (!table[i].getKey().equals(new Integer(-1))) {
					ret += "table[" + i + "]: " + table[i].toString() + "\n";
				}
			} else if (inputType == 2) {
				if (!table[i].getKey().equals(new Long(-1))) {
					ret += "table[" + i + "]: " + table[i].toString() + "\n";
				}
			} else if (inputType == 3) {
				if (!table[i].getKey().equals(new String("-1"))) {
					ret += "table[" + i + "]: " + table[i].toString() + "\n";
				}
			}
		}
		return ret;
	}
}
