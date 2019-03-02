package stack.TwoStack_make_a_queue;

/**
 * TODO 2019/2/18 :
 * 测试 MakeQueueWith_TwoStack 类的操作
 * @author User : Golden_chow
 */
public class Test {
    public static void main(String[] args) {
        MakeQueueWith_TwoStack queue = new MakeQueueWith_TwoStack();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        try {
            while (true) {
                System.out.println(queue.poll());
            }
        } catch (Exception e) {}

    }
}
