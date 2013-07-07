package sorting.simple;

import sorting.Sort;

public class InsertionSort implements Sort {

	public int[] sort(int[] n) {
		for (int i = 1; i < n.length; i++) {
			// This inner loop is the area where we will be looking
			// where to keep next element from the unsorted place to
			// sorted elements, as we are considering elements till
			// second loop are already sorted.
			for (int j = 0; j < i; j++) {
				if (n[i] > n[j]) {
					int temp = n[j];
					n[j] = n[i];
					n[i] = temp;
				}
			}
		}
		return n;
	}

}
