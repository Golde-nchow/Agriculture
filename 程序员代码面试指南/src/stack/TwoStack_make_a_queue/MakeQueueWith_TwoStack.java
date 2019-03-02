package stack.TwoStack_make_a_queue;

import java.util.Stack;

/**
 * TODO 2019/2/17 :
 * 使用两个栈实现一个队列
 * @author User : Golden_chow
 */
public class MakeQueueWith_TwoStack {

    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public MakeQueueWith_TwoStack() {
        stackPush = new Stack<>();
        stackPop = new Stack<>();
    }

    /**
     * 往 stackPush 添加一个元素
     * @param pushNum 添加的元素
     */
    public void add(int pushNum) {
        stackPush.push(pushNum);
    }

    /**
     * stackPop 弹出一个元素
     * @return 弹出的元素
     */
    public int poll() {
        tryToGet();
        return stackPop.pop();
    }

    /**
     * 返回 stackPop 栈顶的元素
     * @return 栈顶元素
     */
    public int peek() {
        tryToGet();
        return stackPop.peek();
    }

    /**
     * 尝试从stackPop栈中取出数据
     * 如果有数据，则无操作
     * 如果没有数据，则从stackPush弹出所有的数据，并填充到 stackPop 中
     */
    private void tryToGet() {
        if (stackPop.isEmpty() && stackPush.isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
    }
}
