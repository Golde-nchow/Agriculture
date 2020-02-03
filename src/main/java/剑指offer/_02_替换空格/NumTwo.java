package 剑指offer._02_替换空格;

/**
 * 2019/9/16 :
 * 请实现一个函数，将一个字符串中的每个空格替换成 “%20”。
 * 例如，当字符串为 We Are Happy.则经过替换之后的字符串为 We%20Are%20Happy。
 * 这样需要进行扩容和字符的后移，因为 %20 是 3 个字符
 *
 * @author User : Golden_chow
 */
public class NumTwo {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("We Are Happy");
        System.out.println(replaceSpace2(str));
    }

    public static String replaceSpace(StringBuffer str) {
        // 查找出有多少个空格
        int spaceCount = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        // 扩容
        char[] newStr = new char[str.length() + spaceCount * 2];
        int newStrIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                newStr[newStrIndex++] = '%';
                newStr[newStrIndex++] = '2';
                newStr[newStrIndex++] = '0';

            } else {
                newStr[newStrIndex] = c;
                newStrIndex++;
            }
        }

        return new String(newStr);
    }

    public static String replaceSpace2(StringBuffer str) {
        StringBuffer newStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                newStr.append("%20");
            } else {
                newStr.append(str.charAt(i));
            }
        }
        return newStr.toString();
    }
}
