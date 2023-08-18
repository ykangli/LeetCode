package August2022.day28;

import August2022.day22.ListNode;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/28 10:53
 * 判断链表是否成环
 */
public class HasCycle {
    public static void main(String[] args) {
        AtomicInteger a = new AtomicInteger();
        a.incrementAndGet();
    }
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        //注意while循环条件
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

}
