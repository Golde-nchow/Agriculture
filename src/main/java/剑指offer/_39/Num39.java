package 剑指offer._39;

/**
 * 2019/10/26 :
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 *
 * 平衡二叉树就是AVL树，
 * 它首先是二叉搜索树（左小右大），
 * 其次满足左右子树高度之差不超过1。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num39 {

    public boolean IsBalanced_Solution(TreeNode root) {
        // 空树也是平衡二叉树
        if (root == null) {
            return true;
        }
        if (getDepth(root) == -1) {
            return false;
        }
        return true;
    }

    public static int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 获取左子树的长度
        int left = getDepth(root.left);
        int right = getDepth(root.right);
        // 两个数相减，取绝对值
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            // 取最大的个数.
            return left > right ? left + 1 : right + 1;
        }

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
