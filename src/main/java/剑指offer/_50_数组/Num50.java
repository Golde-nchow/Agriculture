package 剑指offer._50_数组;

import java.util.HashSet;

/**
 * 2019/10/28 :
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 *
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num50 {

    public static void main(String[] args) {

    }

    // 有三种方法去做
    // 1、排序后判断
    // 2、集合去重
    // 3、不用创建多余的数据结构，在原数组中实现交换，判断操作
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
//        HashSet<Integer> set = new HashSet<>();
//        for (int i = 0; i < length; i++) {
//            if (set.contains(numbers[i])) {
//                duplication[0] = numbers[i];
//                return true;
//            } else {
//                set.add(numbers[i]);
//            }
//        }
//        return false;
        if(numbers == null || numbers.length - 1 > length || length < 0) {
            return false;
        }
        for(int i = 0; i < length; i++){
            if(numbers[i] < 0 || numbers[i] > length - 1){
                return false;
            }
        }
        // 不开辟新的空间
        for(int i = 0; i < length; i++){
            while(numbers[i] != i){
                if(numbers[i] == numbers[numbers[i]]) {
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return true;
    }

}
