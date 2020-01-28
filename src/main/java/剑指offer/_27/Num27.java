package 剑指offer._27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 2019/10/23 :
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc, 则打印出由字符a,b,c所能排列出来的所有字符串
 *
 * abc,acb,bac,bca,cab和cba。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num27 {

    // 需要升序的顺序，校验null
    public static void main(String[] args) {
        String s = "caa";
        ArrayList<String> list = Permutation(s);
        for (String s1 : list) {
            System.out.println(s1);
        }
    }

    // 全排列，dfs
    // 视频讲解：https://www.bilibili.com/video/av9830088?from=search&seid=10450908178073153317
    // 讲得很清晰
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> result = new ArrayList<>();
        if (str == null || str.length() == 0 || str.length() > 9) {
            return result;
        }
        char[] array = str.toCharArray();
        Permutation(array, 0, array.length - 1, result);
        Collections.sort(result);
        return result;
    }

    public static ArrayList<String> Permutation(char[] chars, int start, int end, ArrayList<String> list) {
        HashSet<Character> repeactCheck = new HashSet<>();
        if (start == end) {
            list.add(new String(chars));
        }
        for (int i = start; i <= end; i++) {
            // 重复数据校验
            if (!repeactCheck.contains(chars[i])) {
                repeactCheck.add(chars[i]);
                swap(chars, start, i);
                Permutation(chars, start + 1, end, list);
                swap(chars, start, i);
            }
        }
        return list;
    }

    public static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
