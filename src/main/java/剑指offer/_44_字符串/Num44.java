package 剑指offer._44_字符串;

/**
 * 2019/10/27 :
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * <p>
 * 同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * <p>
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num44 {

    public static void main(String[] args) {
        System.out.println(ReverseSentence("student. a am I"));
    }

    public static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        // 结果: I ma a .tneduts
        reverseStr(chars, 0, chars.length - 1);
        // 对每个字符串进行反转
        int begin = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                // 减一是为了回到该字符串末尾
                reverseStr(chars, begin, i - 1);
                // i - 1 是字符串末尾，i + 1是下一个字符串开始
                begin = i + 1;
            }
        }
        // 最后一个单词没有空格
        reverseStr(chars, begin, chars.length - 1);
        return new String(chars);
    }

    public static void reverseStr(char[] chars, int begin, int end) {
        for (; begin < end; begin++, end--) {
            char temp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = temp;
        }
    }

}
