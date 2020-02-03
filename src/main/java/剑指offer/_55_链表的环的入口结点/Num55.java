package 剑指offer._55_链表的环的入口结点;

/**
 * 2019/11/1 :
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num55 {

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
        five.next = three;

        System.out.println(EntryNodeOfLoop(one).val);
    }

    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode meet = getMeetingNode(pHead);
        if (meet == null) {
            return null;
        }
        // 求出环的长度
        ListNode temp = meet.next;
        int length = 1;
        while (temp != meet) {
            temp = temp.next;
            length++;
        }
        // 通过 length 确定快指针先走 length 步
        // 然后两个指针不断地往前移一格，相遇则返回
        ListNode slow = pHead;
        ListNode fast = pHead;
        for (int i = 0; i < length; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    // 判断是否有环
    public static ListNode getMeetingNode(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        // 定义快慢指针, 快指针一次移动两格, 慢指针一格
        // 必须要这样，不能快指针移动一格，慢指针不动，这样永远追不上.
        ListNode fast = pHead;
        ListNode slow = pHead;
        // 如果快慢指针重合，那么就是入口
        while (fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

}

@SuppressWarnings("all")
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
