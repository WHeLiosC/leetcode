package DynamicProgramming;

/**
 * @author lihui
 */
public class MinDistance {
    /**
     * 583. 两个字符串的删除操作
     *
     * @param word1 单词
     * @param word2 单词
     * @return 返回使得 word1 和  word2 相同所需的最小步数, 每步可以删除任意一个字符串中的一个字符
     */
    public int minDistance(String word1, String word2) {
        // 同 1143. 最长公共子序列 longestCommonSubsequence
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return n - dp[n][m] + m - dp[n][m];
    }
}
