题目：反转单向链表

书本思路：
1、暂存的变量：上一个节点pre，下一个节点next
2、遍历整个链表
   | 保存下一个节点next：
         next = head.next;
   | 修改引用：把节点pre赋值到 当前节点.next：
         head.next = pre;
   | 更新上一个节点pre：
         pre = head;
   | 改变头节点：head = next;