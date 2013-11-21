package bitwise;

/**
 *           __________
 *  divisor ) Dividend ( quotient      
 *  
 *            _.._____
 *            denominator
 *         
 * @author Hemant
 *
 */
public class Division {
	public static void main(String[] args) {
		int a = 91;
		int b = 19;
		int result = division(a, b);
		System.out.println("Number " + a + "/" + b + " = " + result);
		//Test the code;
		int[] testDivisor = {19};
		for (int i = 0; i < testDivisor.length; i++) {
			for (int j = 1275176857; j < Integer.MAX_VALUE; j++) {
				int opResult = j / testDivisor[i];
				int myResult = division(j, testDivisor[i]);
				// The results should always match here.
				if (opResult != myResult) {
					System.out.println("Bug- Dividend=" + j + " Divisor=" + testDivisor[i] + " Operator=" + opResult + "  binary-division=" + myResult);
				}
			}
		}
	}
	
	private static int division(int dividend, int divisor) {
		int denom = divisor;
		int count = 1;
		// Warning: This approach would fail in-case number is 
		// big enough that it population count is 31 and if we
		// shift it one more time to the left than number
		// will overflow.
		while (denom <= dividend) {
			// We can easily do significant bit count here
			// and don't do left shift if significant bit
			// count is 31 (or more). In-case if we don't want
			// to hard code 31 than we can derive 31 number from
			// Integer.MAX_VALUE population count (significant bit)
			denom <<= 1;
			// We need to shift the count here
			// as we are doubling the denominator everytime
			// which means count would also double.
			count <<= 1;
		}
		// Since at this point denominator maybe higher than dividend.
		if (denom > dividend) {
			denom >>= 1; count >>= 1;
		}
		
		int answer = 0;
		// Now find the smaller dividend
		while (count != 0) {
			if (dividend >= denom) {
				dividend = dividend - denom;
				// Consume the count value;
				answer = answer | count;
			}
			count >>>= 1;
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
