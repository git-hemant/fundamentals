package books.cci.ch4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import sun.org.mozilla.javascript.internal.Node;

import books.cci.util.BinaryTree.TreeNode;

/**
 * Given a sorted (increasing order) array, write an algorithm to create a binary tree with minimal height.
 * 
 *	We will try to create a binary tree such that for each node, the number of nodes in the left subtree and the right subtree are equal, if possible.
 *	Algorithm:
 *  1. Insert into the tree the middle element of the array.
 *  2. Insert (into the left subtree) the left subarray elements
 *  3. Insert (into the right subtree) the right subarray elements
 *  4. Recurse 
 */
public class P3_ArrayToBST {
	static int data[] = { 2, 4, 5, 11, 21, 22, 23, 39, 45 };
	
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

	public static void main(String[] args) {
		TreeNode root = createMinimalBST(data);
		System.out.print("BFS -> ");
		showBFS(root);
		System.out.println(""); System.out.print("DFS -> ");
		showDFS(root);
		System.out.println("");
		System.out.println("Max depth in tree is: " + maxDepth(root));
		System.out.println("Min depth in tree is: " + minDepth(root));
		System.out.println("Max depth(no recursion) in tree is: " + maxDepthNoRecursion(root));
		System.out.println("Min depth(no recursion) in tree is: " + minDepthNoRecursion(root));
	}
	
	// Very easy way of doing BFS.
	private static void showBFS(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.remove();
			System.out.print(node + " ");
			if (node.left != null) queue.add(node.left);
			if (node.right != null) queue.add(node.right);
		}
	}

	// Find the maximum depth in the tree without using recursion
	private static int maxDepthNoRecursion(TreeNode root) {
		return Math.max(maxDepthNoRecursion(root, true), maxDepthNoRecursion(root, false)); 
	}
	
	// Find the minimum depth in the tree without using recursion
	private static int minDepthNoRecursion(TreeNode root) {
		return Math.min(maxDepthNoRecursion(root, true), maxDepthNoRecursion(root, false)); 
	}
	
	private static int maxDepthNoRecursion(TreeNode root, boolean left) {
		Stack<TreeNode> stack = new Stack<>();
		stack.add(root);
		int depth = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if (left && node.left != null) stack.add(node.left);
			// Add the right node only if the left node is empty to find max depth
			else if (left && node.left == null && node.right != null) stack.add(node.right); 
			else if (!left && node.right != null) stack.add(node.right);
			// Add the left node only if the right node is empty to find max depth
			else if (!left && node.right == null && node.left != null) stack.add(node.left);
			depth++;
		}
		return depth;
	}
	
	// DFS Uses Stack
	private static void showDFS(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			System.out.print(node + " ");
			// WARNING: Add right first if you want in-order traversal
			// because in stack it is LIFO - so this will ensure
			// left node would be picked up first.
			if (node.right != null) stack.add(node.right);
			if (node.left != null) stack.add(node.left);
		}
	}
	
	// Find the maximum depth in the tree using recursion.
	private static int maxDepth(TreeNode node) {
		if (node == null) return 0;
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

	// Find the minimum depth in the tree using recursion.
	private static int minDepth(TreeNode node) {
		if (node == null) return 0;
		return 1 + Math.min(minDepth(node.left), minDepth(node.right));
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

	public static TreeNode createMinimalBST(int array[]) {
		return addToTree(array, 0, array.length - 1);
	}
}
