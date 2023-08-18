package August2022.day31;

import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/31 10:07
 * Leetcode 300. 最长递增子序列
 * dp[i] 为以nums[i]结尾的最长子序列长度
 * 如果一个较大的数接在较小的数后面，就会形成一个更长的子序列。只要 nums[i] 严格大于在它位置之前的某个数，
 * 那么 nums[i] 就可以接在这个数后面形成一个更长的上升子序列。
 * 核心：当nums[i] > nums[j] （ j为i之前的位置），那么nums[i]就可以接在以nums[j]为结尾的子序列后面，
 * 我们要计算所有当nums[i] > nums[j]时的nums[j],取最大然后 +1
 *
 *
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
    }
}
