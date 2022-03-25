package DynamicProgramming;

/**
 * @author lihui
 */
public class NumTrees {
    /**
     * 96. 不同的二叉搜索树
     *
     * @param n 整数
     * @return 求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        // 零个节点没有意义，但后面的运算中需要将其定义为 1
        dp[0] = 1;
        // 一个节点只有一种
        dp[1] = 1;

        // 取 1 到 n 依次作为根节点，
        // 在每一个不同的根节点中，不同的二叉搜索树种数为左子树种树乘上右子树种树
        // 对每一种情况求和得到最终结果
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += (dp[j - 1] * dp[i - j]);
            }
        }
        return dp[n];
    }

    // TODO: 卡特兰数
}
