public class ArrayCompareToMax {
	public static void main(String[] args) {
		int array[] = {50, 12, 252, 25, 6, 122, 16323, 63, 3,  5};
		int max = compareToAll(array);
		System.out.println("Max number is:" + max);
	}
	
	// This is the worse algorithm to find maximum number
	// as it is O(N^2), while we can easily find 
	// maximum number by iterating and keep track
	// of biggest number which can be done in O(N)
	static int compareToAll(int array[]) {
		int n = array.length;
		int i, j;
		boolean isMax;
		if (n <= 0) return -1;
		long time = System.currentTimeMillis();
		for (i = n - 1; i > 0; i--) {
			isMax = true;
			for (j = 0; j < n; j++) {
				if (array[j] > array[i]) {
					isMax = false;
				}
			}
			if (isMax) break;
		}
		time = System.currentTimeMillis() - time;
		System.out.println("Time it took: " + time);
		return array[i];
	}
}
