package August2022.day24;

import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/24 11:21
 * 88. 合并两个有序数组
 * 双指针都指向两个数组的最后位置，倒序添加，这样在往nums某个位置添加元素时，就不需要往后移其他的
 */
public class Merge {
    public static void main(String[] args) {
        int[] nums1 = new int[]{2, 0};
        int[] nums2 = new int[]{1};
        int m = 1;
        int n = 1;
        merge(nums1, m, nums2, n);
        String s = Arrays.toString(nums1);
        System.out.println(s);

    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = nums2[i];
            }
        }
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (p2 < 0) {
                return;
            }
            if (p1 < 0) {
                nums1[i] = nums2[p2];
                p2--;
            } else if (nums1[p1] >= nums2[p2]) {
                nums1[i] = nums1[p1];
                p1--;
            } else {
                nums1[i] = nums2[p2];
                p2--;
            }
        }

    }
}
