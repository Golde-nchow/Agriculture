package 剑指offer._56_链表;

/**
 * 2019/11/1 :
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num56 {

    // 不知道牛客抽什么风，又不通过
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(12);
        ListNode five = new ListNode(12);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        ListNode listNode = deleteDuplication(one);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode result = new ListNode(-1);
        result.next = pHead;
        ListNode current = pHead;
        ListNode pre = result;

        while (current != null && pre != null) {
            boolean repeated = false;
            // 一直往右移动，直到不同为止
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                repeated = true;
            }
            // repeated 主要是用在这里，没了
            if (repeated && current != null) {
                current = current.next;
            }
            pre.next = current;
            pre = current;
            if (current != null) {
                current = current.next;
            }
        }
        return result.next;
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
