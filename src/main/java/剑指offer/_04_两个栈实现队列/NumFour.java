package 剑指offer._04_两个栈实现队列;

import java.util.Stack;

/**
 * 2019/9/17 :
 *
 * @author User : Golden_chow
 */
public class NumFour {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public static void main(String[] args) {
        NumFour four = new NumFour();
        four.push(1);
        four.push(3);
        four.push(7);
        System.out.println(four.pop());
        System.out.println(four.pop());
        four.push(5);
        System.out.println(four.pop());
        System.out.println(four.pop());
    }

    public void push(int value) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(value);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
}
