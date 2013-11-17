package bitwise;

// How to add two numbers without addition operator
public class Addition {

	public static void main(String[] args) {
		int a = 21;
		int b = 31;
		System.out.println(a + " + " + b + " using minus: " + addUsingMinus(a, b));
		System.out.println(a + " + " + b + " using bitmanip: " + addUsingBitManip(a, b));
	}
	
	static int addUsingMinus(int a, int b) {
		return a - (-b);
	}
	
	static int addUsingBitManip(int a, int b) {
		// Do it while b is not zero
		while (b != 0) {
			// Find out the carry over by doing a & b
			// as this way we will leave only those bits
			// which are one in both a and b, which means
			// they qualify for carry over as in binary
			// addition 1 + 1 makes it 0 with carry 1.
			int carry = a & b;
			// Since we have taken note of carry so 
			// now remove all the bits which are 1 in both
			// a and b. as Xor means 1 ^ 1 is 0.
			a = a ^ b;
			// Now shift carry bits by one, as carry
			// is on the next bit
			b = carry << 1;
		}
		return a;
	}
}
