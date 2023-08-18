package September2022.day01;

import August2022.day22.ListNode;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/1 16:22
 * Leetcode 143. 重排链表
 * 1.找到链表的中点  2. 反转右半部分   3.合并两个链表
 */
public class ReorderList {
    public static void main(String[] args) {

    }

    public static void reorderList(ListNode head) {
        ListNode midNode = findMidNode(head);
        ListNode rightNode = midNode.next;
        //分为两端
        midNode.next = null;
        ListNode reversedRight = reverseList(rightNode);
        mergeList(head, reversedRight);
    }

    //交替合并两个链表
    public static void mergeList(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode p2 = list2;
        while (p1 != null && p2 != null) {
            ListNode next1 = p1.next;
            ListNode next2 = p2.next;
            p2.next = p1.next;
            p1.next = p2;
            p1 = next1;
            p2 = next2;
        }
    }


    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static ListNode findMidNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                return slow;
            }
        }
        return slow;
    }


}
