package leetcode.backup;

import leetcode.base.TreeNode;

import java.util.Stack;

/**
 * Given a binary tree, find its maximum depth.
 * <p>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Given binary tree [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its depth = 3.
 */
public class Solution104 {


    public int maxDepth(TreeNode root) {
//        return getlevel(root, 0);
        return getDepth(root);
    }

    public int getlevel(TreeNode node, int level) {
        if (node == null) {
            return level;
        }
        int left = getlevel(node.left, level + 1);
        int right = getlevel(node.right, level + 1);
        return left > right ? left : right;
    }


    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        int deep = 0;
        int current = 0;
        int status = 0;
        TreeNode temp = root;
        while (temp != root || status != 2) {
            if (status == 0) {
                if (temp.left == null) {
                    status = 1;
                } else {
                    stack.push(temp);
                    temp = temp.left;
                    status = 0;
                    if (++current > deep) {
                        deep = current;
                    }
                }
            } else if (status == 1) {
                if (temp.right == null) {
                    status = 2;
                } else {
                    stack.push(temp);
                    temp = temp.right;
                    status = 0;
                    if (++current > deep) {
                        deep = current;
                    }
                }

            } else {
                TreeNode father = stack.pop();
                if (father.left == temp) {
                    status = 1;
                } else {
                    status = 2;
                }
                temp = father;
                current--;
            }
        }
        return deep + 1;
    }

}
