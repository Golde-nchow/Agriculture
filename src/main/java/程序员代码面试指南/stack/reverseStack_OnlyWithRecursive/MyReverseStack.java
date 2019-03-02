package 程序员代码面试指南.stack.reverseStack_OnlyWithRecursive;

import java.util.Stack;

/**
 * TODO 2019/2/19 :
 * 仅通过递归函数实现逆序栈
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class MyReverseStack {

    private Stack<Integer> stack;

    public MyReverseStack(Stack<Integer> stack) {
        this.stack = stack;
    }

    /**
     * 从栈中取出元素并将其移除
     * @return 返回移除的栈顶元素
     */
    private int getAndRemoveFromStack() {
        // 弹出栈顶元素
        Integer top = stack.pop();
        if (stack.isEmpty()) {
            return top;
        }
        // 如果栈不为空，则不断递归
        int last = getAndRemoveFromStack();
        stack.push(top);
        return last;
    }

    /**
     * 调用getAndRemoveFromStack 方法，实现逆序
     */
    public void reverse() {
        if (stack.isEmpty()) {
            return;
        }
        int fromStack = getAndRemoveFromStack();
        reverse();
        stack.push(fromStack);
    }

    /**
     * 遍历栈中所有元素
     */
    public void getAll() {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

}
