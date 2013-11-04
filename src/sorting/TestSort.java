package sorting;


public class TestSort {

	public static void main(String[] args) {
		int[] n = {20, 30, 10, 5, 33, 35, 2, 1, 0};//TestUtil.getRandomIntegers(100000);
		TestUtil.print(n);
		qs(n, 0, n.length - 1);
		long time = System.currentTimeMillis();
		//sort.sort(n);
		time = System.currentTimeMillis() - time;
		System.out.println("Sorting of " + n.length + " took " + time + " milliseconds.");
		TestUtil.print(n);
	}
	
	private static void qs(int[] n, int low, int high) {
		int left = low;
		int right = high;
		int pivot = n[((high-low) / 2) + low];
		while (left < right) {
			while (n[left] < pivot) {
				left++;
			}
			while (n[right] > pivot) {
				right--;
			}
			if (left <= right) {
				// swap the values
				int temp = n[left];
				n[left] = n[right];
				n[right] = temp;
				left++;
				right++;
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
