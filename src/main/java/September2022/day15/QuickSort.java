package September2022.day15;

import java.util.Random;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/15 11:44
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{90,95,35,45,45,95,80};
        quickSort(nums, 0 , nums.length -1);
        System.out.println();
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, 0, left - 1);
        quickSort(nums, left + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
//        Random random = new Random(System.currentTimeMillis());
//        int randomIndex = left + random.nextInt(right - left + 1);
//        swap(nums, left, randomIndex);
        // j为不变量，代表小于枢轴的最后一个元素
        int j = left;
        int pivot = nums[left];
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, i, left);
            }
        }
        swap(nums, j, left);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
