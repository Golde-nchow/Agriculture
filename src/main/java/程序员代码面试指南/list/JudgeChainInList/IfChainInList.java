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
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        head.next.next.next.next = new Node(5);
        System.out.println("回文结构：" + myJudgeChain(head));
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
        return false;
    }

}
