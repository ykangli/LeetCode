package August2022.day21;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/21 11:25
 * 区间是左闭右闭  【】
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 9};
        int target = 0;
        int index = binarySearch(arr, target);
        System.out.println(index);
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return  -1;
    }
}
