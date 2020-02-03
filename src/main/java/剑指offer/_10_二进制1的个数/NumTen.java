package 剑指offer._10_二进制1的个数;

/**
 * 2019/10/13 :
 * 输入一个整数，输出该数二进制表示中 1 的个数。
 * 其中负数用补码表示。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class NumTen {

    public static void main(String[] args) {
        System.out.println(numberOf1_2(-3));
    }

    /**
     * 不停地向右移，不断地进行 1 的与运算
     */
    public static int numberOf1(int n) {
        // 超时
        int count = 0;
        while (n != 0) {
            count += (n & 1);
            n  = n >> 1;
        }
        return count;
    }

    /**
     * n & (n-1)：把最后一个 1 去掉
     * bin : 11 |  dec: 3
     * bin : 10 |  dec: 2
     * ——————————————————
     * bin : 10
     */
    public static int numberOf1_2(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n-1);
        }
        return count;
    }

}
