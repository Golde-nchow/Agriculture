package 剑指offer._15;

/**
 * 2019/10/15 :
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 需要合成后的链表满足单调不减规则。
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num15 {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(7);
        ListNode three = new ListNode(5);
        ListNode four = new ListNode(10);
        ListNode five = new ListNode(20);

        one.next = two;
        two.next = null;
        three.next = four;
        four.next = five;

        ListNode node = Merge2(one, three);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    /**
     * 非递归版本：将两个链表结点挨个进行比较，插入到一个新表中
     */
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = new ListNode(-1);
        ListNode first = result;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                result.next = list2;
                list2 = list2.next;
            } else {
                result.next = list1;
                list1 = list1.next;
            }
            result = result.next;
        }

        while (list1 != null) {
            result.next = list1;
            list1 = list1.next;
            result = result.next;
        }

        while (list2 != null) {
            result.next = list2;
            list2 = list2.next;
            result = result.next;
        }

        return first.next;

    }

    /**
     * 递归版本
     * 首先判断返回哪个节点，肯定是返回val最小的节点，
     * 然后[ val最小的节点.next = Merge(x,y)]，返回的又是节点最小的节点
     */
    public static ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode result = null;
        if (list1.val > list2.val) {
            result = list2;
            result.next = Merge2(list1, list2.next);

        } else {
            result = list1;
            result.next = Merge2(list1.next, list2);
        }
        return result;

    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
