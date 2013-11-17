package bitwise;

// In case of binary - minus is also done as plus using two's complement.
public class Minus {

	public static void main(String[] args) {
		int a = 31;
		int b = 21;
		System.out.println(a + " - " + b + " using minus: " + minusUsingBitManip(a, b));
	}
	
	static int minusUsingBitManip(int a, int b) {
		// Now apply two's complement to the second term.
		b = twosComplement(b);
		return Addition.addUsingBitManip(a, b);
	}	

	// In two's complement we invert the bit and add 1.
	static int twosComplement(int n) { 
		// If needed we can use here addition by bit manipulation
		// return Addition.addUsingBitManip(~n, 1);
		return ~n + 1;
	}
}
