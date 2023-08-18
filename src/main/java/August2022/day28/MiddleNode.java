package August2022.day28;

import August2022.day22.ListNode;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/28 11:04
 */
public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
