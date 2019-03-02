package stack.MyStack;

/**
 * TODO 2019/2/17 :
 *
 * @author User : Golden_chow
 */
public class Test {
    /**
     * 有3个元素，时间为 1
     */
    public static void main(String[] args) {
        long before = System.currentTimeMillis();

        // 测试getMin方法 ok
        StackImplWithArray<Integer> stack = new StackImplWithArray<>(3);
        stack.push(1);
        stack.push(-2);
        stack.push(-8);

        long after = System.currentTimeMillis();
        System.out.println("消耗时间为：" + (after - before));
        System.out.println("最小值：" + stack.getMin());
        // 测试普通插入 ok
//        StackImplWithArray<String> stack = new StackImplWithArray<>(3);
//        stack.push("吗");
//        stack.push("好");
//        stack.push("你");
//        System.out.println("栈元素个数：" + stack.size());
//        System.out.println("栈容量：" + stack.getStackSize());
//        System.out.println("'你'在栈中的下标" + stack.getIndex("你"));
//        stack.display();

    }

    /**
     * 有3个元素，时间为3
     */
    public static void main1(String[] args) {
        long before = System.currentTimeMillis();

        // 测试getMin方法 ok
        StackImplWithList<Integer> stack = new StackImplWithList<>();
        stack.push(1);
        stack.push(-4);
        stack.push(6);

        long after = System.currentTimeMillis();
        System.out.println("消耗时间为：" + (after - before));
        System.out.println("最小值：" + stack.getMin());
//        StackImplWithList<String> stack = new StackImplWithList<>();
//        stack.push("?");
//        stack.push("吗");
//        stack.push("好");
//        stack.push("你");
//        stack.display();

//        System.out.println("栈元素个数：" + stack.size());
    }

}
