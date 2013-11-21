package books.cci.ch4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import books.cci.util.BinaryTree;
import books.cci.util.BinaryTree.TreeNode;

/**
 * Given a binary search tree, design an algorithm which creates a linked list
 * of all the nodes at each depth (eg, if you have a tree with depth D, you’ll
 * have D linked lists).
 * 
 * Solution: We can do a simple level by level traversal of the tree, with a
 * slight modification of the breath-first traversal of the tree. In a usual
 * breath first search traversal, we simply traverse the nodes without caring
 * which level we are on. In this case, it is critical to know the level. We
 * thus use a dummy node to indicate when we have finished one level and are
 * starting on the next.
 */
public class P4_BSTToBFSLevelList {
	
	public static void main(String[] args) {
		TreeNode node = BinaryTree.getBinaryTree();
		List<LinkedList<TreeNode>> list = findLevelLinkList(node);
		int level = 0;
		for (LinkedList<TreeNode> ll : list) {
			System.out.println("Level " + ++level + " -> " + ll);
		}
	}

	static List<LinkedList<TreeNode>> findLevelLinkList(TreeNode root) {
		List<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> list = new LinkedList<TreeNode>();
		// Add the first node - as root will be only one at this level.
		list.add(root);
		result.add(list);
		int level = 0;
		while (true) {
			// Now use the result as queue for BFS here
			list = new LinkedList<TreeNode>();
			// Iterate over each node which we added in previous level
			// as we are iterating over all the children of previous level now.
			for (TreeNode node : result.get(level)) {
				if (node.left != null) list.add(node.left);
				if (node.right != null) list.add(node.right);
			}
			
			// If we didn't got any children in this entire level
			// then terminate
			if (list.size() == 0) break;
			
			// Otherwise add this level in the result.
			result.add(list);
			level++;
		}
		return result;
	}
}
