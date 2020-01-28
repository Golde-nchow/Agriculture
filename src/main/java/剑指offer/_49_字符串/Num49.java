package 剑指offer._49_字符串;

/**
 * 2019/10/28 :
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 *
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * 输入:
 * +2147483647
 *    1a33
 *
 * 输出:
 *  2147483647
 *      0
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num49 {

    public static void main(String[] args) {
        System.out.println(StrToInt("-56875"));
    }

    public static int StrToInt(String str) {
        char[] chars = str.toCharArray();
        int sign = chars[0] == '-' ? -1 : 1; // 默认代表是整数
        String newStr = "";
        // 先判断每个字符
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '-') {
                sign = -1;

            } else if (chars[i] == '+') {
                sign = 1;

            } else if ('0' <= chars[i] && chars[i] <= '9') {
                newStr += chars[i];

            } else {
                // 不是数字
                return 0;
            }
        }

        chars = newStr.toCharArray();
        int result = 0;
        // 字符串转为数字
        for (int i = 0; i < chars.length; i++) {
            // 这里减48是因为，'0'是48, 想要 '0' 成为0，就需要 48 - 48 = 0
            result = result * 10 + (chars[i] - 48);
        }

        if (sign == -1 && (result * -1) >= Integer.MIN_VALUE) {
            return result * -1;
        }
        if (sign == 1 && result <= Integer.MAX_VALUE) {
            return result;
        }

        return 0;
    }

}
