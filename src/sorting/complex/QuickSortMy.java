package sorting.complex;

import sorting.TestUtil;

public class QuickSortMy {
	public static void main(String[] args) {
		int n[] = TestUtil.getRandomIntegers(25);
		n = new int[] { 881, 1369, 890, 1088, 1030, 1492, 1350, 550, 1217,
				1053, 580, 1366, 851, 1337, 1183, 1179, 1811, 857, 1223, 603,
				426, 1536, 1341, 1033, 423 };
		TestUtil.print(n);
		new QuickSortMy().sortIntegerArray(n);
		TestUtil.print(n);

	}

	private void sortIntegerArray(int[] n) {
		sort(n, 0, n.length - 1);
	}

	private void sort(int[] n, int low, int high) {
		int left = low;
		int right = high;
		// Choose the pivot number such that it is always between
		// low and high.
		int pivot = n[low + ((high - low)/2)];
		
		// While left is less than right.
		while (left < right) {
			
			// We expect left side to have smaller numbers in ascending sort
			// so it is good thing, if left number is smaller than pivot
			// keep moving to next till this happen
			// This can never stuck in infinite loop
			// indeed it is O(N/2) as pivot is usually
			// in between so this condition should break
			// when left reaches pivot
			while (n[left] < pivot) {
				left++;
			}
			
			// If the right number is greater than pivot, than it is good thing
			// as right most number should be highest in ascending sort, so keep
			// reducing right till this condition is not true.
			while (n[right] > pivot) {
				right--; 
			}
			// If we have found a values in the left list which is larger then
			// the pivot element and if we have found a value in the right list
			// which is smaller then the pivot element then we exchange the
			// values.
			// As we are done we can increase left, and reduce right, here it is very
			// important to do <= and NOT < as later one can cause recursion as
			// we do need to increment left and reduce right in that condition as well.
			if (left <= right) {
				exchange(n, left, right);
				left++;
				right--;
			}
		}
		if (low < right)
			sort(n, low, right);
		if (left < high) 
			sort(n, left, high);
	}
	
	private void exchange(int[] n, int i, int j) {
		int tmp = n[i];
		n[i] = n[j];
		n[j] = tmp;
	}
	
	
}
