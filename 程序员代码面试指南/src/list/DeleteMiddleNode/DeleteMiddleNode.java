package list.DeleteMiddleNode;

/**
 * TODO 2019/3/1 :
 * 删除链表中间节点
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class DeleteMiddleNode {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        Node node = delteMiddleNode(head);
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    /**
     * 删除中间节点
     * @param head 头结点
     */
    public static Node delteMiddleNode(Node head) {
        // 如果没有元素或者只有一个元素，不删
        if (head == null || head.next == null) {
            return head;
        }
        // 如果有两个元素，返回第二个元素
        if (head.next.next == null) {
            return head.next;
        }
        // 如果有3个元素甚至更多
        Node pre = head;
        Node cur = head.next.next;
        while (cur.next != null && cur.next.next != null) {
            pre = pre.next;
            cur = cur.next.next;
        }
        pre.next = pre.next.next;
        return head;
    }

}
