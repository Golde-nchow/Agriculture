package 剑指offer._25;

import java.util.HashMap;

/**
 * 2019/10/22 :
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
 * 返回结果为复制后复杂链表的head。
 *
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class Num25 {

    public static void main(String[] args) {
        RandomListNode pHead = new RandomListNode(0);
        RandomListNode pHead1 = new RandomListNode(7);
        RandomListNode pHead2 = new RandomListNode(2);
        RandomListNode pHead3 = new RandomListNode(3);
        RandomListNode pHead4 = new RandomListNode(11);
        RandomListNode pHead5 = new RandomListNode(32);

        RandomListNode randomListNode = Clone(pHead);
    }

    public static RandomListNode Clone(RandomListNode pHead){
        if (pHead == null) {
            return pHead;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode p1 = pHead;
        RandomListNode p2 = pHead;
        while (p1 != null) {
            map.put(p1, new RandomListNode(p1.label));
            p1 = p1.next;
        }
        while (p2 != null) {
            if (p2.next != null) {
                map.get(p2).next = map.get(p2.next);
            } else {
                map.get(p2).next = null;
            }
            map.get(p2).random = map.get(p2.random);
            p2 = p2.next;
        }
        return map.get(pHead);
    }

}

@SuppressWarnings("all")
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}
