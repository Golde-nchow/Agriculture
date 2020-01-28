package 八大排序.插入排序;

/**
 * 2019/10/17 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class _1_直接插入排序 {

    public static void main(String[] args) {
        int[] arr = {3,1,2,5,7,4};
        int[] ints = sort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 首先遍历到指定的下标，然后比较该下标前的所有元素，小于则交换，并往前移
     */
    public static int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
                j--;
            }
        }
        return arr;
    }

}
