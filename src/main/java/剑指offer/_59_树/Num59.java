package 剑指offer._59_树;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 2019/11/1 :请实现一个函数按照之字形打印二叉树，
 *
 * 即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num59 {

    // 使用两个栈实现, 一个存储奇数层, 一个存储偶数层
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) {
            return result;
        }
        int layers = 1;
        Stack[] stacks = new Stack[2];
        stacks[0] = new Stack();
        stacks[1] = new Stack();
        stacks[1].push(pRoot);

        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            // 每一层都需要一个新的集合来存储
            ArrayList<Integer> row = new ArrayList<>();
            // 对2取余计算出对应哪个栈
            int count = layers % 2;
            while (!stacks[count].isEmpty()) {
                TreeNode temp = (TreeNode) stacks[count].pop();
                if (count == 1) {
                    if (temp.left != null) {
                        stacks[0].push(temp.left);
                    }
                    if (temp.right != null) {
                        stacks[0].push(temp.right);
                    }

                } else {
                    if (temp.right != null) {
                        stacks[1].push(temp.right);
                    }
                    if (temp.left != null) {
                        stacks[1].push(temp.left);
                    }
                }
                row.add(temp.val);
            }
            result.add(row);
            layers++;
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