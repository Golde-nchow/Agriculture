package 剑指offer._45_字符串;

import java.util.Arrays;

/**
 * 2019/10/27 :
 * LL今天心情特别好,因为他去买了一副扑克牌,
 * 发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,
 * 如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
 * 不是顺子.....LL不高兴了,他想了想,决定大\小王可以看成任何数字, 并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。
 * LL决定去买体育彩票啦。
 *
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。
 *
 * 构成顺子的条件是：没有对子、最大最小值间隔不超过4，你可以认为大小王是0。
 *
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num45 {

    public static void main(String[] args) {
        System.out.println(isContinuous(new int[]{0,0,4,1,3,2,5}));
    }

    public static boolean isContinuous(int [] numbers) {
        // 进行排序
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length - 1 - i; j++) {
                if (numbers[j] >= numbers[j+1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(numbers));

        // 过滤掉 0
        int zeroIndex = -1;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                zeroIndex++;
                continue;
            } else if (numbers[i] == numbers[i+1]) {
                return false ;
            }
        }
        // 如果最大值减去最小值大于 4 ，则 false
        if (numbers[numbers.length - 1] - numbers[zeroIndex + 1] > 4) {
            return false;
        }
        return true;
    }

}
