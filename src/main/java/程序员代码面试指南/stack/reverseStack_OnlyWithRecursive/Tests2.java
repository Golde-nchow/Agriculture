package 程序员代码面试指南.stack.reverseStack_OnlyWithRecursive;

import java.util.Stack;

/**
 * TODO 2019/2/19 :
 *
 * @author User : Golden_chow
 */
public class Tests2 {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        MyReverseStack reverseStack = new MyReverseStack(stack);
        reverseStack.reverse();
        reverseStack.getAll();
    }
}
