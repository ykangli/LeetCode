package August2022.day28;

import August2022.day22.ListNode;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/28 11:11
 * 142. 环形链表 II    如果有环，返回环的位置。
 * Floyd判圈算法：
 * 链表有无环（快慢指针）
 * 环起点（快慢指针相遇后，新建指针p从头开始，slow指针从相遇地方开始，同时出发，再次相遇就是环起点）
 * 环的长度（相遇后，fast停止，slow前进相遇）
 */
public class DetectCycle {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, null);
        node1.next = new ListNode(2, node1);
        ListNode listNode = detectCycle(node1);
        System.out.println(listNode);
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode node = hasCycle(head);
        if (node == null) {
            return null;
        }
        ListNode fast = node;
        ListNode slow = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        //注意while循环条件
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }
}
