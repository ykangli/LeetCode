package August2022.day01;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/13 17:22
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] a = {2, 45, 34, 23, 5, 11, 32, 98, 61};
        QuickSort.quicksort(a, 0, 8);
        for (int i : a) {
            System.out.println(i);
        }
    }

    public static void quicksort(int[] nums, int low, int high) {
        if (low < high) {
            int pivot = quickPass(nums, low, high);
            quicksort(nums, low, pivot - 1);
            quicksort(nums, pivot + 1, high);
        }
    }

    public static int quickPass(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            if (low < high) {
                nums[low] = nums[high];
                low++;
            }
            while (low < high && nums[low] < pivot) {
                low++;
            }
            if (low < high) {
                nums[high] = nums[low];
                high++;
            }
        }
        nums[low] = pivot;
        return low;
    }
}
