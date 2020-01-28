package 八大排序.插入排序;

/**
 * 2019/10/18 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class _2_希尔排序 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 5, 7, 4};
        int[] ints = sort(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 希尔排序就是跳跃版的插入排序，插入排序每次向前面比较一次
     */
    public static int[] sort(int[] arr) {
        int gap = arr.length / 2;
        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap && arr[j-gap] > arr[j]; j-= gap) {
                    // swap
                    int temp = arr[j-gap];
                    arr[j-gap] = arr[j];
                    arr[j] = temp;
                }
            }
            gap /= 2;
        }
        return arr;
    }

    /**
     * 通过 Kunth 序列，效率比折半高
     */
    public static int[] sortByKunth(int[] arr) {
        // Kunth序列
        int h = 1;
        while (h <= h / 3) {
            h = 3 * h + 1;
        }

        while (h > 0) {
            for (int i = h; i < arr.length; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = temp;
                }
            }
            h = (h - 1) / 3;
        }
        return arr;
    }

}
