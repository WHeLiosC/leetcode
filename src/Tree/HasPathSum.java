package Tree;

/**
 * @author lihui
 */
public class HasPathSum {
    /**
     * 112. 路径总和
     *
     * @param root      二叉树的根节点
     * @param targetSum 目标和整数
     * @return 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum。
     * 如果存在，返回 true；否则，返回 false
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
