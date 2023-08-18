package August2022.day20;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/20 17:30
 */
public class Qsort {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 2, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));

    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        Random random = new Random(System.currentTimeMillis());
        int pivotIndex = left + random.nextInt(right - left + 1);
        swap(nums, left, pivotIndex);

        int j = left;
        int pivot = nums[left];
        for (int i = left + 1; i < nums.length; i++) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, j, i);
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
