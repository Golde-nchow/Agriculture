package 程序员代码面试指南.list.ReverseDoubleList;

/**
 * TODO 2019/3/2 :
 * 反转双向链表
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class ReverseDoubleList {

    public static void main(String[] args) {
        Node Node1 = new Node(1);
        Node Node2 = new Node(2);
        Node Node3 = new Node(3);
        Node Node4 = new Node(4);
        Node Node5 = new Node(5);
        Node1.next = Node2;
        Node2.next = Node3;
        Node2.last = Node1;
        Node3.next = Node4;
        Node3.last = Node2;
        Node4.next = Node5;
        Node4.last = Node3;
        Node5.last = Node4;
        Node node = reverseDoubleList(Node1);
        // head.next遍历
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 反转双向链表
     * @param head 头节点
     * @return 返回尾节点
     */
    public static Node reverseDoubleList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            // 其实这里和反转单链表一致，只不过多了一个把head.last = head.next步骤
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

}
