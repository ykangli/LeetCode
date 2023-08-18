package August2022.day16;

import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/17 11:03
 * 21. 合并两个有序链表
 * 当 l1 和 l2 都不是空链表时，判断 l1 和 l2 哪一个链表的头节点的值更小，将较小值的节点添加到结果里，
 * 当一个节点被添加到结果里之后，将对应链表中的节点向后移一位。
 */
public class MergeTwoLists {
    public static void main(String[] args) {
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode tail = result;
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        } else {
            while (curr1!= null && curr2 != null) {
                int val = 0;
                if (curr1.val <= curr2.val) {
                    val = curr1.val;
                    curr1 = curr1.next;
                } else {
                    val = curr2.val;
                    curr2 = curr2.next;
                }
                ListNode p = new ListNode(val);
                tail.next = p;
                tail = p;
            }
            tail.next = curr1 == null ? curr2 : curr1;
        }
        return result.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
