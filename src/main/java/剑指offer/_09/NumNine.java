package 剑指offer._09;

/**
 * 2019/10/13 :
 * 我们可以用 2*1 的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用 n 个 2*1 的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class NumNine {

    public static void main(String[] args) {
        System.out.println(RectCover(4));
    }

    /**
     * 都是跳台阶的问题，简单
     */
    public static int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }

}
