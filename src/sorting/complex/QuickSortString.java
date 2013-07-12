package sorting.complex;

public class QuickSortString {
	private static void sortA(String[] s, int start, int end) {
		if (end > start) {
			int pivot = partition(s, start, end);
			sortA(s, start, pivot - 1);
			sortA(s, pivot + 1, end);
		}
	}

	private static int partition(String[] s, int start, int end) {
		String pivot = s[end];
		int left = start;
		int right = end;
		String temp = "";
		do {
			while ((s[left].compareTo(pivot) <= 0) && (left < end))
				left++;
			while ((s[right].compareTo(pivot) > 0) && (right > start))
				right--;
			if (left < right) {
				temp = s[left];
				s[left] = s[end];
				s[right] = temp;
			}
		} while (left < right);
		temp = s[left];
		s[left] = s[end];
		s[end] = temp;
		return left;
	}
}
