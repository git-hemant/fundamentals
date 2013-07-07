package sorting.complex;

import sorting.Sort;

/**
 * Merge sort implementation which attempts to give performance of O(N log N).
 * 
 * @author HemantSingh@gmail.com
 */
public class MergeSort implements Sort {

	public int[] sort(int[] n) {
		Object[] obj = divideArrayInTwo(n);
		// Free up the unsorted elements memory before 
		// sorting, as we have already copied the unsorted values
		// in two separate sub-arrays.
		n = null; 
		n = divideAndConquer((int[]) obj[0], (int[]) obj[1]);
		return n;
	}

	/**
	 * Divide the given array
	 */
	private int[] divideAndConquer(int[] n1, int[] n2) {
		if (n1.length > 1) {
			// Sort the items in n1
			Object[] obj = divideArrayInTwo(n1);
			n1 = divideAndConquer((int[]) obj[0], (int[]) obj[1]);
		}
		if (n2.length > 1) {
			// Sort the items in n2
			Object[] obj = divideArrayInTwo(n2);
			n2 = divideAndConquer((int[]) obj[0], (int[]) obj[1]);
		}
		// now merge n1 and n2
		return mergeSortedArrays(n1, n2);
	}

	/**
	 * Merge the given sorted arrays to make one array.
	 */
	private static int[] mergeSortedArrays(int[] n1, int[] n2) {
		int[] n = new int[n1.length + n2.length];
		int n1Index = 0;
		int n2Index = 0;
		for (int i = 0; i < n.length; i++) {
			// first we will check if we have already seen all items
			// in array n1 or n2 to avoid AIOOBE.
			if (n1Index == n1.length) {
				// If we have seen all the elements of n1
				// than we will simply append n2 items now.
				n[i] = n2[n2Index++];
			} 
			else if (n2Index == n2.length) {
				// If we have seen all the elements of n2
				// than we will simply append n1 items now.
				n[i] = n1[n1Index++];
			} 
			else if (n1[n1Index] > n2[n2Index]) {
				n[i] = n1[n1Index++];
			}
			// the following else is required for (n2[n2Index] > n1[n1Index])
			// condition.
			else {
				n[i] = n2[n2Index++];
			}
		}
		return n;
	}

	/**
	 * Divide the given array into two arrays and return the arrays as Object.
	 */
	private static Object[] divideArrayInTwo(int[] n) {
		int[] n1 = new int[n.length / 2];
		int[] n2 = new int[n.length - n1.length];
		System.arraycopy(n, 0, n1, 0, n1.length);
		System.arraycopy(n, n1.length, n2, 0, n2.length);
		return new Object[] { n1, n2 };
	}
}
