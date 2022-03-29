package DynamicProgramming;

/**
 * @author lihui
 */
public class FindMaxForm {
    /**
     * 474. 一和零
     *
     * @param strs 二进制字符串数组
     * @param m    整数
     * @param n    整数
     * @return 请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int numOfZero = 0, numOfOne = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '0') {
                    ++numOfZero;
                } else {
                    ++numOfOne;
                }
            }
            // 不能写成 for (int j = m, k = n; j >= numOfZero && k >= numOfOne; j--, k--)
            // 这样在更新数组状态时，只能同时更改两个条件；但实际上，当一个条件可以满足时，可以固定一个条件去改变另一个条件
            for (int j = m; j >= numOfZero; j--) {
                for (int k = n; k >= numOfOne; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - numOfZero][k - numOfOne] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
