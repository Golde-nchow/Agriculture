package 剑指offer._33;

/**
 * 2019/10/24 :把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * “首先除2,直到不能整除为止,
 *  然后除5到不能整除为止,
 *  然后除3直到不能整除为止。
 *  最终判断剩余的数字是否为1,如果是1则为丑数,否则不是丑数。”
 *
 *
 * 也就是说 8 = 2 * 2 * 2;  中的 2 是不能再分割的.
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num33 {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(5));
    }

    /**
     * 为了提高效率，我们可以只计算丑数，不在非丑数上浪费时间。
     * 每一个丑数都可以由前面的丑数乘以2、3或者5得到。
     */
    public static int GetUglyNumber_Solution(int index) {
        if (index < 1) {
            return 0;
        }
        if (index < 7) {
            return index;
        }
        // 存储丑数的数组
        int[] uglyNumbers = new int[index];
        // 第一个数是丑数
        uglyNumbers[0] = 1;
        int multiply2 = 0, multiply3 = 0, multiply5 = 0;

        for (int i = 1; i < index; i++) {
            int min = getMin(uglyNumbers[multiply2] * 2, uglyNumbers[multiply3] * 3,
                    uglyNumbers[multiply5] * 5);
            uglyNumbers[i] = min;
            while (uglyNumbers[multiply2] * 2 <= min) {
                multiply2++;
            }
            while (uglyNumbers[multiply3] * 3 <= min) {
                multiply3++;
            }
            while (uglyNumbers[multiply5] * 5 <= min) {
                multiply5++;
            }
        }
        return uglyNumbers[index - 1];
    }

    public static int getMin(int a, int b, int c) {
        int min = a > b ? b : a;
        return min < c ? min : c;
    }

}
