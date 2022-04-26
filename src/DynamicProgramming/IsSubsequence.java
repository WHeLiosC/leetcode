package DynamicProgramming;

/**
 * @author lihui
 */
public class IsSubsequence {
    /**
     * 392. 判断子序列
     *
     * @param s 字符串
     * @param t 字符串
     * @return 判断 s 是否为 t 的子序列
     */
    public boolean isSubsequence(String s, String t) {
        return helper(s, t);
    }

    private boolean helper(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 == 0) {
            return true;
        }
        if (len1 > len2) {
            return false;
        }
        if (s1.charAt(0) == s2.charAt(0)) {
            return helper(s1.substring(1), s2.substring(1));
        } else {
            return helper(s1, s2.substring(1));
        }
    }

    // 双指针
    public boolean isSubsequenceDoublePointer(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                ++i;
            }
            ++j;
        }
        return i == s.length();
    }

    // 动态规划
    public boolean isSubsequenceDp(String s, String t) {
        int n = s.length(), m = t.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            dp[0][i] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

}
