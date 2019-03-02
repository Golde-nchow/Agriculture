package stack.MyStack;

/**
 * TODO 2019/2/14 :
 * 栈接口类
 * @author User : Golden_chow
 */
public interface IStack<T> {

    /**
     * 弹栈
     * @return 栈顶元素
     */
    T pop();

    /**
     * 压栈
     * @param t 压栈的元素
     * @return 成功返回 true，否则返回 false
     */
    boolean push(T t);

    /**
     * 返回栈顶元素
     * @return 栈顶元素
     */
    T peek();

    /**
     * 判断栈是否为空
     * @return 栈空返回 true，否则返回 false
     */
    boolean isEmpty();

    /**
     * 判断栈是否满
     * @return 栈满返回 false，否则返回 true
     */
    boolean isFull();

    /**
     * 返回元素在栈中的位置
     * @param t 指定元素
     * @return 在栈中的下标
     */
    int getIndex(T t);

    /**
     * 返回栈的元素个数
     * @return 栈元素个数
     */
    int size();

    /**
     * 返回栈的总容量
     * @return 栈容量
     */
    int getStackSize();

    /**
     * 打印栈
     */
    void display();

}
