package 剑指offer._54_字符串;

/**
 * 2019/11/1 :
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 *
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num54 {

    static String str = "";
    static int[] chars = new int[256];
    
    public static void main(String[] args) {

    }

    //Insert one char from stringstream
    public static void Insert(char ch) {
        str += ch;
        chars[ch] = 1;
    }
    //return the first appearence once char in current stringstream
    public static char FirstAppearingOnce() {
        for (int i = 0; i < str.length(); i++) {
            if (chars[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return '#';
    }

}
