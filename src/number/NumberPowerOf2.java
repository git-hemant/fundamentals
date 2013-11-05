package number;
public class NumberPowerOf2
{
	public static void main(String[] args)
	{
		int j = 0;
		for (j = 0; j < java.lang.Integer.MAX_VALUE; j++) {
			if (isPowerOf2(j))
				System.out.println(j + " = binary -> " + java.lang.Integer.toBinaryString(j) + "  " + j + " - 1 binary -> " + java.lang.Integer.toBinaryString(j - 1));
		}
	}
	
	// Let's for example consider the e.g. of 4
	// 4 & 3 == 0 because binary of
	// 4 is 100
	// 3 is 011
	// so 100 & 011 will yield to 0
	public static boolean isPowerOf2(int n) {
		return n > 2 && (n & n - 1) == 0;
	}
}
