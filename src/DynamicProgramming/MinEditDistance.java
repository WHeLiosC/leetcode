package DynamicProgramming;

/**
 * @author lihui
 */
public class MinEditDistance {
    /**
     * 72. 编辑距离
     * <p>你可以对一个单词进行如下三种操作</p>
     * <ul>插入一个字符</ul>
     * <ul>删除一个字符</ul>
     * <ul>替换一个字符</ul>
     *
     * @param word1 单词
     * @param word2 单词
     * @return 返回将 word1 转换成 word2 所使用的最少操作数。
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
