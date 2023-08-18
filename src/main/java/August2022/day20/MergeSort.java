package August2022.day20;

import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/20 18:31
 * 归并排序
 * 参考视频：https://www.bilibili.com/video/BV1D64y1B76c?p=5&vd_source=1864d1a67c3ac368d506e894c786b921
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,2,3,1};
        //temp数组用来合并两个有序数组
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeSort(nums, left, mid, temp);
        mergeSort(nums, mid + 1, right, temp);
        if (nums[mid] <= nums[mid + 1]) {
            return;
        }
        mergeTwoSortedArray(nums, left, mid, right, temp);
    }

    public static void mergeTwoSortedArray(int[] nums, int left, int mid, int right, int[] temp) {
        //合并两个有序区间
        //1.先将nums复制到temp
        System.arraycopy(nums, 0, temp, 0, nums.length);
        //2. 两个区间的开头位置 【x .. ..】mid 【x .. ..】,互相比较小的放入nums中
        int i = left;
        int j = mid + 1;
        for (int k = left; k <= right; k++) {
            // 如果i超过mid，代表第一个区间已走完，那么剩下全从第二个区间中拿
            if (i > mid) {
                nums[k] = temp[j];
                j++;
                //如果j超过right，代表第二个区间已走完，那么剩下全从第1个区间中拿
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
