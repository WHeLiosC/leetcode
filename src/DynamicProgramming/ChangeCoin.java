package DynamicProgramming;

/**
 * @author lihui
 */
public class ChangeCoin {
    /**
     * 518. 零钱兑换 II
     *
     * @param amount 整数，总金额
     * @param coins  整数数组，表示不同面额的硬币
     * @return 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0。
     * 假设每一种面额的硬币有无限个。
     */
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    /**
     * 322. 零钱兑换
     *
     * @param coins  整数数组，表示不同面额的硬币
     * @param amount 整数，总金额
     * @return 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
     * 每种硬币的数量是无限的。
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        // 注意 i 从 1 开始，即 dp[0] = 0
        for (int i = 1; i < amount + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                // dp[j - coins[i]] == Integer.MAX_VALUE 时，比较没有意义，而且在这加一会溢出变成int的最小值
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
