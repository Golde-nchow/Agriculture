package 剑指offer._17;

/**
 * 2019/10/16 :
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * （ps：我们约定空树不是任意一个树的子结构）
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num17 {

    public static void main(String[] args) {

    }

    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return tree1HasTree2(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    public static boolean tree1HasTree2(TreeNode root1, TreeNode root2) {
        // 如果root2已经遍历到没有了，就返回 true，root1还有没有元素都无所谓
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return tree1HasTree2(root1.left, root2.left) &&
                tree1HasTree2(root1.right, root2.right);
    }



}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}