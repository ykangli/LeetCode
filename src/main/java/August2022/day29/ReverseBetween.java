package August2022.day29;

import August2022.day22.ListNode;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/29 11:37
 * Leetcode 92. 反转链表 II
 * 先删除结点，再利用头插法插入节点
 */
public class ReverseBetween {
    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, null)))));
        ListNode listNode = reverseBetween(head, 2, 4);
        System.out.println(listNode);
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }
        //整个链表的伪结点
        ListNode dummy = new ListNode(-1, head);
        //始终指向left的前一个位置   （插入需要一个pre，一个当前位置的结点）
        ListNode pre = dummy;
        //始终指向原区间的最左边节点，这个结点会一直往后走
        ListNode leftNode = head;
        //找到left位置的前一个结点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            leftNode = leftNode.next;
        }
        for (int i = left; i < right; i++) {
            //从链表中删除最左边结点的下一个结点
            ListNode deletedNode = leftNode.next;
            leftNode.next = deletedNode.next;
            //头插法
            deletedNode.next = pre.next;
            pre.next = deletedNode;
        }
        return dummy.next;
    }
}
