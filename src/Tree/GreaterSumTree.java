package Tree;

/**
 * @author Lihui
 */
public class GreaterSumTree {
    private int sum = 0;

    /**
     * 538. 把二叉搜索树转换为累加树 (1038. 从二叉搜索树到更大和树)
     *
     * @param root 二叉搜索树的根节点
     * @return 将其转换为累加树，使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。返回根节点
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 右根左的遍历方式
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }
}
