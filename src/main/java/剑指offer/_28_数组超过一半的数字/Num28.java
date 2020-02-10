package 剑指offer._28_数组超过一半的数字;

import java.util.Arrays;

/**
 * 2019/10/24 :
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组 {1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。
 * 如果不存在则输出0。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num28 {

    public static void main(String[] args) {
        int[] array = {2, 4, 2, 6, 7, 2, 2};
        int num = MoreThanHalfNum_Solution2(array);
        System.out.println(num);
    }

    // 排序后判断中间的数字的个数
    public static int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        Arrays.sort(array);
        int mid = array.length >> 1;
        int num = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == array[mid]) {
                num++;
            }
        }
        return num > mid ? array[mid - 1] : 0;
    }

    // 找出第一个数字，下一个相同则+1，否则-1
    // 找到剩余到最后的数字，然后再对该数组进行查找
    // 如果是大于一半长度的数字，再怎么减，都不用怕等于0
    public static int MoreThanHalfNum_Solution2(int[] array) {
        int num = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (count == 0) {
                num = array[i];
                count = 1;
            } else if (num == array[i]) {
                count++;
            } else {
                count--;
            }
        }
        // 进行确认
        count = 0;
        for (int i = 0; i < array.length; i++) {
            if (num == array[i]) {
                count++;
            }
        }
        return count > array.length >> 1 ? num : 0;
    }

}
