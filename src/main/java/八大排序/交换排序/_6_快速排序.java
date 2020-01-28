package 八大排序.交换排序;

import java.util.Arrays;

/**
 * 2019/10/19 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class _6_快速排序 {

    public static void main(String[] args) {
        int[] arr = {7,1,3,8,12,11,2,9};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int first, int last) {
        if (last <= first) {
            return;
        }
        int pivot = arr[first];
        int i = first, j = last;

        // 首先通过一次遍历，把数组分为两个部分
        while (i != j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            while (i < j && arr[i] <= pivot) {
                i++;
            }
            int temp2 = arr[i];
            arr[i] = arr[j];
            arr[j] = temp2;
        }

        // 对左部分进行快排
        sort(arr, first, i - 1);

        // 对右部分进行快排
        sort(arr, i + 1, last);
    }

}
