package 剑指offer._61_树_序列化二叉树_太难;

/**
 * 2019/11/11 :
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，
 * 从而使得内存中建立起来的二叉树可以持久保存。
 * 序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，
 * 序列化的结果是一个字符串，序列化时通过
 * 某种符号表示空节点（#），
 * 以 ！表示一个结点值的结束（value!）。
 *
 * 根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num61 {



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
