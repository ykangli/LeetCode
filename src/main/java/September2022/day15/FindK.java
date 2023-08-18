package September2022.day15;

import com.sun.xml.internal.org.jvnet.mimepull.CleanUpExecutorFactory;

import java.util.Random;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/15 11:04
 */
public class FindK {
    public static void main(String[] args) {

    }

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int target = length - k;
        int left = 0;
        int right = left - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == target) {
                return nums[pivot];
            } else if (pivot < target) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }
    }

    public static int partition(int[] nums, int left, int right) {
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(nums,left, randomIndex);
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] <= pivot) {
                j++;
                swap(nums, nums[i], nums[j]);
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
