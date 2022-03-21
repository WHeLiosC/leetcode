package DynamicProgramming;

/**
 * @author lihui
 */
public class ClimbStairs {
    /**
     * 70. 爬楼梯
     *
     * @param n 楼梯阶数
     * @return 每次你可以爬 1 或 2 个台阶。返回有多少种不同的方法可以爬到楼顶
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int nMinusTwo = 1, nMinusOne = 2;
        for (int i = 3; i <= n; i++) {
            // f(n) = f(n-1) + f(n-2)
            int temp = nMinusTwo + nMinusOne;
            nMinusTwo = nMinusOne;
            nMinusOne = temp;
        }
        return nMinusOne;
    }

    /**
     * 746. 使用最小花费爬楼梯
     *
     * @param cost 整数数组，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用
     * @return 计算并返回达到楼梯顶部的最低花费
     */
    public int minCostClimbingStairs(int[] cost) {
        int pre = 0, cur = 0;

        for (int i = 2; i <= cost.length; i++) {
            int next = Math.min(pre + cost[i - 2], cur + cost[i - 1]);
            pre = cur;
            cur = next;
        }

        return cur;
    }
}
