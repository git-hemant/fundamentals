package sorting.complex;

import sorting.TestUtil;

public class QS {

	public static void main(String[] args) {
		int[] n = new int[] { 11, 38, 35, 7, 10, 27, 17, 22, 6, 38, 20, 12  };
		TestUtil.print(n);
		qs(n, 0, n.length - 1);
		TestUtil.print(n);
	}

	private static void qs(int[] n, int low, int high) {
		int left = low;
		int right = high;
		int pivot = n[(left + right) / 2];
		while (left < right) {
			while (n[left] < pivot) left++;
			while (n[right] > pivot) right--;
			if (n[left] >= n[right]) {
				// Swap the values
				int tmp = n[left];
				n[left] = n[right];
				n[right] = tmp;
				left++;
				right--;
			}
		}
		
		if (low < right) {
			qs(n, low, right);
		}
		if (left < high) {
			qs(n, left, high);			
		}
	}
}
