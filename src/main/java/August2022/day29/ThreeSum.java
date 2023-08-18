package August2022.day29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/29 13:15
 */
public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //优化
        if (nums.length < 3 || nums[0] > 0 || nums[nums.length - 1] < 0) {
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            //优化
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            //是 left < right,等于是成为两个数了
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                List<Integer> list = new ArrayList<>();
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    //找到一组符合的后，i不动，需要left++ ，right--找下一组与i匹配的
                    left++;
                    right--;
                    // right去重  如[0,1,1,1,1,1,1]
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                    // left去重  如[0,1,1,1,1,1,1]
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
