package sorting;

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
