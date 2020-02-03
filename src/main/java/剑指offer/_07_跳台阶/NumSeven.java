package 剑指offer._07_跳台阶;

/**
 * 2019/9/18 :
 * 一只青蛙一次可以跳上 1 级台阶，也可以跳上 2 级。
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class NumSeven {

    public static void main(String[] args) {
        System.out.println(jumpFloor(2));
    }

    /**
     * 每一个阶梯的跳法都是根据上一次的跳发的数量来累计的，看多了就明白了，真的不好说
     */
    public static int jumpFloor(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return jumpFloor(target - 1) + jumpFloor(target - 2);

    }
}
