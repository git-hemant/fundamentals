package bitwise;

public class Division {
	public static void main(String[] args) {
		int a = 91;
		int b = 3;
		System.out.println("Multiply: " + (a*b) + " binary multiply: " + binaryMulti(a, b));
		System.out.println("Divide: " + (a/b) + " binary divide: " + binaryDivide(a, b));
	}

	private static int binaryDivide(int dividend, int divisor) {
		int current = 1;
		int denom = divisor;
		// This step is required to find the biggest current number which can be
		// divided
		// with the number safely.
		while (denom <= dividend) {
			current <<= 1;
			denom <<= 1;
		}
		// Since we may have increased the denomitor more than dividend
		// thus we need to go back one shift, and same would apply for current.
		denom >>= 1;
		current >>= 1;
		int answer = 0;
		// Now deal with the smaller number.
		while (current != 0) {
			if (dividend >= denom) {
				dividend -= denom;
				answer |= current;
			}
			current >>= 1;
			denom >>= 1;
		}
		return answer;
	}

	private static int binaryMulti(int a, int b) {
		int result = 0;
		while (b != 0) {
			if ( (b & 1) == 1) {
				result += a;
			}
			a <<= 1;
			b >>>= 1;
		}
		return result;
	}
}
