package 剑指offer._11_数值的整数次方;

/**
 * 2019/10/13 :
 * 给定一个 double类型 的浮点数base 和 int类型 的整数 exponent。
 * 求base的exponent次方。
 *
 * 保证base和exponent不同时为0
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num11 {

    public static void main(String[] args) {
        System.out.println(power(-100.0, -2));
    }

    public static double power(double base, int exponent) {
        // 判断指数是否为负数
        int e = exponent < 0 ? -exponent : exponent;
        if (base == 1 || e == 0) {
            return 1.0d;
        }
        if (e == 1 || base == 0.0) {
            return base;
        }
        base *= power(base, e - 1);
        // 如果指数为负数，则转换为分数
        return exponent < 0 ? 1 / base : base;
    }

}
