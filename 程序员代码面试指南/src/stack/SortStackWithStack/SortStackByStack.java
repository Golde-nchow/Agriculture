package stack.SortStackWithStack;

import java.util.Stack;

/**
 * TODO 2019/2/24 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class SortStackByStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        stack.push(4);
        Stack<Integer> sorted = sort(stack);
        while (!sorted.isEmpty()) {
            System.out.println(sorted.pop());
        }
    }

    public static Stack<Integer> sort(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            Integer pop = stack.pop();
            while (!help.isEmpty() && help.peek() < pop) {
                stack.push(help.pop());
            }
            help.push(pop);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
        return stack;
    }

}
