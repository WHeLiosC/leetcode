package DynamicProgramming;

/**
 * @author lihui
 */
public class IntegerBreak {
    /**
     * 343. 整数拆分
     *
     * @param n 正整数，2 <= n <= 58
     * @return 将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     * 返回 你可以获得的最大乘积 。
     */
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                // dp[i] = Math.max(dp[i], Math.max(i - j, dp[i - j]) * j);
                dp[i] = Math.max(dp[i], (i - j) * j);
                dp[i] = Math.max(dp[i], dp[i - j] * j);
            }
        }
        return dp[n];
    }

    /**
     * 343. 整数拆分 (数学推导)
     *
     * @param n 正整数，2 <= n <= 58
     * @return 将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
     * 返回 你可以获得的最大乘积 。
     */
    public int integerBreakMath(int n) {
        // 推导：https://leetcode-cn.com/problems/integer-break/solution/343-zheng-shu-chai-fen-tan-xin-by-jyd/
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 2 * 2;
        } else if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }
}
