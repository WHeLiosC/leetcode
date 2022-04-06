package DynamicProgramming;

/**
 * @author lihui
 */
public class TradeStocks {
    /**
     * 121. 买卖股票的最佳时机
     *
     * @param prices 数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格
     * @return 只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 如果你不能获取任何利润，返回 0 。
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     *
     * @param prices 数组 prices，其中 prices[i] 表示股票第 i 天的价格。
     * @return 你可能会决定购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以购买它，然后在 同一天 出售。
     * 返回 你能获得的 最大 利润 。
     */
    public int maxProfitII(int[] prices) {
        // 贪心，因为可以多次交易，每次都在涨之前买，然后再卖
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }

    // 动态规划
    public int maxProfitIIDP(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // dp[i][0] 表示第 i 天持有股票的所得现金；dp[i][1] 表示第 i 天不持有股票的所得现金
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }
}
