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

    /**
     * 123. 买卖股票的最佳时机 III
     *
     * @param prices 数组 prices，其中 prices[i] 表示股票第 i 天的价格。
     * @return 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
     * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     */
    public int maxProfitIII(int[] prices) {
        // 一天中的五种状态：
        // dp[i][0] 没有操作
        // dp[i][1] 第一次买入，指前 i 天有一次买入，并不一定是第 i 天买入
        // dp[i][2] 第一次卖出
        // dp[i][3] 第二次买入
        // dp[i][4] 第二次卖出
        int[][] dp = new int[prices.length][5];
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];
    }

    // 优化空间
    public int maxProfitIIIPro(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }

    /**
     * 188. 买卖股票的最佳时机 IV
     *
     * @param k      最多可以完成 k 笔交易
     * @param prices 整数数组，数组 prices，其中 prices[i] 表示股票第 i 天的价格。
     * @return 设计一个算法来计算你所能获取的最大利润。
     */
    public int maxProfitIV(int k, int[] prices) {
        int n = prices.length;
        if (n == 0 || k == 0) {
            return 0;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];

        for (int i = 0; i < k; i++) {
            buy[i] = -prices[0];
            sell[i] = 0;
        }
        for (int i = 1; i < n; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];
    }

    /**
     * 309. 最佳买卖股票时机含冷冻期
     *
     * @param prices 整数数组，数组 prices，其中 prices[i] 表示股票第 i 天的价格。
     * @return 你可以尽可能地完成更多的交易，卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)，设计一个算法来计算你所能获取的最大利润。
     */
    public int maxProfitWithFreeze(int[] prices) {
        int n = prices.length;
        if (n == 0 || n == 1) {
            return 0;
        }
        int[][] dp = new int[n][3];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            // dp[i][0] : 持有股票的最大收益
            // dp[i][1] : 不持有股票并且在冷冻期内的最大收益
            // dp[i][2] : 不持有股票并且不在冷冻期内的最大收益
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][2]);
    }

    /**
     * 714. 买卖股票的最佳时机含手续费
     *
     * @param prices 整数数组，数组 prices，其中 prices[i] 表示股票第 i 天的价格。
     * @param fee    整数 fee 代表了交易股票的手续费用
     * @return 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
     * 返回获得利润的最大值。
     */
    public int maxProfitWithFee(int[] prices, int fee) {
        int n = prices.length;
        if (n ==0 || n==1){
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < prices.length; i++) {
            // dp[i][0] 表示第 i 天持有股票的所得现金；dp[i][1] 表示第 i 天不持有股票的所得现金
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return dp[prices.length - 1][1];
    }

    public static void main(String[] args) {
        TradeStocks ts = new TradeStocks();
        ts.maxProfitWithFreeze(new int[]{1, 2, 3, 0, 2});
    }
}
