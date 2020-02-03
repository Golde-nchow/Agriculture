package 剑指offer._19_顺时针打印矩阵;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2019/10/17 :
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵（矩阵就是二位数组啦）：
 * 1  2  3  4
 * 5  6  7  8
 * 9  10 11 12
 * 13 14 15 16
 *
 * 则逆时针依次打印出数字
 * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 *
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("ALL")
public class Num19 {

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        printMatrix(matrix);
    }

    /**
     * 简单来说，就是不断地收缩矩阵的边界
     * 定义四个变量代表范围，up、down、left、right
     */
    public static void printMatrix(int[][] matrix) {
        ArrayList list = new ArrayList();

        // 如果矩阵是空就直接返回
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            System.out.println(Arrays.toString(matrix));
            return;
        }
        // 定义4个边界
        int top = 0;
        int left = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (true) {
            // 遍历顶层
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;
            if (top > bottom) {
                break;
            }

            // 遍历右层
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if (right < left) {
                break;
            }
            // 遍历下层
            for (int i = right; i >= left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if (bottom < top) {
                break;
            }
            // 遍历左层
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        System.out.println(list);
    }

}
