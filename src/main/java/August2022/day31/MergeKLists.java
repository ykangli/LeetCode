package August2022.day31;

import August2022.day22.ListNode;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/30 22:57
 * 23. 合并K个升序链表
 * 依次两两合并链表  参考两个有序链表的合并     利用归并优化
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        //可利用归并来优化
//        ListNode result = null;
//        for (ListNode list : lists) {
//            result = mergeTwoListsRecursion(result, list);
//        }
//        return result;
        return merge(lists, 0, lists.length - 1);
    }

    //合并区间内的链表
    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode list1 = merge(lists, left, mid);
        ListNode list2 = merge(lists, mid + 1, right);
        return mergeTwoListsRecursion(list1, list2);
    }


    //合并两个有序链表
    public static ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursion(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursion(list2.next, list1);
            return list2;
        }
    }


}
