package 剑指offer._62_树;

/**
 * 2019/11/11 :
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。
 * 例如，（5，3，7，2，4，6，8）中，按结点数值大小顺序第三小结点的值为4。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num62 {

    // 避免递归的时候丢失 k
    private int num;

    // 其实就是中序遍历，然后找出对应的值
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k < 1) {
            return null;
        }
        num = k;
        return findKthNode(pRoot);
    }

    TreeNode findKthNode(TreeNode node) {
        TreeNode result = null;
        if (node.left != null) {
            result = findKthNode(node.left);
        }
        if (result == null) {
            if (num == 1) {
                result = node;
            }
            num--;
        }
        if (result == null && node.right != null) {
            result = findKthNode(node.right);
        }
        return result;
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
