package 剑指offer._37_数字在数组中出现的次数;

import java.util.HashMap;

/**
 * 2019/10/24 :
 * 统计一个数字在有序数组中出现的次数。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num37 {

    public static void main(String[] args) {
        int[] arr = {0,1,2,2,9};
        System.out.println(GetNumberOfK(arr, 2));
    }

    public static int GetNumberOfK(int [] array , int k) {
        // 既然是有序，那么就使用二分查找法,找到第一次出现的位置和最后一次出现的位置
        int first = getFirstIndex(array, k);
        int last = getLastIndex(array, k);
        if (last == -1 || first == -1) {
            return 0;
        }
        return last - first + 1;
    }

    public static int GetNumberOfK2(int [] array , int k) {
        // 这种情况是，既可以有序，也可以无需。
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = hashMap.get(array[i]);
            if (count == null) {
                hashMap.put(array[i], 1);
            } else {
                hashMap.put(array[i], count + 1);
            }
        }
        return hashMap.get(k);
    }

    public static int getFirstIndex(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // 等价于 ( high - low ) / 2 + low
            if (k > array[mid]) {
                low = mid + 1;
            }
            else if (k < array[mid]) {
                high = mid - 1;
            }
            else {
                mid -= 1;
                if (mid < low || array[mid] != k) {
                    return mid + 1;
                } else {
                    high = mid;
                }
            }
        }
        return -1;
    }

    public static int getLastIndex(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2; // 等价于 ( high - low ) / 2 + low
            if (k > array[mid]) {
                low = mid + 1;
            }
            else if (k < array[mid]) {
                high = mid - 1;
            }
            else {
                // 二分查找 k ，找到后，再右慢慢移动，找到非k后，返回mid - 1
                mid += 1;
                if (mid > high || array[mid] != k) {
                    return mid - 1;
                } else {
                    low = mid;
                }
            }
        }
        return -1;
    }

}
