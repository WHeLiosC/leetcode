package Tree;

/**
 * @author lihui
 */
public class SearchBST {
    /**
     * 700. 二叉搜索树中的搜索
     *
     * @param root 根节点
     * @param val  整数值
     * @return 在 BST 中找到节点值等于 val 的节点。返回以该节点为根的子树。如果节点不存在，则返回 null
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            // root.val > val
            return searchBST(root.left, val);
        }
        // 时间复杂度O(n)，空间复杂度O(n)
    }

    /**
     * 700. 二叉搜索树中的搜索（迭代）
     *
     * @param root 根节点
     * @param val  整数值
     * @return 在 BST 中找到节点值等于 val 的节点。返回以该节点为根的子树。如果节点不存在，则返回 null
     */
    public TreeNode searchBSTIteration(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                return root;
            } else {
                root = root.val < val ? root.right : root.left;
            }
        }
        return null;
        // 时间复杂度O(n)，空间复杂度O(1)
    }
}
