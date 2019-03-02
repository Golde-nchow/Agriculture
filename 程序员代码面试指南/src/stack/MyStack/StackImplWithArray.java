package stack.MyStack;

/**
 * TODO 2019/2/14 :
 * 用数组来实现栈结构
 * @author User : Golden_chow
 */
public class StackImplWithArray<E> implements IStack<E>{

    private Object[] data = null;
    private int maxSize;
    private int top = -1;

    @SuppressWarnings("unused")
    public StackImplWithArray() {
        // 默认大小为5
        this.maxSize = 5;
        this.data = new Object[5];
    }

    public StackImplWithArray(int maxSize) {
        this.maxSize = maxSize;
        this.data = new Object[maxSize];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            System.out.println("栈是空的");
            return null;
        }
        return (E)data[top--];
    }

    @Override
    public boolean push(E s) {
        // 如果栈已满，则返回false
        if (isFull()) {
            System.err.print("\n栈已满");
            return false;
        }
        // 添加元素
        data[++top] = s;
        return true;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            System.err.println("栈是空的");
            return null;
        }
        return (E)data[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public boolean isFull() {
        return top >= maxSize - 1;
    }

    @Override
    public int getIndex(E s) {
        while (top != -1) {
            if (peek().equals(s)) {
                return top;
            }
            top--;
        }
        return -1;
    }

    @Override
    public int size() {
        return top + 1;
    }

    @Override
    public int getStackSize() {
        return maxSize;
    }

    @Override
    public void display() {
        while (top != -1) {
            System.out.print(data[top]);
            top--;
        }
    }

    @SuppressWarnings("all")
    /**
     * 取出栈中的最小值，时间复杂度为 O(n)
     * @return 最小值
     */
    public int getMin() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        if (data[0] instanceof Integer) {
            Integer min = (Integer) data[top];
            while (top != -1) {
                Integer num = (Integer) data[top];
                if (min > num) {
                    min = num;
                }
                top--;
            }
            return min;
        } else {
            throw new RuntimeException("非整型数据");
        }
    }
}
