package August2022.day21;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/21 10:47
 */
public class Msort {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 8, 3, 5, 1, 8};
        int[] temp = new int[nums.length];
        mergesort(nums, 0, nums.length - 1, temp);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergesort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergesort(nums, left, mid, temp);
        mergesort(nums, mid + 1, right, temp);
        mergeTwoSortedArr(nums, left, mid, right, temp);
    }

    public static void mergeTwoSortedArr(int[] nums, int left, int mid, int right, int[] temp) {
        //新建一个临时数组用于排序，然后遍历原数组一个个添加进去
        for (int i = left; i <= right ; i++) {
            temp[i] = nums[i];
        }
        //i,j分别指向两个有序区间的第一个元素
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                nums[k] = temp[j];
                j++;
            } else if (j > right) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
            }
        }
    }
}
