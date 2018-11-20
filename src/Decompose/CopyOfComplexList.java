package Decompose;

import Utils.RandomListNode;

/*
* 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
* */
public class CopyOfComplexList {
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) {
            return null;
        }

        RandomListNode current = pHead;
        // 在原链表中复制每个节点并插入当前节点的后面
        while (current != null) {
            RandomListNode clone = new RandomListNode(current.label);
            clone.next = current.next;
            current.next = clone;
            current = clone.next;
        }

        current = pHead;
        // 复制Random指针
        while (current != null) {
            current.next.random = current.random == null ? null : current.random.next;
            current = current.next.next;
        }

        current = pHead;
        RandomListNode cloneHead = pHead.next;
        // 拆分链表
        while (current != null) {
            RandomListNode clone = current.next;
            current.next = clone.next;
            clone.next = clone.next == null ? null : clone.next.next;
            current = current.next;
        }

        return cloneHead;
    }
}
