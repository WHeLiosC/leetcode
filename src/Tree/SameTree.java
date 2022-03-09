package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihui
 */
public class SameTree {
    /**
     * 100. 相同的树 (递归)
     *
     * @param p 二叉树的根节点
     * @param q 二叉树的根节点
     * @return 返回这两棵树是否相同
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        // p 和 q 有且只有一个为空
        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 100. 相同的树 (迭代)
     *
     * @param p 二叉树的根节点
     * @param q 二叉树的根节点
     * @return 返回这两棵树是否相同
     */
    public boolean isSameTreeIteration(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);

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
            queue.offer(node2.left);
            queue.offer(node1.right);
            queue.offer(node2.right);
        }
        return true;
    }
}
