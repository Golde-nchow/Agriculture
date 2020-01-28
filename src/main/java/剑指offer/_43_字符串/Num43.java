package 剑指offer._43_字符串;

/**
 * 2019/10/27 :
 * 汇编语言中有一种移位指令叫做循环左移（ROL），
 * 现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 *
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，
 *
 * 即“XYZdefabc”。是不是很简单？OK，搞定它！
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num43 {

    public static void main(String[] args) {
        System.out.println(LeftRotateString("abcXYZdef", 5));
    }

    public static String LeftRotateString(String str,int n) {
        if (str == null || n < 0) {
            return str;
        }
        char[] chars = str.toCharArray();
        // 如果大于等于字符串长度，直接返回字符串
        if (n > chars.length) {
            return str;
        }
        char[] temp = new char[n];
        for (int i = 0; i < n; i++) {
            temp[i] = chars[i];
        }
        for (int i = 0; i < chars.length - n; i++) {
            chars[i] = chars[i+n];
        }
        for (int i = chars.length - n, j = 0; i < chars.length; i++, j++) {
            chars[i] = temp[j];
        }
        return new String(chars);
    }

}
