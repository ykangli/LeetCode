package August2022.day19;

/**
 * @author ykangli
 * @version 1.0
 * @date 2022/8/19 15:28
 * Leetcode 121. 买卖股票的最佳时机  动态规划   注意首先理解 dp[i]的定义： 是i天之前（包括当天）理论利润的最大值
 *
 */
public class MaxProfit {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        //dp[i] 表示第i天及其之前，理论利润最多为dp[i]
        int[] dp = new int[prices.length];
        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < prices.length; i++) {
            //维护一个到当前为止的最小价格
            min = Math.min(min, prices[i]);
            if (i == 0) {
                dp[0] = 0;
            } else {
                dp[i] = Math.max(dp[i - 1], prices[i] - min);
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}
