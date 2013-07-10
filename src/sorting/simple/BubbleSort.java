package sorting.simple;

import sorting.Sort;

/**
 * Simplest sorting algorithm where target value
 * is bubbled to one side. Since here we are doing
 * ascending sort, the biggest value get bubbled
 * to the left side after end of iteration, and
 * then second biggest value, and so on.
 * 
 * @author HemantSingh@gmail.com
 *
 */
public class BubbleSort implements Sort {

	public int[] sort(int[] n) {
		for (int i = 0, size = n.length; i < size; i++) {
			for (int j = i; j < size; j++) {
				if (n[j] > n[i]) {
					// In Bubble sort, we do swap maximum of
					// of O(N power of 2)
					int temp = n[i];
					n[i] = n[j];
					n[j] = temp;
				}
			}
		}
		return n;
	}
}
