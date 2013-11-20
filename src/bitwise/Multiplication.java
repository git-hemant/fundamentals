package bitwise;

public class Multiplication {

	public static void main(String[] args) {
		int a = 11;
		int b = 14;
		int result = bitwiseMultiply(a, b);
		System.out.println("Binary multiply: " + result
				+ " Standard multiply: " + (a * b));
	}

	public static int bitwiseMultiply(int a, int b) {
		/* This value will hold the sum of the terms so far. */
		int result = 0;
		/*
		 * Continuously loop over more and more bits of n2 until we've consumed
		 * the last of them. Since after i iterations of the loop b = n2 >> i,
		 * this only reaches zero once we've used up all the bits of the
		 * original value of n2.
		 */
		while (b != 0) {
			/*
			 * Using the bitwise AND trick, determine whether the ith bit of b
			 * is a zero or one. If it's a zero, then the current term in our
			 * sum is zero and we don't do anything. Otherwise, then we should
			 * add n1 * 2^i.
			 */
			if ((b & 1) != 0) {
				/*
				 * Recall that a = n1 * 2^i at this point, so we're adding in
				 * the next term in the sum.
				 */
				result = result + a;
			}

			/*
			 * To maintain that a = n1 * 2^i after i iterations, scale it by a
			 * factor of two by left shifting one position.
			 */
			a <<= 1;

			/*
			 * To maintain that b = n2 >> i after i iterations, shift it one
			 * spot over.
			 */
			b >>>= 1;
		}
		return result;
	}
}
