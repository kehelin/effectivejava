package leetcode.backup;

import javax.xml.soap.Node;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution654 {
	public TreeNode constructMaximumBinaryTree(int[] nums) {

		TreeNode root = new TreeNode(nums[0]);
		for(int i = 1;i< nums.length;i++) {
			root = insert(root,nums[i]);
		}
		return root;
	}

	public TreeNode insert(TreeNode node, int num) {
		if(num> node.val) {
			TreeNode newNode = new TreeNode(num);
			newNode.left = node;
			return newNode;
		}
		if(node.right == null){
			node.right = new TreeNode(num);
		}else {
			node.right = insert(node.right,num);
		}
		return node;
	}


	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val=x;
		}
	}
}
