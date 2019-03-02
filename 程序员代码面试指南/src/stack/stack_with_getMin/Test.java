package stack.stack_with_getMin;

/**
 * TODO 2019/2/15 :
 * 测试类
 * @author User : Golden_chow
 */
public class Test {

    /**
     * 有4个元素，时间为 1
     */
    public static void main(String[] args) {
        long before = System.currentTimeMillis();
        MyMinStack stack = new MyMinStack();
        stack.push(1);
        stack.push(-2);
        stack.push(8);
        stack.push(-8);
        long after = System.currentTimeMillis();
        System.out.println("消耗时间为：" + (after - before));
        System.out.println("最小值为：" + stack.getMin());
    }
}
