package August2022.day22;

import August2022.day16.MergeTwoLists;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/22 11:24
 *
 *21. 合并两个有序链表
 * 两种方法 ：
 * （1）一个一个结点比较
 * （2）递归     如何递归：我们判断 l1 和 l2 头结点哪个更小，然后较小结点的 next 指针指向其余结点的合并结果。
 *
 */
public class MergeTwoListsRecursion {

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list2.next, list1);
            return list2;
        }

    }

}
