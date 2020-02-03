package 剑指offer._49_字符串转整数;

/**
 * 2019/10/28 :
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 * <p>
 * 输入:
 * +2147483647
 * 1a33
 * <p>
 * 输出:
 * 2147483647
 * 0
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num49 {

    public static void main(String[] args) {
        System.out.println(StrToInt("05+1"));
    }

    // 85.71%，不知道哪里没完善
    public static int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean sign = true;
        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (i == 0 && c == '-') {
                sign = false;
            } else if (i == 0 && c == '+') {
                sign = true;
            } else if ('0' <= c && c <= '9') {
                result = result * 10 + (c - 48);
            } else {
                return 0;
            }
        }
        if (sign == false && result >= Integer.MIN_VALUE) {
            return (int) (-result);
        }
        if (sign == true && result <= Integer.MAX_VALUE) {
            return (int) result;
        }
        return 0;
    }

}
