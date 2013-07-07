package sorting;

import sorting.complex.MergeSort;

public class TestSort {

	public static void main(String[] args) {
		int[] n = TestUtil.getRandomIntegers(100000);
		TestUtil.print(n);
		Sort sort = new MergeSort();
		long time = System.currentTimeMillis();
		sort.sort(n);
		time = System.currentTimeMillis() - time;
		System.out.println("Sorting of " + n.length + " took " + time + " milliseconds.");
		TestUtil.print(n);
	}
}
