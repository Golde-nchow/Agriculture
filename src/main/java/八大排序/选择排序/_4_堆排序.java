package 八大排序.选择排序;

import java.util.Arrays;

/**
 * 2019/10/19 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class _4_堆排序 {

    public static void main(String[] args) {
        int[] arr = {16,7,3,20,17,8,9,4,2};

        int length = arr.length;

        // 构建最大堆, 保证所有父节点的子树都是小于父节点
        // lenght / 2 - 1 : 最后的一个子树的父节点
        for (int i = length / 2 - 1; i >= 0 ; i--) {
            adjustHeap(arr, i, length);
        }

        for (int i = length - 1; i > 0; i--) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将树根节点下的最大值放到树根
     */
    public static void adjustHeap(int[] arr, int start, int end) {
        int temp = arr[start];
        for (int i = start * 2 + 1; i < end; i = i * 2 + 1) {
            if (i + 1 < end && arr[i] < arr[i+1]) {
                // 如果左子树小于右子树，那么就 focus 到右子树
                i++;
            }
            // 如果focus的节点大于父节点，那么就交换
            if (temp < arr[i]) {
                arr[start] = arr[i];
                start = i;
            } else {
                break;
            }
        }
        arr[start] = temp;
    }

    public static void swap(int[] arr, int beReplaced, int replace) {
        // 第一个与最后一个交换
        int temp = arr[beReplaced];
        arr[beReplaced] = arr[replace];
        arr[replace] = temp;
    }

}
