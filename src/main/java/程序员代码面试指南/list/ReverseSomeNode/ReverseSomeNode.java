package 程序员代码面试指南.list.ReverseSomeNode;

/**
 * TODO 2019/3/3 :
 * 反转单链表的部分节点
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class ReverseSomeNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node node = reverseSomeNode(head, 2, 4);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 反转单链表部分节点
     * @param head 头节点
     * @param from 从第 from 个开始反转
     * @param to 到第 to + 1 个结束反转
     * @return 反转后链表的头结点
     */
    public static Node reverseSomeNode(Node head, int from, int to) {
        int count = 0;

    }

}
