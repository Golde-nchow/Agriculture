package 程序员代码面试指南.list.SamePart_in_TwoList;

/**
 * TODO 2019/2/27 :
 * 打印两个有序链表的公共部分
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class SamePartInTwoList {

    public static void main(String[] args) {
        // 两个头指针
        Node head1 = new Node(2);
        head1.next = new Node(4);
        head1.next.next = new Node(6);
        head1.next.next.next = new Node(8);
        
        Node head2 = new Node(1);
        head2.next = new Node(3);
        head2.next.next = new Node(6);
        head2.next.next.next = new Node(7);
        getSamePart(head1, head2);
    }

    /**
     * 打印两个链表中相同的元素
     * @param head1 有序链表 1
     * @param head2 有序链表 2
     */
    public static void getSamePart(Node head1, Node head2) {
        // 同时遍历两个数组
         // 如果有其中一个为空或者到了尽头就退出
        while (head1 != null && head2 != null) {
            // 如果head1的值小于head2的值，则head1移动至下一个元素
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head2.value < head1.value ) {
                // 如果head2的值小于head1的值，则head2移动至下一个元素
                head2 = head2.next;
            } else {
                // 如果head2的值等于head1的值，则说明两个元素重复，打印出来
                // 并且两个队列都向前移动一个元素
                System.out.println(head1.value);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }
}
