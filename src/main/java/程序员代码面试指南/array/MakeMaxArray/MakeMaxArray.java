package 程序员代码面试指南.array.MakeMaxArray;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * TODO 2019/2/25 :
 * 求出每个窗口状态下的最大值
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class MakeMaxArray {

    public static void main(String[] args) {
        int[] numbers = new int[]{4,3,5,4,3,3,6,7};
        int[] maxArray = getMaxArray(numbers, 3);
        for (int i : maxArray) {
            System.out.println(i);
        }
    }

    /**
     * 失败品，不但做出了O(Nxw)的时间复杂度，还把一些东西写死了
     * @param source 数组
     * @param windowNum 窗口大小
     * @return maxArray
     */
    public static int[] getMaxArray1(int[] source, int windowNum) {
        int[] result = new int[source.length - windowNum + 1];
        int[] window = Arrays.copyOfRange(source, 0, windowNum);
        int max = 0;
        int time = 0;
        int index = 2;
        for (int i = 2; i < source.length; i++) {
            // 由于window先要比较一次，所以要避免一开始就被修改了
            // [1,2,3]4 -> 1[2,3,4]
            window[windowNum - 3] = window[windowNum - 2];
            window[windowNum - 2] = window[windowNum - 1];
            window[windowNum - 1] = source[i];
            // 比较大小
            max = window[0];
            for (int j = 1; j < window.length; j++) {
                if (window[j] > max) {
                    max = window[j];
                }
            }
            result[time++] = max;
        }
        return result;
    }

    /**
     * 时间复杂度为 O(n)
     * @param oringin
     * @param windowSize
     * @return
     */
    public static int[] getMaxArray(int[] oringin, int windowSize) {
        // 1、前提条件筛选
        if (oringin == null || windowSize < 1 || oringin.length < windowSize) {
            return null;
        }
        // 双端队列
        LinkedList<Integer> windows = new LinkedList<>();
        // 存放每次窗口的最大值数组
        int[] maxArray = new int[oringin.length - windowSize + 1];
        int index = 0;
        // 遍历源数组
        for (int i = 0; i < oringin.length; i++) {
            // 把队列最后一个和当前的对比，如果小于等于当前的就把最后一个移除掉
            // 把最大值添加到队列首
            while (!windows.isEmpty() && oringin[windows.peekLast()] <= oringin[i]) {
                windows.pollLast();
            }
            // 如果队列有元素大于当前的，或者队列为空（当前的都大于队列的），就添加到队列末
            windows.addLast(i);
            // windows.peekFirst弹出来的是最大值的下标.
            // 如果连续3次遇到比队列中最大值小的，
            // 很容易让队列中的个数超过了窗口大小（3），
            // 这时候只能让最大值去掉，来实现滑动
            if (windows.peekFirst() == i - windowSize) {
                windows.pollFirst();
            }
            // 因为一定要凑齐窗口数量才开始比较，所以索引一定要大于等于2
            if (i >= windowSize - 1) {
                maxArray[index++] = oringin[windows.peekFirst()];
            }
        }
        return maxArray;
    }
}
