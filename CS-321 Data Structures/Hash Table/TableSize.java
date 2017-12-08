import java.util.Random;

public class TableSize {
	private int low, high;
	private Random rand;

	public TableSize(int low, int high) {
		this.low = low;
		this.high = high;
		rand = new Random();
	}

	public int getTableSize() {
		int curr = low;
		while (curr <= high) {
			if (!isPrime(curr)) {
				curr++;
			} else {
				// System.out.println(curr);
				if (isPrime(curr + 2)) {
					return curr + 2;
				} else {
					curr++;
				}
			}
		}
		return 0;
	}

	private int getPowerModulo(int base, int exp, int mod) {
		long temp = 1;
		long b = base;
		while (exp > 0) {
			if (exp % 2 == 1) {
				temp = (temp * b) % mod;
			}
			b = (b * b) % mod;
			exp /= 2;
		}
		return (int) temp % mod;
	}

	private boolean isPrime(int curr) {
		int randomNum = rand.nextInt(curr - 2) + 2;
		if (getPowerModulo(randomNum, curr - 1, curr) != 1) {
			return false;
		}
		randomNum = rand.nextInt(curr - 2) + 2;
		if (getPowerModulo(randomNum, curr - 1, curr) != 1) {
			return false;
		} else {
			return true;
		}
	}
}
