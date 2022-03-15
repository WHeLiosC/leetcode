package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class ValidBST {
    /**
     * 98. 验证二叉搜索树
     *
     * @param root 根节点
     * @return 判断其是否是一个有效的二叉搜索树
     */
    public boolean isValidBST(TreeNode root) {
        // 二叉搜索树的中序遍历一定是一个严格递增序列
        Deque<TreeNode> stack = new LinkedList<>();
        // 这里不能是 Integer.MIN_VALUE，因为节点值的范围包括了这个值，如果根节点是这个值，会导致错误
        long preVal = Long.MIN_VALUE;
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 不能存在重复的节点值，即所有结点的关键码互不相同
                if (preVal >= cur.val) {
                    return false;
                }
                preVal = cur.val;
                cur = cur.right;
            }
        }

        return true;
    }

    /**
     * 98. 验证二叉搜索树（递归）
     *
     * @param root 根节点
     * @return 判断其是否是一个有效的二叉搜索树
     */
    public boolean isValidBSTRecursion(TreeNode root) {
        return isValidBSTRecursion(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBSTRecursion(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBSTRecursion(node.left, lower, node.val) && isValidBSTRecursion(node.right, node.val, upper);
    }
}
