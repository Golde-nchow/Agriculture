package 剑指offer._53_字符串;

/**
 * 2019/11/1 :
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 *
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num53 {

    public static void main(String[] args) {
        System.out.println(isNumeric(new char[]{'+', '1', 'e', '5'}));
    }

    // 两种方法，一种直接判断，另一种是正则
    public static boolean isNumeric(char[] str) {
        if (str == null) {
            return false;
        }
        // 是否有 E、（+-）、小数点
        boolean hashE = false, sign = false, decimal = false;

        for (int i = 0; i < str.length; i++) {
            // 如果存在 e ，就判断是否已经有 e 或者 e 后面没指数
            if (str[i] == 'e' || str[i] == 'E') {
                // 如果是 E
                // 必须有指数，所以不能为最后一位
                if (i == str.length - 1) {
                    return false;
                }
                // 也不能已经存在
                if (hashE) {
                    return false;
                }
                hashE = true;

            } else if (str[i] == '+' || str[i] == '-') {
                // 如果是符号
                // 第一次只能出现在开头或者E之后
                // 第二次只能在E之后
                if (!sign && i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    // 出现第一次
                    return false;
                }
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E') {
                    // 出现第二次
                    return false;
                }
                sign = true;

            } else if (str[i] == '.') {
                // 如果是小数点
                // 指数不能有小数点
                if (decimal || hashE) {
                    return false;
                }
                decimal = true;

            } else if ('9' < str[i] || str[i] < '0') {
                // 如果是非法数字
                return false;
            }
        }
        return true;
    }
}
