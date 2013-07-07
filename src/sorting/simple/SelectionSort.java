package sorting.simple;

import sorting.Sort;

public class SelectionSort implements Sort {

	public int[] sort(int[] n) {
		for (int i = 0, size = n.length; i < size; i++) {
			// Assume n[i] is the biggest number.
			int maxIndex = i;
			for (int j = i; j < size; j++) {
				if (n[j] > n[maxIndex]) {
					maxIndex = j;
				}
			}
			// In selection sort, we swap maximum of O(n) times
			if (maxIndex != i) {
				// Now swap the values.
				int temp = n[maxIndex];
				n[maxIndex] = n[i];
				n[i] = temp;
			}
		}
		return n;
	}
}
