package DynamicProgramming;

import java.util.Arrays;

/**
 * @author lihui
 */
public class LastStoneWeightII {
    /**
     * 1049. 最后一块石头的重量 II
     * <p>
     * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和y，且 x <= y。那么粉碎的可能结果如下：
     * <p>如果 x == y，那么两块石头都会被完全粉碎；</p>
     * <p>如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。</p>
     * </p>
     *
     * @param stones 整数数组，其中 stones[i] 表示第 i 块石头的重量。
     * @return 最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
     */
    public int lastStoneWeightII(int[] stones) {
        int sum = Arrays.stream(stones).sum();
        int first = sum / 2;

        // 0-1背包，尽量填满容量为二分之一和的背包
        int[] dp = new int[first + 1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = first; j >= stones[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - stones[i]] + stones[i]);
            }
        }

        // return Math.abs((sum - dp[first]) - dp[first]);
        return Math.abs(sum - 2 * dp[first]);
    }
}
