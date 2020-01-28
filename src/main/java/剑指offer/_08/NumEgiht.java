package 剑指offer._08;

/**
 * 2019/10/13 :
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class NumEgiht {

    public static void main(String[] args) {
        System.out.println(jumpFloorII2(1));
    }

    /**
     * f(1)   = f(1-1) = 在台阶只有1的情况下跳1，剩下0
     * f(2)   = f(2-1) + f(2-2)
     * f(3)   = f(3-1) + f(3-2) + f(3-3)
     *             |
     *             ^
     *      f(2-1) 或 f(2-2)
     *
     * f(4)   = f(4-1) + f(4-2) + f(4-3) + f(4-4)
     *            |
     *            ^
     *   f(3-1) + f(3-2) + f(3-3)
     *
     * f(n-1) = f(1) + f(2) + f(3) + ··· + f(n-2) + 1
     * f(n)   = f(1) + f(2) + ··· + f(n-1) + 1 = f(n-1) + f(n-1)
     *
     * 最后的1是因为每次跳台阶，都会有一次是跳n阶的，所以+1
     * 也就是下面的，当target = 0的时候，返回1
     */
    public static int jumpFloorII(int target) {
        if (target == 1 || target == 0) {
            return 1;
        }
        int sum = 0;
        while (target-- > 0) {
            sum += jumpFloorII(target);
        }
        return sum;
    }

    public static int jumpFloorII2(int target) {
        if(target == 1 || target == 0) {
            return 1;
        }
        return 2 * jumpFloorII2(target - 1);
    }

}
