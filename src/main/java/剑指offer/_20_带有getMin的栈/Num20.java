package 剑指offer._20_带有getMin的栈;

import java.util.Stack;

/**
 * 2019/10/22 :
 * 定义栈的数据结构，
 * 请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num20 {

    private static Stack<Integer> stack = new Stack<>();
    private static Stack<Integer> minStack = new Stack<>();

    public static void main(String[] args) {
        push(5);
        push(1);
        push(9);
        push(0);
        System.out.println(min());
    }


    public static void push(int node) {
        stack.push(node);
        if (minStack.isEmpty()) {
            minStack.push(node);
        } else {
            Integer peek = minStack.peek();
            if (peek >= node) {
                minStack.push(node);
            }
        }
    }

    public static void pop() {
        Integer pop = stack.pop();
        if (pop == min()) {
            minStack.pop();
        }
    }

    public static int top() {
        return 0;
    }

    public static int min() {
        return minStack.peek();
    }

}
