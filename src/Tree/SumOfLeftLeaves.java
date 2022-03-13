package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class SumOfLeftLeaves {
    /**
     * 404. 左叶子之和
     *
     * @param root 根节点
     * @return 给定二叉树的根节点 root ，返回所有左叶子之和
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                if (node.left.left == null && node.left.right == null) {
                    sum += node.left.val;
                }
                stack.push(node.left);
            }
        }

        return sum;
    }
}
