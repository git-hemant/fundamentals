package sorting.complex;

import java.util.Arrays;
import java.util.Random;

import sorting.TestUtil;

/**
 * Count sort is in-memory sort, but it is not stable sort plus it have space
 * complexity based range in number to sort.
 * 
 * This implementation of counting sort does work with negative values in the array as well.
 * 
 * @author HemantSingh@Gmail.com
 */
public class CountingSort  {
	
	public static void main(String[] args) {
		new CountingSort().testCountingSort();
	}
	
	private void testCountingSort() {
		// For 1 million integers numbers[~4MB], Java sort (QS) takes ~90 ms and count sort takes ~15 ms. 
        int listSize = 1000000;
        // Generate list of random values
        int[] a = new int[listSize];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(20000);
        }
        
        //a = new int[] {10, 20, 8, -4, -7, 22 };

        // Copy list to new array
        int[] a2 = new int[listSize];
        System.arraycopy(a, 0, a2, 0, a.length);

        TestUtil.print(a);
        // Sort the two arrays
        long time = System.currentTimeMillis();
        countSort(a);
        time = System.currentTimeMillis() - time;
        System.out.println("Count sort took: " + time);
        TestUtil.print(a);
        time = System.currentTimeMillis();
        Arrays.sort(a2);
        time = System.currentTimeMillis() - time;
        System.out.println("Java sort took: " + time);

        // Compare the two arrays
        for (int i = 0; i < listSize; i++) {
            if (a[i] != a2[i]) {
                System.out.println("Error: Results do not match.");
                return;
            }
        }
        System.out.println("Sort successful");		
	}
 
	public static void countSort(int[] n) {
		// First find out the min and maximum numbers in the list.
		int max = n[0], min = n[0];
		for (int i = 1; i < n.length; i++) {
		    if (n[i] > max)
		        max = n[i];
		    else if (n[i] < min)
		        min = n[i];
		}
		
		// Now calculate the array size, this will be max - min + 1
		int numValues = max - min + 1;	
		int[] counts = new int[numValues];
		
		// Now mark the indexes in the new array where we have the values.
		// index value of 1 means we have only one value, index value of 2 means we
		// have 2 values with same number and so on.
		for (int i = 0; i < n.length; i++) {
			counts[n[i] - min]++;
		}
		
		// Now start the actual sort. Now at this point we don't care about the values in n
    	// as we have already marked the indexes in counts.
		int outputPos = 0;
		// Now iterate over the new array in sequence, and see where we don't have default
		// value of 0, and use that index in output.
		for (int i = 0; i < numValues; i++) {
		    for (int j = 0; j < counts[i]; j++) {
				n[outputPos] = i + min;
				outputPos++;
		    }
		}		
	}
}