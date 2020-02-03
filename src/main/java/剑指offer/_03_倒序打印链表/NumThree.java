package 剑指offer._03_倒序打印链表;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 2019/9/16 :
 * 输入一个链表，按链表从尾到头的顺序返回一个 ArrayList。
 * <p>
 * public class ListNode {
 * int val;
 * ListNode next = null;
 * <p>
 * ListNode(int val) {
 * this.val = val;
 * }
 * }
 *
 * @author User : Golden_chow
 */
public class NumThree {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(9);
        ListNode node4 = new ListNode(10);
        ListNode node5 = new ListNode(8);
        ListNode node6 = new ListNode(13);
        ListNode node7 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        System.out.println("倒序");
        System.out.println(printListFromTailToHead2(node1));
    }

    /**
     * 使用栈实现倒序
     */
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * 递归实现 —— 挺不好理解的
     */
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();

        ListNode pNode = listNode;
        if (pNode != null) {
            if (pNode.next != null) {
                list = printListFromTailToHead2(pNode.next);
            }
            list.add(pNode.val);
        }

        return list;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
