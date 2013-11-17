package books.cci.util;

public class BinaryTree {
	
	/**
	 * The following BST would be created using the above
	 * data.
	 *                          21
	 *                        /    \
	 *                       4      23
	 *                     /  \    / \ 
	 *                    2    5  22  39
	 *                          \      \ 
	 *                          11     45
	 */ 
	public static TreeNode getBinaryTree() {
		int data[] = { 2, 4, 5, 11, 21, 22, 23, 39, 45 };
		return createMinimalBST(data);
	}
	
	public static TreeNode createMinimalBST(int array[]) {
		return addToTree(array, 0, array.length - 1);
	}

	public static TreeNode addToTree(int arr[], int start, int end) {
		if (end < start) {
			return null;
		}
		// Keep dividing the array and create tree nodes.
		int med = (start + end) / 2;
		TreeNode node = new TreeNode(arr[med]);
		node.left = addToTree(arr, start, med - 1);
		node.right = addToTree(arr, med + 1, end);
		return node;
	}

	public static class TreeNode {
		Object data;
		public TreeNode left, right;

		public TreeNode(int data) {
			this.data = data;
		}

		public String toString() {
			return data.toString();
		}
	}

}
