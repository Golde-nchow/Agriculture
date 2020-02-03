package 剑指offer._41_和为S的连续整数序列;

import java.util.ArrayList;

/**
 * 2019/10/27 :
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,
 * 他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 *
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num41 {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> arrayLists = FindContinuousSequence(50);
        System.out.println(arrayLists);
    }

    /**
     * 类似滑动窗口
     * 如果小于SUM，则high+1
     * 如果大于SUM，则low+1
     */
    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 0) {
            return result;
        }

        int high = 2, low = 1;
        int cursum = high + low;
        // high > low 无可厚非
        // low < (sum+1 的一半)，因为 【sum+1 的一半 + 下一个元素】就超过了总大小
        // 为什么要 sum + 1 的一半，因为比如 101，可以是50+51, 如果在 sum / 2, 那么就是 < 50, 但是 low==50 是允许的
        while (high > low && low < (sum + 1) >> 1) {
            if (cursum == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = low; i <= high; i++) {
                    list.add(i);
                }
                result.add(list);
                // 减去一个小的值，窗口向右缩小，然后肯定会在右边加上一个值，实现窗口右移
                cursum -= low;
                low++;

            } else if (cursum > sum) {
                // 如果当前和大于sum，那么就减去一个小的值，窗口向右边缩小
                cursum -= low;
                low++;

            } else {
                // 如果小于sum, 那么就加上一个大值，窗口向右拓展
                high++;
                cursum += high;
            }
        }
        return result;
    }

}
