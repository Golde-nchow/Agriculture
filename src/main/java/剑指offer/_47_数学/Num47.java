package 剑指offer._47_数学;

/**
 * 2019/10/28 :
 * 求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case 等关键字及条件判断语句（A?B:C）。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num47 {

    public static void main(String[] args) {
        System.out.println(Sum_Solution(100));
    }

    public static int Sum_Solution(int n) {
        int sum = n;
        // 如果大于0，则往下执行相加运算
        boolean result = (n > 0) && ((sum += Sum_Solution(n-1)) > 0);
        return sum;
    }

}
