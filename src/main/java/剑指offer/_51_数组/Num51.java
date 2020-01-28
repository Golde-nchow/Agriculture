package 剑指offer._51_数组;

import java.util.Arrays;

/**
 * 2019/10/28 :
 * 给定一个数组A[0,1,...,n-1],
 * 请构建一个数组B[0,1,...,n-1],
 *
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不
 * 能使用除法。
 *
 * 比如说
 * B[0] = A[1]+A[2]+A[3]+A[4]
 * B[1] = A[0]+A[1]+A[2]+A[3]
 * ...
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num51 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(multiply(new int[]{1, 5, 2, 6, 3})));
    }

    public static int[] multiply(int[] A) {
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 0; i < A.length; i++) {
            int num = 1;
            for (int j = 0; j < A.length; j++) {
                if (!(i == j)) {
                    num *= A[j];
                }
            }
            B[i] = num;
        }
        return B;
    }

}
