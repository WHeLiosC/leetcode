package Tree;

/**
 * @author lihui
 */
public class BalanceTree {
    /**
     * 110. 平衡二叉树
     *
     * @param root 根节点
     * @return 判断它是否是高度平衡的二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 相当于自顶向下的递归，高度计算有重复
        return Math.abs(countLevel(root.right) - countLevel(root.left)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int countLevel(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return Math.max(countLevel(node.left), countLevel(node.right)) + 1;
    }

    /**
     * 110. 平衡二叉树 (自底向上)
     *
     * @param root 根节点
     * @return 判断它是否是高度平衡的二叉树
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return countLevel2(root) != -1;
    }

    private int countLevel2(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftLevel, rightLevel;
        if ((leftLevel = countLevel2(node.left)) == -1 ||
                (rightLevel = countLevel2(node.right)) == -1 ||
                Math.abs(rightLevel - leftLevel) > 1) {
            return -1;
        }
        return Math.max(leftLevel, rightLevel) + 1;
    }
}
