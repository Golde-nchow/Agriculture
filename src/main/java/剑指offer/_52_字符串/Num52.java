package 剑指offer._52_字符串;

/**
 * 2019/10/29 :
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * <p>
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num52 {

    public static void main(String[] args) {
        char[] arr2 = {'a', 'b'};
        char[] arr1 = {'a', 'b', '*'};
        System.out.println(match(arr2, arr1));
    }

    public static boolean match(char[] str, char[] pattern) {
        /**
         * 思路：比较前两个字符，递归比较
         */
        if (str == null || pattern == null) {
            return false;
        }
        return match(str, 0, pattern, 0);
    }

    public static boolean match(char[] str, int s, char[] pattern, int p) {
        if (s == str.length && p == pattern.length) {
            return true;
        }
        // 如果 s 还没结束，匹配就已经结束了，那么就返回 false
        if (s < str.length && p == pattern.length) {
            return false;
        }
        // 判断第二个字符, 如果第二个字符是*
        if (p + 1 < pattern.length && pattern[p + 1] == '*') {
            // 判断'*'的前一个字符是否相等
            // 如果相等，那么就往下匹配
            if ((s < str.length && str[s] == pattern[p]) || (s < str.length && pattern[p] == '.')) {
                // 第一个字符相等还不够，还需要考虑三种情况
                // 1. str 第一个字符后有多个相等的字符, 这时需要 str 右移，但 parrtern 不移动
                // 2. str 第一个字符后只有一个相等的字符, 不同进行任何操作，因为有了匹配多个，就不用再匹配一个
                // 3. str 第一个字符后没有相等的字符, 这时 str 不移动，pattern 右移
                return match(str, s + 1, pattern, p) ||
                        match(str, s, pattern, p + 2);
            } else {
                return match(str, s, pattern, p + 2);
            }
        }
        // 如果第二个字符不是*
        else {
            // 那么就判断是否相等 或者 是否是'.'
            if ((s < str.length && str[s] == pattern[p]) || (s < str.length && pattern[p] == '.')) {
                return match(str, s + 1, pattern, p + 1);
            }
            // 否则直接返回失败
            else {
                return false;
            }
        }
    }

}
