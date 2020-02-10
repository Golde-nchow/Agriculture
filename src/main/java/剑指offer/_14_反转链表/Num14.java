package 剑指offer._14_反转链表;

/**
 * 2019/10/14 :
 * 反转链表
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num14 {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(78);
        ListNode four = new ListNode(0);
        ListNode five = new ListNode(12);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode node = ReverseList(one);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 其实挺简单的，一个方法是用栈，另一个方法是遍历
     * 栈的就不多说了
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
