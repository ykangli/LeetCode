package August2022.day27;

import java.util.Random;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/27 20:28
 */
public class FindK {

    public int findKthLargest(int[] nums, int k) {
        int length = nums.length;
        int resultIndex = length - k;
        int left = 0;
        int right = nums.length - 1;
        while (true) {
            int pivot = partition(nums, left, right);
            if (pivot == resultIndex) {
                return nums[pivot];
            } else if (pivot < resultIndex) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

    }

    public static int partition(int[] num, int left, int right) {
        Random random = new Random(System.currentTimeMillis());
        int randomIndex = left + random.nextInt(right - left + 1);
        swap(num, left, randomIndex);
        int pivot = num[left];
        //j 是不变量，前面小于枢轴元素的最后一个
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (num[i] <= pivot) {
                j++;
                swap(num, i, j);
            }
        }
        swap(num, left, j);
        return j;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
