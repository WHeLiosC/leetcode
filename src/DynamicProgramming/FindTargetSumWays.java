package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lihui
 */
public class FindTargetSumWays {
    /**
     * 494. 目标和
     *
     * @param nums   整数数组
     * @param target 整数
     * @return 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个表达式。
     * 返回可以通过上述方法构造的、运算结果等于 target 的不同表达式的数目。
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        // 添加 '+' 的数字和为addSum，那么添加 '-' 的数字和为 sum-addSum
        // addSum - (sum - addSum) = target，addSum为整数并且非负
        if ((target + sum) % 2 != 0 || (target + sum) / 2 < 0) {
            return 0;
        }

        int addSum = (target + sum) / 2;

        // 转换成 0-1背包问题，求装满背包的种数
        int[] dp = new int[addSum + 1];
        // 注意初始化！dp[i] 表示和为 i 的装包方案数，和为 0 的方案就是不放任何元素，因此为 1
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = addSum; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[addSum];
    }
}
