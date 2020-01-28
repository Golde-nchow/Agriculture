package 剑指offer._36;

/**
 * 2019/10/24 :
 * 输入两个链表，找出它们的第一个公共结点。
 *
 * 意思就是两个链表中的一个或多个节点会进行合并
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num36 {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(6);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(7);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(8);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = listNode2;


        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        listNode4.next = listNode7;
        listNode7.next = listNode6;
        listNode6.next = listNode5;

        ListNode listNode8 = FindFirstCommonNode(listNode, listNode4);
        System.out.println(listNode8.val);
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        ListNode node1 = pHead1, node2 = pHead2;
        // 因为这里会有一个互补的操作，所以一定可以追的上
        // 1 2 3 6 7 - 4 5 6 7
        // 4 5 6 7 - 1 2 3 6 7
        // 两个相同的节点一定会相隔 1
        while (node1 != node2) {
            node1 = node1 == null ? pHead2 : node1.next;
            node2 = node2 == null ? pHead1 : node2.next;
        }
        return node1;
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