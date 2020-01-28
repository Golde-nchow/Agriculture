package 剑指offer._26;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 2019/10/22 :
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 *
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num26 {

    private static LinkedList<TreeNode> list = new LinkedList<>();

    public static void main(String[] args) {

    }

    public static TreeNode Convert(TreeNode pRootOfTree) {
        ArrayList<TreeNode> list = new ArrayList<>();
        if (pRootOfTree == null) {
            return null;
        }

        // 首先使用中序遍历存储到 ArrayList中
        Convert(pRootOfTree, list);

        // 遍历 List，修改指针
        // 把父节点的 right 指向子节点，子节点的 left 指向父节点
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i+1).left = list.get(i);
        }

        return list.get(0);
    }

    public static void Convert(TreeNode pRootOfTree, ArrayList<TreeNode> list) {
        // 一直寻找左子树，并添加
        if (pRootOfTree.left != null) {
            Convert(pRootOfTree.left, list);
        }
        // 添加父节点
        list.add(pRootOfTree);

        // 寻找右子树，并添加
        if (pRootOfTree.right != null) {
            Convert(pRootOfTree.right, list);
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
