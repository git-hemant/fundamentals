package books.cci.ch4;


public class P3 {
	static int data[] = { 2, 4, 5, 11, 21, 22, 23, 39, 45 };

	public static void main(String[] args) {
		TreeNode root = createMinimalBST(data);
		System.out.println(root);
	}
	
	public static TreeNode addToTree(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		int mid = (start + end) / 2;
		TreeNode n = new TreeNode(arr[mid]);
		n.left = addToTree(arr, start, mid - 1);
		n.right = addToTree(arr, mid + 1, end);
		return n;
	}

	public static TreeNode createMinimalBST(int array[]) {
		return addToTree(array, 0, array.length - 1);
	}
	
	static class TreeNode {
		Object data;
		TreeNode left, right;
		TreeNode(int data) { this.data = data;}
		public String toString() { return data.toString(); }
	}
}
