package algorithm.tree;

/**
 * Created by wangminghui on 2017/3/7.
 */
public class TestTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode("a");
        TreeNode t2 = new TreeNode("b");
        t1.setLeft(t2);
        TreeNode t3 = new TreeNode("c");
        t1.setRight(t3);
        TreeNode t4 = new TreeNode("d");
        t2.setLeft(t4);
        TreeNode t5 = new TreeNode("e");
        t4.setRight(t5);
        TreeNode t6 = new TreeNode("f");
        t2.setRight(t6);
        TreeNode t7 = new TreeNode("g");
        t6.setLeft(t7);

        front(t1);


    }
    public static void front(TreeNode node) {
        if (node.left != null) {
            front(node.left);
        }
        System.out.print(node.value);
        if(node.right != null) {
            front(node.right);
        }
    }


}
class TreeNode {
    public TreeNode(String value) {
        this.value = value;
    }

    TreeNode left;
    TreeNode right;
    String value;
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getLeft() {
        return this.left;
    }
    public void setRight (TreeNode right) {
        this.right = right;
    }
    public TreeNode getRight () {
        return right;
    }

}

