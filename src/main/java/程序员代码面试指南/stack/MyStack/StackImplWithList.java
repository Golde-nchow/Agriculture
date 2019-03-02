package 程序员代码面试指南.stack.MyStack;

/**
 * TODO 2019/2/14 :
 * 用 栈链 来实现栈结构
 * @author User : Golden_chow
 */
public class StackImplWithList<E> {

    private class Node {
        private E data = null;
        private Node next = null;

        Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node top;
    private int maxSize = 0;

    @SuppressWarnings("unused")
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        // 原来的头节点
        Node temp = top;
        temp.next = null;
        // 现在更新后的头节点
        top = top.next;
        --maxSize;
        return top.data;
    }

    @SuppressWarnings("unused")
    public int getIndex(E e) {
        int index = 0;
        while (top != null) {
            if (peek().equals(e)) {
                return index;
            }
            ++index;
            top = top.next;
        }
        return -1;
    }

    @SuppressWarnings("all")
    public boolean push(E s) {
        top = new Node(s, top);
        ++maxSize;
        return true;
    }

    @SuppressWarnings("all")
    public E peek() {
        return this.top.data;
    }

    @SuppressWarnings("all")
    public boolean isEmpty() {
        return this.maxSize == 0;
    }

    @SuppressWarnings("unused")
    public int size() {
        int count = 0;
        while (top != null) {
            top = top.next;
            ++count;
        }
        return count;
    }

    @SuppressWarnings("all")
    public void display() {
        while (top != null) {
            System.out.print(top.data);
            top = top.next;
        }
    }

    /**
     * 返回栈中最小值，时间复杂度为 O(n)
     * @return 最小值
     */
    @SuppressWarnings("all")
    public Integer getMin() {
        if (isEmpty()) {
            throw new RuntimeException("栈为空");
        }
        if (top.data instanceof Integer) {
            Integer min = (Integer) top.data;
            // 遍历栈中数据
            while (top != null) {
                Integer num = (Integer)top.data;
                if (min > num) {
                    min = num;
                }
                top = top.next;
            }
            return min;
        } else {
            throw new RuntimeException("非整型数据");
        }
    }
}
