package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lihui
 */
public class FindLengthOfLCIS {
    /**
     * 674. 最长连续递增序列
     *
     * @param nums 未经排序的整数数组
     * @return 找到最长且 连续严格递增的子序列，并返回该序列的长度
     */
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            int len = 1;
            while (i < n && nums[i] > nums[i - 1]) {
                ++len;
                ++i;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }

    // DP，与第 300 题 LengthOfLIS 比较
    public int findLengthOfLCISDP(int[] nums) {
        int n = nums.length;
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }
}
