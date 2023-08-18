package May2022.day05;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/18 9:08
 */
public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums, 0));
    }

    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }


        return -1;

    }
}
