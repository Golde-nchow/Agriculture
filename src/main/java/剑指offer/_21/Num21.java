package 剑指offer._21;

import java.util.Stack;

/**
 * 2019/10/22 :
 * 输入两个整数序列，
 * 第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否可能为该栈的弹出顺序。
 *
 * 假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，
 * 但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 *
 * 比如栈的高度是4，那么只能存1、2、3、4，而5的存放就需要栈弹一个元素，所以是4
 * 顺序就是 4、5、3、2、1
 *
 * （注意：这两个序列的长度是相等的）
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num21 {

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {3,4,5,2,1};
        System.out.println(IsPopOrder(pushA, popA));
    }

    /**
     * 1 2 3 4 5
     *
     * 栈的层数为 4:  4 5 3 2 1
     * 栈的层数为 3:  3 4 5 2 1
     * 栈的层数为 2:  2 3 4 5 1
     * 栈的层数为 1:  1 2 3 4 5
     *
     * 找出规律即可:
     * 所以用一个栈保存 pushA 的一个或多个元素，如果在 popA 遇到相同的就从栈移除,
     * 如果最后栈为空，那么就说明是弹出顺序
     */
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length) {
            return false;
        }

        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty();
    }

}
