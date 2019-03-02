package stack.stack_with_getMin;

import java.util.Stack;

/**
 * TODO 2019/2/14 :
 * 使用 java.util.Stack 栈结构，实现返回栈的最小值
 * 要求时间复杂度为 O(1)
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class MyMinStack {

    /**
     * push 进去的栈
     */
    private Stack<Integer> stack = new Stack<>();

    /**
     * 每次 push，都比较栈中的值，小于则同时 push 到 minStack中
     */
    private Stack<Integer> minStack = new Stack<>();

    @SuppressWarnings("all")
    public void push(Integer i) {
        // 先插入到stack中
        stack.push(i);
        // 如果minStack中没有元素，则直接push
        if (minStack.isEmpty()) {
            minStack.push(i);
        } else {
            // 如果minStack有元素，则拿出来比较，小于等于minStack的值才push进minStack
            Integer peek = minStack.peek();
            if (peek >= i) {
                minStack.push(i);
            }
        }
    }

    /**
     * 当stack移除元素的时候，顺便移除 minStack的指定元素
     */
    public int pop() {
        if (this.stack.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        int pop = this.stack.pop();
        if (pop == getMin()) {
            minStack.pop();
        }
        return pop;
    }

    /**
     * 时间复杂度为 1 的取出栈最小值
     * @return 最小值
     */
    @SuppressWarnings("all")
    public int getMin() {
        if (this.minStack.isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        return minStack.peek();
    }

}
