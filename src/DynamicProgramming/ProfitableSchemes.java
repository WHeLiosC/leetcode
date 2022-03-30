package DynamicProgramming;

/**
 * @author lihui
 */
public class ProfitableSchemes {
    /**
     * 879. 盈利计划
     *
     * @param n         n 名员工
     * @param minProfit 工作的任何至少产生 minProfit 利润的子集称为 盈利计划
     * @param group     第 i 种工作要求 group[i] 名成员共同参与
     * @param profit    第 i 种工作会产生 profit[i] 的利润
     * @return 有多少种计划可以选择？因为答案很大，所以返回结果模 10^9 + 7 的值
     */
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < profit.length; i++) {
            for (int j = n; j >= group[i]; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    dp[j][k] = (dp[j][k] + dp[j - group[i]][Math.max(0, k - profit[i])]) % (int) (1e9 + 7);
                }
            }
        }
        return dp[n][minProfit];
    }
}
