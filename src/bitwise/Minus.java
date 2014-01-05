package bitwise;

// In case of binary - minus is also done as plus using two's complement.
public class Minus {

	public static void main(String[] args) {
		int a = 31;
		int b = 21;
		System.out.println(a + " - " + b + " using minus: " + minusUsingBitManip(a, b));
		
		System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
	}
	
	static int minusUsingBitManip(int a, int b) {
		// Now apply two's complement to the second term.
		b = twosComplement(b);
		// Now if we are allowed to use + operator
		// we can do "return a + b;"
		return Addition.addUsingBitManip(a, b);
	}	

	// In two's complement we invert the bit and add 1.
	// This way we can negate the number for e.g.
	// 4  --2's complement ---> -4
	// 40 --2's complement ---> -40
	// 87 --2's complement ---> -87
	static int twosComplement(int n) { 
		// If needed we can use here addition by bit manipulation
		// return Addition.addUsingBitManip(~n, 1);
		return ~n + 1;
	}
}
