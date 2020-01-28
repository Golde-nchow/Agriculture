package 剑指offer._40;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

/**
 * 2019/10/26 :
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num40 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 3, 1, 6};
        int[] num1 = new int[1];
        int[] num2 = new int[1];

        FindNumsAppearOnce2(arr, num1, num2);
        System.out.println(num1[0] + "=" + num2[0]);
    }

    // num1,num2 分别为长度为1的数组。传出参数
    // 将 num1[0],num2[0] 设置为返回结果
    // 有两种方法，一种是使用数据结构，栈，集合
    // 另一种是使用异或的方法
    public static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (!set.add(array[i])) {
                set.remove(array[i]);
            }
        }
        Object[] objects = set.toArray();
        num1[0] = (int) objects[0];
        num2[0] = (int) objects[1];
    }

    // 使用栈数据结构，首先进行排序
    public static void FindNumsAppearOnce2(int[] array, int[] num1, int[] num2) {
        Arrays.sort(array);
        Stack<Integer> stack = new Stack<>();
        for (int i : array) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (stack.peek() == i) {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        num2[0] = stack.pop();
        num1[0] = stack.pop();
    }
}
