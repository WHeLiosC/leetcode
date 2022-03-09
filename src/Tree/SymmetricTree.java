package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihui
 */
public class SymmetricTree {
    /**
     * 101. 对称二叉树 (递归)
     *
     * @param root 根节点
     * @return 是否轴对称
     */
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return isSymmetricRecursion(root.left, root.right);
        }
    }

    private boolean isSymmetricRecursion(TreeNode leftTree, TreeNode rightTree) {
        if (leftTree == null && rightTree == null) {
            return true;
        }
        if (leftTree == null || rightTree == null) {
            return false;
        }

        boolean b1 = isSymmetricRecursion(leftTree.left, rightTree.right);
        boolean b2 = isSymmetricRecursion(leftTree.right, rightTree.left);
        return leftTree.val == rightTree.val && b1 && b2;
    }

    /**
     * 101. 对称二叉树 (迭代)
     *
     * @param root 根节点
     * @return 是否轴对称
     */
    public boolean isSymmetricIteration(TreeNode root) {
        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
