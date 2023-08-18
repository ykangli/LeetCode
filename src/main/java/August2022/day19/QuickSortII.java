package August2022.day19;

import java.util.Arrays;
import java.util.Random;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/19 14:26
 */
public class QuickSortII {
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
        //随机枢轴位置  [0, right]
        int randomPivot = left + random.nextInt(right - left + 1);
        swap(nums, randomPivot, left);

        int pivot = nums[left];
        //j 为不变量（值变化，定义不变），j是小于 pivot 区间的最后一个元素的位置
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
