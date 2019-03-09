package 程序员代码面试指南.list.JudgeChainInList;

import java.util.Stack;

/**
 * TODO 2019/3/8 :
 * 判断单链表是否回文结构
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class IfChainInList {

    public static void main(String[] args) {
        Node head = new Node(6);
        head.next = new Node(5);
        head.next.next = new Node(1);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(2);
        head.next.next.next.next.next = new Node(1);
        head.next.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next.next = new Node(6);
        System.out.println("回文结构：" + getJudgeChainPlus(head));
    }

    /**
     * 判断是否回文结构
     * @param head 链表头指针
     * @return 是回文结构返回 true，否则返回false
     */
    public static boolean myJudgeChain(Node head) {
        Node start = head;
        Stack<Node> stack = new Stack<>();
        // 把所有元素push进栈里
        while (start != null) {
            stack.push(start);
            start = start.next;
        }
        // 开始比较
        while (head != null) {
            if (head.value != stack.pop().value) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 进阶篇
     * @param head 头结点
     * @return 是否是回文结构，是则返回 true, 否则返回 false
     */
    public static boolean getJudgeChainPlus(Node head) {
        Node helpLeft = head;
        Node left = head;
        // 取出中间节点
        while (helpLeft.next != null && helpLeft.next.next != null) {
            left = left.next;
            helpLeft = helpLeft.next.next;
        }

        // 分裂链表
        Node right = left.next; // 右链表
        left.next = null; // 左链表

        // 右链表反转
        Node next = null;
        Node pre = null;
        while (right != null) {
            next = right.next;
            right.next = pre;
            pre = right;
            right = next;
        }
        // 保存节点：刚刚反转后，右链表需要重新回到开始处，否则就是null了
        right = pre;
        // 左链表回到开头处
        left = head;
        // 开始比较
        boolean result = true;
        while (left != null && right != null) {
            if (left.value != right.value) {
                result = false;
                break;
            }
            left = left.next;
            right = right.next;
        }
        // 比较完成后，右链表回到开始处
        right = pre;
        pre = null;
        // 再次反转右链表
        while (right != null) {
             next = right.next;
             right.next = pre;
             pre = right;
             right = next;
        }
        return result;
    }

}
