package 剑指offer._48_不用加减乘除做加法;

/**
 * 2019/10/28 :
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num48 {

    public static void main(String[] args) {
        System.out.println(Add(4, 1));
    }

    public static int Add(int num1, int num2) {
        // 那么就会出现 0 的情况, 因为不会自动进位
        int sum = 0, carry = 1;
        while (carry != 0) { //进位不等于0就循环加
            sum = num1 ^ num2;
            carry = (num1 & num2) << 1;
            num1 = sum;
            num2 = carry;
        }
        return num1;
    }

}
