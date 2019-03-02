package 程序员代码面试指南.list.ReverseSingleList;

/**
 * TODO 2019/3/2 :
 * 反转单链表
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class ReverseSingleList {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        Node node = reverseSingleList(head);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 反转单链表
     * @param head 链表头节点
     * @return 返回链表尾节点
     */
    public static Node reverseSingleList(Node head) {
        // 当前节点
        Node last = null;
        // 下一个节点
        Node next = null;
        while (head != null) {
            next = head.next; // 2
            head.next = last; // 1 -> null
            last = head; // 1
            head = next; // 2
        }
        return last;
    }

}
