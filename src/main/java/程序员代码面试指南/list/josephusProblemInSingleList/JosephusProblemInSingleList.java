package 程序员代码面试指南.list.josephusProblemInSingleList;

/**
 * TODO 2019/3/5 :
 * 约瑟夫单链表环
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class JosephusProblemInSingleList {

    public static void main(String[] args) {
        // 环形单链表
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.next = head;

        Node node = josephusProblem(head, 2);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

    }

    /**
     * 约瑟夫问题
     * @param head 链表环
     * @param num 间隔第几个数
     * @return 最后一个节点
     */
    public static Node josephusProblem(Node head, int num) {
        // 如果有问题，直接返回
        if (head == null || head.next == head || num < 1) {
            return head;
        }
        int count = 0;
        Node pre = head;
        // 找到head的上一个元素
        while (pre.next != head) {
            pre = pre.next;
        }
        while (head != pre) {
            // kill this
            if (++count == num) {
                pre.next = head.next;
                count = 0;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return head;
    }

}
