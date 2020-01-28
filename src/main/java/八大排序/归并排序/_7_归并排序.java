package 八大排序.归并排序;

import java.util.Arrays;

/**
 * 2019/10/19 :
 * 首先不断地对数组进行二分，先让左右两边的子数组有序，然后再进行合并
 *
 * 比如: {1,3,5,7,4,6,9} 中, {1,3,5,7} 和 {4,6,9} 必须是有序的
 * 我们要做的就是合并两个有序的数组
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class _7_归并排序 {

    public static void main(String[] args) {
        int[] arr = {1,4,0,3,6,45,9};
        sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        // 对左数组进行排序
        sort(arr, start, mid);
        // 对右数组进行排序
        sort(arr, mid + 1, end);
        // 进行合并
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int start, int mid, int end) {
        int[] newArr = new int[end - start + 1];
        // i 是指向数组开始的位置到 mid 的指针, j 是 mid + 1 到数组末尾的指针
        // k 是新数组的开始指针
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (arr[i] < arr[j]) {
                newArr[k++] = arr[i++];
            } else {
                newArr[k++] = arr[j++];
            }
        }
        // 如果左边的子数组还有剩余，那么就放到数组末尾
        while (i <= mid) {
            newArr[k++] = arr[i++];
        }

        // 如果右边的子数组还有剩余，那么就放到数组末尾
        while (j <= end) {
            newArr[k++] = arr[j++];
        }

        // 复制到旧数组中
        for (int l = 0; l < newArr.length; l++) {
            arr[start + l] = newArr[l];
        }
    }

}
