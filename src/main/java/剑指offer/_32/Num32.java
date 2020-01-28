package 剑指offer._32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 2019/10/24 :输入一个正整数数组，把数组里所有数字拼接起来排成一个数，
 * 打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，
 * 则打印出这三个数字能排成的最小数字为321323。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num32 {

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        System.out.println(String.valueOf(Integer.valueOf(PrintMinNumber2(arr))));
    }

    // 全排列
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }

        List<Integer> list = new ArrayList<>();
        PrintMinNumber(numbers, 0, numbers.length - 1, list);
        Collections.sort(list);
        return String.valueOf(list.get(0));
    }

    public static void PrintMinNumber(int [] numbers, int start, int end, List<Integer> list) {
        if (start == end) {
            list.add(arrToInt(numbers));
        }
        for (int i = start; i <= end; i++) {
            swap(numbers, start, i);
            PrintMinNumber(numbers, start + 1, end, list);
            swap(numbers, start, i);
        }
    }

    public static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static Integer arrToInt(int[] numbers) {
        StringBuilder builder = new StringBuilder();
        for (int number : numbers) {
            builder.append(number);
        }
        return Integer.valueOf(builder.toString());
    }

    // 或者进行排序后直接拼接
    public static String PrintMinNumber2(int [] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                int num1 = Integer.valueOf(numbers[j] + "" + numbers[j+1]);
                int num2 = Integer.valueOf(numbers[j+1] + "" + numbers[j]);

                if (num1 > num2) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            builder.append(numbers[i]);
        }
        return builder.toString();
    }
}
