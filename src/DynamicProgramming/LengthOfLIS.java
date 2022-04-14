package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lihui
 */
public class LengthOfLIS {
    /**
     * 300. 最长递增子序列
     *
     * @param nums 整数数组
     * @return 找到其中最长严格递增子序列的长度
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            // dp[i]: 以第 i 个数为结尾获得的最大长度
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    // 动态规划 + 贪心(二分)
    public int lengthOfLISPro(int[] nums) {
        // tails[i] : 长度为 i 的严格递增子序列的最小的结尾数
        int[] tails = new int[nums.length];
        int res = 0;
        for (int num : nums) {
            int i = 0, j = res;
            // 二分查找应该替换的位置，在同等长度的情况下使用小数字结尾替换大数字结尾
            while (i < j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (res == j) {
                ++res;
            }
        }
        return res;
    }
}
