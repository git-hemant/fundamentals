package books.cci.ch5;

// Given an integer, print the next smallest and next largest number that have the same number of 1 bits in their binary representation.
public class P3_SmallLargerWithSameBits {
	public static void main(String[] args) {
		int n = 31;
		int oneBits = count1Bits(n);
		
		int nSmaller = getSmallerThanNWithSameOneBits(n, oneBits);
		int nLarge = getLargerThanNWithSameOneBits(n, oneBits);
		
		System.out.println("N=" + n + " binary: " + Integer.toBinaryString(n) + " count of 1 bits: " + oneBits);
		System.out.println("Larger=" + nLarge + " binary: " + Integer.toBinaryString(nLarge) + " count of 1 bits: " + count1Bits(nLarge));
		System.out.println("Smaller=" + nSmaller + " binary: " + Integer.toBinaryString(nSmaller) + " count of 1 bits: " + count1Bits(nSmaller));

		// We can add the validation here to check if the small number is really small, because if original number had all bits
		// to one say 31 which is 11111 then we can make a smaller number than this which have bit count of 5.
		// Also we can add check if the number is already Integer.MAX_VALUE that means all the 31 bits except most significant
		// which is reserved for sign is already set and thus we can't make a number larger than it.
	}

	// I can just do n << 1 to get larger number, but this way we won't know
	// if there is already 
	private static int getLargerThanNWithSameOneBits(int n, int totalOneBits) {
		int bitCounter = 0;
		// Move from right to left in the number, and mark first bit which
		// is 1 to 0.
		int onebitCounter = 0;
		while (onebitCounter < totalOneBits) {
			if ( (n & (1 << bitCounter)) == (1 << bitCounter)) {
				// Mark the first right most 1 bit to 0.
				if (onebitCounter == 0) {
					n = n ^ (1 << bitCounter);
				}
				onebitCounter++;
			}
			bitCounter++;
		}
		
		// Now we need to make bit at oneBitCounter to 1
		n = n ^ (1 << bitCounter);
		
		return n;
	}

	// Move again from right to left, and first zero you find make it 1 bit
	// and make last 1 bit to zero. Thus keeping number of 1 bits to same
	// but reducing the number.
	private static int getSmallerThanNWithSameOneBits(int n, int totalOneBits) {
		int bitCounter = 0;
		int oneBitCounter = 0;
		boolean modifiedZeroBit = false;
		while (oneBitCounter < totalOneBits) {
			if ( (n & (1 << bitCounter)) > 0) {
				oneBitCounter++;
				if (oneBitCounter == totalOneBits) {
					// Make this one bit as zero. Since Xor will make it
					// 0 if it see two one at same bit location.
					n = n ^ (1 << bitCounter);
				}
			} else if (!modifiedZeroBit){
				// at this location in number the bit is zero, make it one.
				n = n ^ (1 << bitCounter);
				// do it only once.
				modifiedZeroBit = true;
			}
			bitCounter++;
		}
		return n;
	}

	static int count1Bits(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>>= 1;
		}
		return count;
	}
}
