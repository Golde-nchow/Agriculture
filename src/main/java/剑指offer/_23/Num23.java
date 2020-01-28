package 剑指offer._23;

/**
 * 2019/10/22 :
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。
 *
 * 假设输入的数组的任意两个数字都互不相同。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num23 {

    public static void main(String[] args) {
        int[] arr = {2,9,5,16,17,15,19,18,12};
        boolean squenceOfBST = VerifySquenceOfBST(arr);
        System.out.println(squenceOfBST);
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) {
            return false;
        }
        if (sequence.length == 1) {
            return true;
        }
        return search(sequence, 0, sequence.length - 1);
    }

    /**
     * 首先找到根节点，然后找到左子树和右子树
     * 再对左子树和右子树进行分析
     */
    public static boolean search(int[] sequence, int start, int end) {

        if (start > end) {
            return true;
        }

        // 获取右子树
        int i = end;
        while (i > start && sequence[i - 1] >= sequence[end]) {
            i--;
        }
        // 检查左树是否有大于根节点的值
        for (int j = start; j < i - 1; j++) {
            if (sequence[j] >= sequence[end]) {
                return false;
            }
        }
        // 分别检查左树和右树
        return search(sequence, start, i - 1) && search(sequence, i, end - 1);
    }

}
