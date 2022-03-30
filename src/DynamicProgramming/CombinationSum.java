package DynamicProgramming;

/**
 * @author lihui
 */
public class CombinationSum {
    /**
     * 377. 组合总和 Ⅳ
     *
     * @param nums   由 不同 整数组成的数组
     * @param target 目标整数
     * @return 从 nums 中找出并返回总和为 target 的元素组合的个数。
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
        // 题目相似零钱兑换II (518)，区别：排列数 与 组合数
    }
}
