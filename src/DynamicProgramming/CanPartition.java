package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lihui
 */
public class CanPartition {
    /**
     * 416. 分割等和子集
     *
     * @param nums 只包含正整数 的 非空 数组 nums
     * @return 判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
     */
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        // 如果和为奇数，一定不能等分成两个子集
        if (sum % 2 == 1) {
            return false;
        }

        // 转换为01背包问题
        int target = sum / 2;
        int[] maxValue = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                maxValue[j] = Math.max(maxValue[j], maxValue[j - nums[i]] + nums[i]);
            }
        }

        return maxValue[target] == target;
    }
}
