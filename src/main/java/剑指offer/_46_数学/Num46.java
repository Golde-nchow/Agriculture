package 剑指offer._46_数学;

/**
 * 2019/10/27 :
 * 随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,
 * <p>
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 *
 * 耐心看解析
 * https://my.oschina.net/dichanger/blog/528219
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num46 {

    public static void main(String[] args) {
        System.out.println(LastRemaining_Solution(4, 3));
    }

    // 直接套约瑟夫公式
    public static int LastRemaining_Solution(int n, int m) {
        if (m < 1 || n < 1) {
            return -1;
        }
        int last = 0;
        // 至于这里为什么要从
        for (int i = 2; i < n; i++) {
            last = (m + last) % n;
        }
        return last;
    }

    // 使用数组解决
    public static int LastRemaining_Solution2(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        int[] arr = new int[n];
        // 间隔
        int gap = 0;
        int i = -1;
        int count = n;
        while (count > 0) {
            i++;
            if (i >= n) {
                i = 0;
            }
            if (arr[i] == -1) {
                continue;
            }
            gap++;
            if (gap == m) {
                arr[i] = -1;
                gap = 0;
                count--;
            }
        }
        return i;
    }
}
