public class NumberPowerOf2
{
	public static void main(String[] args)
	{
		for (int i = 0; i < java.lang.Integer.MAX_VALUE; i++)
			if (isPowerOf2(i))
				System.out.println(i + " = binary -> " + java.lang.Integer.toBinaryString(i) + "  " + i + " - 1 binary -> " + java.lang.Integer.toBinaryString(i - 1));
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
