package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class SubTree {
    /**
     * 572. 另一棵树的子树
     *
     * @param root    根节点
     * @param subRoot 根节点
     * @return 检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) {
            return true;
        }
        // subRoot != null
        if (root == null) {
            return false;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (isSameTree(node, subRoot)) {
                return true;
            }

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return false;
    }

    private boolean isSameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
    }

    // TODO:树哈希
}
