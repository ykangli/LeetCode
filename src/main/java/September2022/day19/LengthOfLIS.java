package September2022.day19;

import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/9/19 16:38
 * 300. 最长递增子序列
 */
public class LengthOfLIS {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        //dp[i] 的值代表 nums 以 nums[i]nums[i] 结尾的最长子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


}
