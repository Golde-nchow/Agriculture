package 程序员代码面试指南.list.DeleteNodeInBA;

/**
 * TODO 2019/3/2 :
 * 删除 b/a 处的节点
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class DeleteNodeInBA {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
//        head.next.next.next.next = new Node(5);

        Node node = deleteNodeBetweenBAndA(head, 1, 2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 删除 b/a 处 的节点
     * @param head 头结点
     * @param a 分子 a
     * @param b 分母 b
     * @return 头结点
     */
    public static Node deleteNodeBetweenBAndA(Node head, int a, int b) {
        // 如果 r == 0 或者 r > 1 不删除节点
        if (a < 1 || a > b) {
            return head;
        }
        // 暂存头结点
        Node cur = head;
        int count = 0;

        // 计算链表数量
        while (cur != null) {
            cur = cur.next;
            count++;
        }

        // cur指针回到链表头
        cur = head;

        // 计算要删除的节点
        int del = (int)Math.ceil((double)a * count / (double)b);

        // 如果del为1
        if (del == 1) {
            return head.next;
        }

        // 删除节点
        while (--del != 1) {
            cur = cur.next;
        }
        cur.next = cur.next.next;

        return head;
    }

}
