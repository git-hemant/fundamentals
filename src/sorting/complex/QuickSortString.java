package sorting.complex;

import sorting.TestUtil;


public class QuickSortString {

	public static void main(String[] args) {
		Comparable[] n = { "In", "numerical", "linear", "algebra", "the",
				"tridiagonal", "matrix", "algorithm", "also", "known", "as",
				"the", "Thomas", "algorithm", "named", "after", "Llewellyn",
				"Thomas", "is", "a", "simplified", "form", "of", "Gaussian",
				"elimination", "that", "can", "be", "used", "to", "solve",
				"tridiagonal", "systems", "of", "equations.", "A",
				"tridiagonal", "system", "for", "n", "unknowns", "may", "be",
				"written", "as" };
		TestUtil.print(n);
		qs(n, 0, n.length - 1);
		TestUtil.print(n);
	}
	
	
	public static void qs(Comparable n[], int low, int high) {
		int left = low;
		int right = high;
		Comparable pivot = n[((high-low)/2) + low];
		while (left < right) {
			while (isLessThan(n[left], pivot)) {
				left++;
			}
			while (isGreaterThan(n[right], pivot)) {
				right--;
			}
			if (left <= right) {
				//Swap the values
				Comparable temp = n[left];
				n[left] = n[right];
				n[right] = temp;
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
	
	private static boolean isLessThan(Comparable c1, Comparable c2) {
		int c = c1.compareTo(c2);
		return c != 0 && c < 0;
	}
	
	private static boolean isGreaterThan(Comparable c1, Comparable c2) {
		int c = c1.compareTo(c2);
		return c != 0 && c > 0;
	}	
}
