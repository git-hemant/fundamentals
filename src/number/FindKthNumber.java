package number;

import java.util.Arrays;

// Find the Kth element in the array in the ascending order.
// If the K is 0 that means we are looking for lowest value
// which is very easy to find in O(N), if we are looking for
// the last element in the array, than also it is very easy to
// find as it means we are looking for maximum number and we can
// find it in O(N), for rest of the values we need to use
// the quick-selection developed by Hoare's which is like 
// quick-sort developed by Hoare, here we do partial sorting
// till Kth element.
public class FindKthNumber {

	public static void main(String[] args) {
		int[] data = {8, 6, 4, 12, 21, 35, 2};
		int kthN = 3;
		System.out.println("Using kth before sort: " + data[kthN]);
		int k = selectKth(data, kthN);
		System.out.println("Kth using kth algo: " + k);
		Arrays.sort(data);
		System.out.println("Kth after sort:" + data[kthN]);
	}
	
	public static int selectKth(int[] arr, int k) {
		if (arr == null || arr.length <= k)
			throw new Error();

		int low = 0, high = arr.length - 1;

		// if from == to we reached the kth element
		while (low < high) {
			int left = low;
			int right = high;
			int mid = arr[(left + right) / 2];

			// stop if the reader and writer meets
			while (left < right) {

				if (arr[left] >= mid) { // put the large values at the end
					int tmp = arr[right];
					arr[right] = arr[left];
					arr[left] = tmp;
					right--;
				} else { // the value is smaller than the pivot, skip
					left++;
				}
			}

			// if we stepped up (r++) we need to step one down
			if (arr[left] > mid)
				left--;

			// the r pointer is on the end of the first k elements
			if (k <= left) {
				high = left;
			} else {
				low = left + 1;
			}
		}

		return arr[k];
	}
	
	public static int selectKthMy(int[] arr, int k) {
		if (arr == null || arr.length <= k)
			throw new Error();

		int low = 0, high = arr.length - 1;
		// if from == to we reached the kth element
		while (low < high) {
			int left = low;
			int right = high;
			int mid = arr[(left + right) / 2];

			// stop if the reader and writer meets
			while (left < right) {

				if (arr[left] >= mid) { // put the large values at the end
					int tmp = arr[right];
					arr[right] = arr[left];
					arr[left] = tmp;
					right--;
				} else { // the value is smaller than the pivot, skip
					left++;
				}
			}

			// if we stepped up (r++) we need to step one down
			if (arr[left] > mid)
				left--;

			// the r pointer is on the end of the first k elements
			if (k <= left) {
				high = left;
			} else {
				low = left + 1;
			}
		}

		return arr[k];
	}
	
}
