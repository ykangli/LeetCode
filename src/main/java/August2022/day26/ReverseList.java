package August2022.day26;


import August2022.day22.ListNode;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/26 11:39
 */
public class ReverseList {

    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}
