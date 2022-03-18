package Tree;

/**
 * @author Lihui
 */
public class TrimBST {
    /**
     * 669. 修剪二叉搜索树
     *
     * @param root 二叉搜索树的根节点
     * @param low  最小边界
     * @param high 最大边界
     * @return 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。返回修剪好的二叉搜索树的新的根节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
