package 八大排序.选择排序;

/**
 * 2019/10/19 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class _3_简单选择排序 {

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,7,4};
        int[] ints = sort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // 每次循环，找出后面元素的最小值
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        return arr;
    }

}
