package DynamicProgramming;

/**
 * @author lihui
 */
public class Rob {
    /**
     * 198. 打家劫舍
     *
     * @param nums 每个房屋存放金额的非负整数数组 nums[i]
     * @return 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];

        // 每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，
        // 因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
    }
}
