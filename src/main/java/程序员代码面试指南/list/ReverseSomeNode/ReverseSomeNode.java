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
        Node node1 = head;
        Node pre = null;
        Node last = null;
        int count = 0;
        // 获取from-1和to+1的节点
        // 范围2-4，1的叫pre，5的叫last
        while (node1 != null) {
            count++;
            pre = from - 1 == count ? node1 : pre;
            last = to + 1 == count ? node1 : last;
            node1 = node1.next;
        }
        // 如果node1 = null，则返回head，否则返回head.next节点
        node1 = pre == null ? head : pre.next;
        Node node2 = node1.next;
        // 暂存反转链表的下一个节点
        node1.next = last;
        // 暂存
        Node next = null;
        // 修改引用，遍历到last前一个节点
        while (node2 != last) {
            next = node2.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        // 补全两个链表
        if (pre != null) {
            // 因为此时node2已经为Null
            // 由于一开始node1.next = last，所以不用管后面的
            pre.next = node1;
            return head;
        }
        // 如果出现from=2，to=2类似的情况
        return node1;
    }

}
