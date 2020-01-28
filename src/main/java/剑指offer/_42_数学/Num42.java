package 剑指offer._42_数学;

import java.util.ArrayList;

/**
 * 2019/10/27 :
 * 输入一个递增排序的数组和一个数字 S，
 * 在数组中查找两个数，使得他们的和正好是 S，
 * 如果有多对数字的和等于 S，输出两个数的乘积最小的。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num42 {

    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 7, 9};
        System.out.println(FindNumbersWithSum(arr, 9));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        // 自己写的这种是无序状态下的，如果有序状态下的，直接找到后返回就行，因为是有序的
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (sum == (array[i] + array[j])) {
                    if (list.size() == 0) {
                        list.add(array[i]);
                        list.add(array[j]);
                    } else {
                        if (list.get(0) * list.get(1) > array[i] + array[j]) {
                            list.set(0, array[i]);
                            list.set(1, array[j]);
                        }
                    }
                }
            }
        }
        return list;
    }

    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int low = 0, high = array.length - 1;
        while (low < high) {
            int curSum = array[low] + array[high];
            if (curSum == sum) { //找到一个解
                res.add(array[low]);
                res.add(array[high]);
                // 直接返回
                break;
            } else if (curSum < sum) {
                low++;
            } else {
                high--;
            }
        }
        return res;
    }

}
