package books.cci.ch5;

public class P6_SwapOddEvenBits {

	public static void main(String[] args) {
		int n = 25;
		System.out.println("n = 25 binary: " + Integer.toBinaryString(n));
		n = swapOddEvenBits(n);
		System.out.println("after swap: " + n + " binary: " + Integer.toBinaryString(n));
	}
	
	// 0xa binary is 1010
	// 0x5 binary is 101
	public static int swapOddEvenBits(int x) {
		// clear every odd bit, as this will make 25 (1101) to 8 (1000)
		int res1 = (x & 0xAAAAAAAA);
		String binary = Integer.toBinaryString(res1);
		// now shift right - this way all even bits which are 1 will move
		// to odd locations. now 8 will become 4 (100)
		res1 >>= 1; 
		binary = Integer.toBinaryString(res1);
		
		// clear every even bits, now only odd bits which are 1 would be left
		// this way 25 would become 17.
		int res2 = x & 0x55555555;
		binary = Integer.toBinaryString(res2);
		// now shift left - this way all the odd bits which are 1 would move
		// to even location. now 17 will become 34. 
		res2 <<= 1; 
		binary = Integer.toBinaryString(res2);
		// Now combine both numbers.
		int res = res1 | res2;
		return res;
	}
}
