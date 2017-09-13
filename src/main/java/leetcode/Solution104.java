package leetcode;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        return getlevel(root,0);
    }
    public int getlevel(TreeNode node,int level){
        if(node ==null) {
            return level;
        }
        int left =getlevel(node.left,level+1);
        int right = getlevel(node.right, level+1);
        return left>right?left:right;
    }


}
