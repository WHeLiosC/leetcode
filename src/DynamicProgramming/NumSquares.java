package DynamicProgramming;

/**
 * @author lihui
 */
public class NumSquares {
    /**
     * 279. 完全平方数
     *
     * @param n 整数
     * @return 返回 和为 n 的完全平方数的最少数量
     */
    public int numSquares(int n) {
        int[] nums = new int[(int) Math.sqrt(n)];
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n){
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i + 1) * (i + 1);
        }

        // 完全背包
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= n; j++) {
                if (dp[j - nums[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - nums[i]] + 1);
                }
            }
        }
        return dp[n];
    }
}
