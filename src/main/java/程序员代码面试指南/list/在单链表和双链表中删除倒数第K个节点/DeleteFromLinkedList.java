package 程序员代码面试指南.list.在单链表和双链表中删除倒数第K个节点;

/**
 * TODO 2019/2/27 :
 * 在单链表和双链表中删除倒数第 K 个节点
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class DeleteFromLinkedList {

    public static void main(String[] args) {
        SingleNode singleNode = new SingleNode(1);
        singleNode.next = new SingleNode(2);
        singleNode.next.next = new SingleNode(3);
        singleNode.next.next.next = new SingleNode(4);
        singleNode.next.next.next.next = new SingleNode(5);

        DoubleNode doubleNode1 = new DoubleNode(1);
        DoubleNode doubleNode2 = new DoubleNode(2);
        DoubleNode doubleNode3 = new DoubleNode(3);
        DoubleNode doubleNode4 = new DoubleNode(4);
        DoubleNode doubleNode5 = new DoubleNode(5);
        doubleNode1.next = doubleNode2;
        doubleNode2.next = doubleNode3;
        doubleNode2.last = doubleNode1;
        doubleNode3.next = doubleNode4;
        doubleNode3.last = doubleNode2;
        doubleNode4.next = doubleNode5;
        doubleNode4.last = doubleNode3;
        doubleNode5.last = doubleNode4;

        deleteFromSingleLinkedList(singleNode, 2);
        System.out.println("------------------");
        deleteFromDoubleLinkedList(doubleNode1, 4);

    }

    /**
     * 自己实现：删除单链表中倒数第 K 个节点
     * @param node 单链表
     * @note 容易出现的问题：
     *       1、倒数第 k 个，那么可以用链表长度 - k，得到顺数第 n - k个，但是现在没有链表长度.
     *       2、如果链表长度为3，要求删除倒数第4个，那么肯定有问题.但是现在没有链表长度.
     * @solution
     *       1、如果链表有4个元素，k 为 4，那么当前 node 要符合 node.next.next.next.next == null
     *       2、如果在这过程中有一个 node.next出现了 null(除去最后一个)，就说明有问题
     *       3、但是有问题，时间复杂度为 O(N的3次方)
     */
    public static void deleteFromSingleLinkedList1(SingleNode node, int k) {
        while (node != null) {
            while (k == 0) {

                k--;
            }
            node = node.next;
        }
        if (node == null) {

        }
        if (k != 0) {
            System.out.println("出现错误...");
        }
    }

    /**
     * 书本实现：删除单链表中倒数第 K 个节点
     * @param node 单链表
     * @param k 倒数第 K 个节点
     */
    public static void deleteFromSingleLinkedList(SingleNode head, int k) {
        SingleNode cur = head;
        while (cur != null) {
            cur = cur.next;
            k--;
        }
        // 返回到链表头
        cur = head;
        // 当k+1 == 0的时候，说明该节点是将被删除的节点
        if (k == 0) {
            cur.next = cur.next.next;
        }
        if (k < 0) {
            while (++k != 0) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        // 打印
        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
    }

    /**
     * 自己实现：删除双链表中倒数第 K 个节点，感觉还可以
     * @param node 双链表
     */
    public static void deleteFromDoubleLinkedList(DoubleNode node, int k) {
        DoubleNode startOne = node;
        DoubleNode lastOne = node;
        // 指针处于最后
        while (node != null) {
            if (node.next == null) {
                lastOne = node;
            }
            node = node.next;
        }
        node = lastOne;
        // 把尾指针移动到倒数k个
        for (int i = 1; i < k; i++) {
            node = node.last;
        }

        // 移除元素：如果出现倒数第 k 个为头节点
        if (node.last == null) {
            node = node.next;
            node.next.last = null;
        } else {
            // 移除元素：如果出现倒数第 k 个不为头节点
            node.last.next = node.next;
            node.next.last = node.last;
        }
        // 打印
        while (startOne != null) {
            System.out.println(startOne.value);
            startOne = startOne.next;
        }
    }
}
