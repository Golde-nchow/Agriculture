package 剑指offer._13_链表倒数第k个结点;

import java.util.Stack;

/**
 * 2019/10/14 :
 * 输入一个链表，输出该链表中倒数第k个结点。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num13 {

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

        System.out.println(FindKthToTail2(one, 2).val);
    }

    /**
     * 用栈来实现，非常简单
     * 但是不知道为什么牛客通过率为33.33
     */
    public static ListNode FindKthToTail(ListNode head,int k) {
        if (k <= 0) {
            k = 0;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode result = null;
        for (int i = 0; i < k; i++) {
            result = stack.pop();
        }
        return result;
    }

    /**
     * 通过快慢指针来取得该值
     */
    public static ListNode FindKthToTail2(ListNode head,int k) {
        ListNode slow = head;
        ListNode fast = head;
        while (k-- > 0) {
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}