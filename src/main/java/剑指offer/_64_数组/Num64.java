package 剑指offer._64_数组;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 2019/11/12 :
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}；
 *
 * 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 *
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num64 {

    public static void main(String[] args) {
        System.out.println(maxInWindows(new int[]{2,3,4,2,6,2,5,1}, 3));
    }

    public static ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1 || size > num.length) {
            return result;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!queue.isEmpty() && queue.peek() + size < i + 1) {
                queue.poll();
            }
            while (!queue.isEmpty() && num[queue.getLast()] <= num[i]) {
                queue.removeLast();
            }
            queue.add(i);
            if (i >= size - 1) {
                result.add(num[queue.peek()]);
            }
        }
        return result;
    }

}
