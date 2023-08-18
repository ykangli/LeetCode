package August2022.day30;

import August2022.day22.ListNode;


/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/30 22:29
 * 25. K 个一组翻转链表
 * 先反转前k个结点，再递归每k个反转链表中剩余的，最后将两部分连接起来
 */
public class ReverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr = new ListNode(-1,head);
        for (int i = 1; i <= k; i++) {
            curr = curr.next;
            if (curr.next == null && i < k) {
                return head;
            }
        }
        ListNode restNode = curr.next;
        curr.next = null;
        ListNode node1 = reverse(head);
        ListNode reverse = reverseKGroup(restNode, k);
        head.next = reverse;
        return node1;


    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
