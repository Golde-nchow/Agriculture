package 剑指offer._01;

/**
 * 2019/9/16 :
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * @author User : Golden_chow
 */
public class NumOne {
    public static void main(String[] args) {
        int target = 5;
        int[][] nums = {{1, 2, 3}, {6, 7, 8}, {11, 12, 13}};
        for (int i = 1; i <= 20; i++) {
            System.out.println("当前是" + i + "->" + findNum(i, nums));
        }
    }

    /**
     * 通过二分查找法实现
     * 二分查找法的基础是数字按顺序排列，然后不断地计算出 mid 进行折半
     */
    public static boolean findNum(int target, int[][] array) {
        boolean found = false;
        if (array == null || array.length == 0) {
            return found;
        }
        int width = 0, height = array.length - 1;
        while (width >= 0 && height >= 0 && width < array.length && height < array[0].length) {
            if (target > array[width][height]) {
                width++;
            } else if (target < array[width][height]) {
                height--;
            } else if (target == array[width][height]) {
                found = true;
                break;
            }
        }
        return found;
    }
}
