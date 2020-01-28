package 剑指offer._35;

/**
 * 2019/10/24 :
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 *
 * 1,2,3,4,5,6,7,0
 *
 * 输出: 7
 *
 * 1 > 0, 2 > 0, 3>0, ... 7 > 0，所以有7个
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num35 {

    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = {8,2,3,4,5,6,7,0};
        System.out.println(InversePairs(arr));
    }

    public static int InversePairs(int [] array) {
        sort(array, 0, array.length - 1);
        return count;
    }

    public static void sort(int[] array, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        // 对左数组进行排序
        sort(array, start, mid);
        // 对右数组进行排序
        sort(array, mid + 1, end);
        // 合并
        merge(array, start, mid, end);
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int i = start, j = mid + 1, k = 0;
        int[] newArr = new int[end - start + 1];
        while (i <= mid && j <= end) {
            if (array[i] <= array[j]) {
                newArr[k++] = array[i++];
            } else {
                // {1,5,7,9,2,3,6} 可以试验一下
                count += (mid - i + 1) % 1000000007;
                newArr[k++] = array[j++];
            }
        }
        // 如果左数组还有剩余的元素，全部插入到新数组末尾
        while (i <= mid) {
            newArr[k++] = array[i++];
        }

        // 如果右数组还有剩余的元素，全部插入到新数组末尾
        while (j <= end) {
            newArr[k++] = array[j++];
        }

        // 把新数组元素移动到旧数组中
        for (int l = 0; l < newArr.length; l++) {
            array[l + start] = newArr[l];
        }
    }

}
