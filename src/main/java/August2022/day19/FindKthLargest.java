package August2022.day19;

import java.util.Random;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/19 11:51
 * leetcode 215 数组中的第K个最大元素
 * 如果一趟快排后， 【】x【】      x的位置为 len - k，那么就找到了，
 * 如果小于len - k就去右边的区间用partition继续找；如果大于len - k就去左边的区间用partition继续找
 * 参考视频： https://www.bilibili.com/video/BV1fS4y1a7zF/?spm_id_from=333.788&vd_source=1864d1a67c3ac368d506e894c786b921
 */
public class FindKthLargest {
    public static void main(String[] args) {

    }

    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int targetIndex = len - k;
        int left = 0;
        int right = len - 1;
        while (true) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
    }

    public static int partition(int[] nums, int left, int right) {
        //随机挑选 pivot位置，而不是设定死为枢轴位置为left
        Random random = new Random(System.currentTimeMillis());
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, pivotIndex);

        int pivot = nums[left];
        //j 为不变量（值变化，定义不变），j是小于 pivot 区间的最后一个元素的位置
        // left 【】x【】
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, left, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
