package May2022.day05;

import java.util.Arrays;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/5/18 10:17
 */
public class BestTimeStock {

    //贪心
    public static int maxProfit(int[] prices) {
        int result = 0;
        int leftMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            leftMin = Math.min(leftMin, prices[i]);
            result = Math.max(result, prices[i] - leftMin);
        }
        return result;
    }

    //dp[i]为第i天的收益，dp[i] = Math.max(dp[i - 1], prices[i] - min), min为第i天之前的股价最小值
    public static int solve(int[] prices) {
        int[] dp = new int[prices.length];
        int min = Integer.MAX_VALUE; //第i天之前的股价最小值
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, prices[i]);
            if (i == 0) {
                dp[i] = 0;
            } else {
                dp[i] = Math.max(dp[i - 1], prices[i] - min);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
