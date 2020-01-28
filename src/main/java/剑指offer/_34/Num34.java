package 剑指offer._34;

/**
 * 2019/10/24 :
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成) 中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num34 {

    public static void main(String[] args) {
        String s = "aahhffrxx";
        System.out.println(FirstNotRepeatingChar(s));
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) {
            return -1;
        }
        // 用数组存储每个位置的次数，比如说 a 是 97，那么对应数组下标 97 的位置
        int[] arr = new int[128];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }

}
