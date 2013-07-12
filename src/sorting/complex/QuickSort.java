package sorting.complex;

import sorting.TestUtil;

public class QuickSort {
	public static void main(String[] args) {
		int n[] = TestUtil.getRandomIntegers(25);
		//n = new int[] { 19, 15, 22, 8, 3, 64};
		TestUtil.print(n);
		new QuickSort().sort(n);
		TestUtil.print(n);

	}

	private void sort(int[] n) {
		sort(n, 0, n.length - 1);
	}

	private void sort(int[] n, int low, int high) {
		int left = low;
		int right = high;
		// Choose the pivot number such that it is always between
		// low and high.
		int pivot = n[low + ((high - low)/2)];
		
		while (left < right) {
			// This can never stuck in infinite loop
			// indeed it is O(N/2) as pivot is usually
			// in between so this condition should break
			// when left reaches pivot
			while (n[left] < pivot) {
				left++;
			}
			while (n[right] > pivot) {
				right--; 
			}
			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase left, and reduce right
			if (left < right) {
				exchange(n, left, right);
				left++;
				right--;
			}
		}
		if (low < right)
			sort(n, low, right);
		if (high < left) 
			sort(n, high, left);
	}
	
	private void exchange(int[] n, int i, int j) {
		int tmp = n[i];
		n[i] = n[j];
		n[j] = tmp;
	}
	
	
}
