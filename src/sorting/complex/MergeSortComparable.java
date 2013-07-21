package sorting.complex;

import sorting.TestUtil;

public class MergeSortComparable {

	public static void main(String[] args) {
		String[] n = { "In", "numerical", "linear", "algebra", "the",
				"tridiagonal", "matrix", "algorithm", "also", "known", "as",
				"the", "Thomas", "algorithm", "named", "after", "Llewellyn",
				"Thomas", "is", "a", "simplified", "form", "of", "Gaussian",
				"elimination", "that", "can", "be", "used", "to", "solve",
				"tridiagonal", "systems", "of", "equations.", "A",
				"tridiagonal", "system", "for", "n", "unknowns", "may", "be",
				"written", "as" };
		TestUtil.print(n);
		TestUtil.print(doMergeSort(n));
	}
	
	private static Object[] divideArray(Object[] n) {
		Comparable[] n1 = new Comparable[n.length/2];
		Comparable[] n2 = new Comparable[n.length - n1.length];
		System.arraycopy(n, 0, n1, 0, n1.length);
		System.arraycopy(n, n1.length, n2, 0, n2.length);
		return new Object[] {n1, n2};
	}
	
	private static Comparable[] doMergeSort(Comparable[] n) {
		if (n == null || n.length < 2) {
			return n;
		}
		Object obj[] = divideArray(n);
		return mergeSort( (Comparable[])obj[0], (Comparable[]) obj[1]);
	}

	private static Comparable[] mergeSort(Comparable[] n1, Comparable[] n2) {
		if (n1.length > 1) {
			Object obj[] = divideArray(n1);
			n1 = mergeSort( (Comparable[])obj[0], (Comparable[]) obj[1]);
		}
		if (n2.length > 1) {
			Object obj[] = divideArray(n2);
			n2 = mergeSort( (Comparable[])obj[0], (Comparable[]) obj[1]);
		}
		int n1Counter = 0;
		int n2Counter = 0;
		Comparable[] n = new Comparable[n1.length + n2.length];
		for (int i = 0; i < n.length; i++) {
			if (n1Counter == n1.length) {
				n[i] = n2[n2Counter++];
			} else if (n2Counter == n2.length) {
				n[i] = n1[n1Counter++];
			} else if (n2[n2Counter].compareTo(n1[n1Counter]) < 0) {
				n[i] = n2[n2Counter++];
			} else {
				n[i] = n1[n1Counter++];				
			}
		}
		return n;
	}
}
