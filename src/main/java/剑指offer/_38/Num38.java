package 剑指offer._38;

import java.util.ArrayList;

/**
 * 2019/10/24 :
 * 输入一棵二叉树，求该树的深度。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num38 {

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(5);

        treeNode.right = treeNode2;

        System.out.println(TreeDepth(treeNode));
    }

    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果是 2.right = 5, 那么左边是 null，会打印深度为 1
//        if (root.left == null || root.right == null) {
//            return 1;
//        }
        int leftDepth = TreeDepth(root.left);
        int rightDepth = TreeDepth(root.right);
        int depth = leftDepth > rightDepth ? leftDepth : rightDepth;
        return depth + 1;
    }
}

@SuppressWarnings("all")
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
