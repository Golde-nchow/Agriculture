package 剑指offer._63_进制转换;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2019/11/11 :
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。
 * <p>
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 我们使用Insert()方法读取数据流，
 * 使用GetMedian()方法获取当前读取数据的中位数。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num63 {

    // 右边部分最小
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    // 左边部分最大
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    static int count = 0;

    // 构建最大堆和最小堆
    public static void main(String[] args) {
        int[] arrs = new int[]{7, 1, 5, 9, 6,10};
        for (int i : arrs) {
            Insert(i);
        }
        System.out.println(GetMedian());
    }

    public static void Insert(Integer num) {
        count++;
        if (count % 2 == 0) {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);

        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        }
    }

    public static Double GetMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek() / 1.0;
        } else {
            return minHeap.peek() / 1.0;
        }
    }

}
