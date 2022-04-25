package DynamicProgramming;

/**
 * @author lihui
 */
public class MaxSubArray {
    /**
     * 53. 最大子数组和
     *
     * @param nums 整数数组
     * @return 请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * 子数组 是数组中的一个连续部分。
     */
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            if (nums[i] > maxSum) {
                maxSum = nums[i];
            }
        }
        return maxSum;
    }
}
