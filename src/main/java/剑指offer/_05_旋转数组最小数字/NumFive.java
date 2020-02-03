package 剑指offer._05_旋转数组最小数字;

/**
 * 2019/9/17 :
 * 把一个数组最开始的【若干个元素搬到数组的末尾】，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组 {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author User : Golden_chow
 */
public class NumFive {
    public static void main(String[] args) {
        // 二分查找法不能查找这种非递减的
        int[] arr = {3, 3, 3, 3, 3, 1, 2};
        int min = minNumberInRotateArray2(arr);
        System.out.println(min);
    }

    /**
     * 普通二分查找法 - 不能解决重复数字问题
     */
    public static int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        }
        int high = array.length - 1;
        int low = 0;

        while (low <= high) {
            int mid = (high + low) / 2;

            if (array.length == 1) {
                return array[0];
            }
            // 6 8 1 2 5
            if (array[mid] < array[mid - 1]) {
                return array[mid];
            }
            // 6 8 10 1 5
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            // 4 5 6 7 8 9 10 1 2 3，9为mid
            if (array[mid] > array[0]) {
                low = mid + 1;

            } else {
                // 8 9 10 1 2 3 4 5 6 7，3为mid
                high = mid - 1;
            }
        }
        return 0;
    }

    /**
     * 改良后的二分查找法
     */
    public static int minNumberInRotateArray2(int[] array) {
        int low = 0;
        int high = array.length - 1;
        while (low < high) {
            // 正常来说，low所在的元素不可能小于high的，除非是排好序
            if (array[low] < array[high]) {
                return array[low];
            }

            int mid = (low + high) >> 2;
            if (array[mid] > array[low]) {
                low = mid + 1;
            }
            else if (array[mid] < array[high]) {
                high = mid;
            }
            else {
                low++;
            }
        }
        return array[low];
    }
}
