package September2022.day23;

import java.util.*;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/23 20:54
 * Leetcode 1. 两数之和
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] input = new int[]{3, 9, 6, 7, 7, 3};
        int[] ints = twoSum(input, 10);
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int min = target - nums[i];
            if (map.get(min) != null) {
                res.add(map.get(min));
                res.add(i);
                map.remove(min);
            } else {
                map.put(nums[i], i);
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
