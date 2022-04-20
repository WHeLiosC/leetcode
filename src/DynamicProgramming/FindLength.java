package DynamicProgramming;

/**
 * @author lihui
 */
public class FindLength {
    /**
     * 718. 最长重复子数组
     *
     * @param nums1 整数数组
     * @param nums2 整数数组
     * @return 返回 两个数组中公共的 、长度最长的子数组的长度
     */
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int ans = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    // dp[i][j] 以第 i 个数字结尾的 num1 和 以第 j 个数字结尾的 num2 的最大重复子数组
                    // i 和 j 的索引从 1 开始，所以 dp[0][j] 和 dp[i][0] 都为 0
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > ans) {
                    ans = dp[i][j];
                }
            }
        }
        return ans;
    }
}
