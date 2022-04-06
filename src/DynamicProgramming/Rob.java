package DynamicProgramming;

import Tree.TreeNode;

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

    // Scroll array
    public int robScrollArray(int[] nums) {
        int first = 0, second = 0;
        for (int num : nums) {
            int temp = second;
            second = Math.max(first + num, second);
            first = temp;
        }
        return second;
    }

    /**
     * 213. 打家劫舍 II
     *
     * @param nums 每个房屋存放金额的非负整数数组 nums[i]
     * @return 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     */
    public int robII(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }

        // 可以分为两种情况：偷第一家，那么就不考虑最后一家；不偷第一家，考虑最后一家。返回两者的最大值。
        return Math.max(robFromRange(nums, 0, nums.length - 1),
                robFromRange(nums, 1, nums.length));
    }

    private int robFromRange(int[] nums, int start, int end) {
        int first = 0, second = 0;
        for (int i = start; i < end; i++) {
            int temp = second;
            second = Math.max(second, first + nums[i]);
            first = temp;
        }
        return second;
    }

    /**
     * 337. 打家劫舍 III
     * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
     * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
     *
     * @param root 可行窃地区只有一个入口，我们称之为 root
     * @return 返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
     */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 偷根节点
        int maxMoneyWithRoot = root.val;
        if (root.left != null) {
            maxMoneyWithRoot += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            maxMoneyWithRoot += (rob(root.right.left) + rob(root.right.right));
        }

        // 不偷根节点
        int maxMoneyWithoutRoot = rob(root.left) + rob(root.right);

        return Math.max(maxMoneyWithRoot, maxMoneyWithoutRoot);

        // 方法超时
    }

    // 优化，树形DP
    public int robPro(TreeNode root) {
        int[] res = robTree(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robTree(TreeNode node) {
        // 返回长度为 2 的数组
        // 下标为 0 记录不偷该节点所得到的的最大金钱，下标为 1 记录偷该节点所得到的的最大金钱
        int[] res = new int[2];
        if (node == null) {
            return res;
        }

        int[] leftChild = robTree(node.left);
        int[] rightChild = robTree(node.right);

        // 偷当前节点
        res[1] = node.val + leftChild[0] + rightChild[0];
        // 不偷当前节点
        res[0] = Math.max(leftChild[0], leftChild[1]) + Math.max(rightChild[0], rightChild[1]);
        return res;
    }
}
