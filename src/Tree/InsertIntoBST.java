package Tree;

/**
 * @author lihui
 */
public class InsertIntoBST {
    /**
     * 701. 二叉搜索树中的插入操作
     *
     * @param root 二叉搜索树（BST）的根节点
     * @param val  要插入树中的值 (新值和原始二叉搜索树中的任意节点值都不同)
     * @return 返回插入后二叉搜索树的根节点
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = root;

        while (node != null) {
            if (node.val < val) {
                if (node.right != null) {
                    node = node.right;
                } else {
                    node.right = new TreeNode(val);
                    return root;
                }
            } else {
                if (node.left != null) {
                    node = node.left;
                } else {
                    node.left = new TreeNode(val);
                    return root;
                }
            }
        }

        return new TreeNode(val);
    }
}
