package 剑指offer._57_树;

/**
 * 2019/11/1 :
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 *
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num57 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        TreeLinkNode result = null;
        // 如果给定节点有右子树，那么下一个节点则为它的右子树
        if (pNode.right != null) {
            result = pNode.right;
            while (result.left != null) {
                result = result.left;
            }
        }
        else {
            TreeLinkNode parent = pNode.next == null ? null : pNode.next;
            // 如果给定节点没有右子树，并且是父节点的左树，那么下一个节点是它的父节点
            if (parent != null && pNode == parent.left) {
                result = parent;

            }
            // 如果给定节点没有右子树，并且是父节点的右树，那么下一个节点是顺着父节点向上查找，
            // 如果节点是左节点，那么取出该节点的父节点
            else if (parent != null && pNode == parent.right) {
                while (parent.next != null && parent != parent.next.left) {
                    parent = parent.next;
                }
                result = parent.next;
            }
        }
        return result;
    }
}

@SuppressWarnings("all")
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null; // 这个指向指定节点的父节点

    TreeLinkNode(int val) {
        this.val = val;
    }
}