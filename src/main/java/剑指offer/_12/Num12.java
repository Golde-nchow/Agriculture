package 剑指offer._12;

import java.util.ArrayList;

/**
 * 2019/10/14 :
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num12 {

    public static void main(String[] args) {
        int[] array = new int[]{1, 4, 7, 8, 10, 2, 5};
        reOrderArray2(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    /**
     * 最俗的做法，用两个集合保存奇偶两个数组，然后复制过去
     */
    public static void reOrderArray(int [] array) {
        ArrayList<Integer> odds = new ArrayList<>();
        ArrayList<Integer> evens = new ArrayList<>();
        for (int i : array) {
            if (i % 2 == 0) {
                evens.add(i);
            } else {
                odds.add(i);
            }
        }
        Integer[] result = new Integer[array.length];
        Integer[] oddsArray = odds.toArray(new Integer[odds.size()]);
        Integer[] evensArray = evens.toArray(new Integer[evens.size()]);
        int length = oddsArray.length;
        System.arraycopy(oddsArray, 0, result, 0, length);
        System.arraycopy(evensArray, 0, result, length, evensArray.length);

        for (int i = 0; i < result.length; i++) {
            array[i] = result[i];
        }
    }

    /**
     * 使用冒泡排序思想，进行交换数组元素
     */
    public static void reOrderArray2(int[] array) {
        int size = array.length;
        while (size-- > 0) {
            boolean exit = true;
            // 这里减一是因为需要 arr[i] 和 arr[i+1]
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] % 2 == 0 && array[i + 1] % 2 == 1) {
                    swap(array, i, i + 1);
                    exit = false;
                }
            }
            // 其实上面代码就可以了，但是为了优化一下
            if (exit) {
                return;
            }
        }
    }

    public static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

}
