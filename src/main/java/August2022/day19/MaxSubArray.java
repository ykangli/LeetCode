package August2022.day19;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/19 11:15
 * Leetcode 53.最大子数组和   动态规划
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int i = maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
        System.out.println(i);

    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int result = Integer.MIN_VALUE;
        dp[0] = nums[0];
        result = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 连续子数组  当前位置的最大要么是自己 num[i]（从头开始计数），要么是dp[i - 1] + nums[i]
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
