package 剑指offer._06_斐波那契数列;

/**
 * 2019/9/18 :
 * 大家都知道斐波那契数列，现在要求输入一个整数 n，求出第 n 项的结果。
 *
 * @author User : Golden_chow
 */
public class NumSix {

    public static void main(String[] args) {
        System.out.println(Fibonacci2(6));
    }

    /**
     * 巨多重复计算  1 1 2 3 5 8
     */
    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n-1) + Fibonacci(n-2);
    }

    /**
     * 优化一
     */
    public static int Fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        int sum = 0;
        int one = 0;
        int two = 1;
        for (int i = 2; i <= n; i++) {
            sum = one + two;
            one = two;
            two = sum;
        }
        return sum;
    }

    /**
     * 优化二
     */
    public static int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        int one = 0;
        int sum = 1;
        for (int i = 2; i <= n; i++) {
            sum = sum + one;
            one = sum - one;
        }
        return sum;
    }

}
