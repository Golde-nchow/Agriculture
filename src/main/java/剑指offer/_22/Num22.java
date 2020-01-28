package 剑指offer._22;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/10/22 :
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num22 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(0);
        TreeNode treeNode5 = new TreeNode(8);
        TreeNode treeNode6 = new TreeNode(11);

        treeNode.left = treeNode1;
        treeNode.right = treeNode2;
        treeNode1.left = treeNode3;
        treeNode1.right = treeNode4;
        treeNode2.left = treeNode5;
        treeNode2.right = treeNode6;

        System.out.println(PrintFromTopToBottom(treeNode));
    }

    /**
     * 借助队列实现
     * 通过不断地移除队列第一个，来实现顺序地打印
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        ArrayList<Integer> list = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while (nodes.size() != 0) {
            TreeNode temp = nodes.remove(0);
            if (temp.left != null) {
                nodes.add(temp.left);
            }
            if (temp.right != null) {
                nodes.add(temp.right);
            }
            list.add(temp.val);
        }
        return list;
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
