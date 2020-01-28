package 八大排序.交换排序;

import java.util.Arrays;

/**
 * 2019/10/19 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class _5_冒泡排序 {

    public static void main(String[] args) {
        int[] arr = {2,5,3,7,1,0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
