package sorting.complex;

import java.util.Arrays;
import java.util.BitSet;
import java.util.Random;

import sorting.TestUtil;

// Warning: This will not work if there are duplicate items, and they will be ignored
// indeed, this maybe the fastest way to sort and remove duplicates
public class CountingSortBitSet {

	public static void main(String[] args) {
		new CountingSortBitSet().testCountingSort();
	}
	
	private void testCountingSort() {
		// For 1 million integers numbers[~4MB], Java sort (QS) takes ~90 ms and count sort takes ~15 ms. 
        int listSize = 100;
        // Generate list of random values
        int[] a = new int[listSize];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(20000);
        }
        
        //a = new int[] {10, 20, 8, 4, 7, 22 };

        // Copy list to new array
        int[] a2 = new int[a.length];
        System.arraycopy(a, 0, a2, 0, a.length);

        TestUtil.print(a);
        // Sort the two arrays
        long time = System.currentTimeMillis();
        sort(a);
        time = System.currentTimeMillis() - time;
        System.out.println("Count sort took: " + time);
        TestUtil.print(a);
        time = System.currentTimeMillis();
        Arrays.sort(a2);
        time = System.currentTimeMillis() - time;
        System.out.println("Java sort took: " + time);

        // Compare the two arrays
        for (int i = 0; i < a.length; i++) {
            if (a[i] != a2[i]) {
                System.out.println("Error: Results do not match.");
                return;
            }
        }
        System.out.println("Sort successful");		
	}	
	private static int[] sort(int[] n) {
		if (n == null || n.length < 2) {
			return n;
		}
		int min = n[0], max = n[0];
		for (int i = 0, size = n.length; i < size; i++) {
			if (n[i] > max) {
				max = n[i];
			} else if (n[i] < min) {
				min = n[i];
			}
		}
		int range = (max - min) + 1;
		BitSet bitSet = new BitSet(range);
		for (int i = 0; i < n.length; i++) {
			bitSet.set(n[i] - min, true);
		}
		
		//n = new int[bitSet.length()];
		int counter = 0;
		for (int i = 0, length = bitSet.length(); i < length; i++) {
			if (bitSet.get(i)) {
				n[counter++] = i + min;
			}
		}
		
		return n;
	}
}
