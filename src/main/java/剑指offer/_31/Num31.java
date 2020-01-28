package 剑指offer._31;

/**
 * 2019/10/24 :
 * <p>
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * <p>
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num31 {

    public static void main(String[] args) {
        int count = NumberOf1Between1AndN_Solution(31);
        System.out.println(count);
    }

    public static int NumberOf1Between1AndN_Solution(int n) {
        int current = 0;
        int before = 0;
        int after = 0;
        int count = 0;
        int i = 1;

        while (n / 10 != 0) {
            // 计算 current
            current = (n / i) % 10;
            // 获取 before
            before = n / (i * 10);
            // 获取 after
            after = n % (i * 10);
            i *= 10;
        }
        return count;
    }
}
