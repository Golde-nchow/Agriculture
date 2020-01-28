package 剑指offer._16;

import java.util.Arrays;

/**
 * 2019/10/15 :
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列 {1,2,4,7,3,5,6,8}
 * 和
 * 中序遍历序列 {4,7,2,1,5,3,8,6}，则重建二叉树并返回
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num16 {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
        System.out.println(treeNode);
    }

    public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < in.length; i++) {
            // 找到根节点
            if (in[i] == pre[0]) {
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, 1, i+1),
                        Arrays.copyOfRange(in,0, i)
                );
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre, i + 1, pre.length),
                        Arrays.copyOfRange(in, i + 1, in.length)
                );
                break;
            }
        }
        return root;
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int preStart, int endPre, int[] in, int inStart, int endIn) {
        if(preStart > endPre || inStart > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preStart]);
        for (int i = inStart; i <= endIn; i++) {
            if (pre[preStart] == in[i]) {
                // preStart+1 : 前序遍历的第一个都是根节点，所以每次都找出第一个元素在中序遍历中的位置即可
                // preStart + i - inStart : 找出中序遍历左树的长度，并计算出在前序遍历的结束下标, i - inStart 长度, + preStart 是下标
                root.left = reConstructBinaryTree(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);

                // i - inStart + preStart + 1 : i - inStart 是计算左树长度，绕过了左树才能到达右树, + preStart 是前序遍历下标, 因为右树在右边，所以要 + 1
                root.right = reConstructBinaryTree(pre, i - inStart + preStart + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}