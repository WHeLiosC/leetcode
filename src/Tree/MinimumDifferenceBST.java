package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class MinimumDifferenceBST {
    /**
     * 530. 二叉搜索树的最小绝对差
     *
     * @param root 二叉搜索树的根节点（非空）
     * @return 树中任意两不同节点值之间的最小差值
     */
    public int getMinimumDifference(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        // 第一个出栈节点没有前一个节点，所以应当设置
        int preVal = root.right == null ? root.val : root.right.val;
        int minDiff = Integer.MAX_VALUE;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                minDiff = Math.min(minDiff, Math.abs(cur.val - preVal));
                preVal = cur.val;
                cur = cur.right;
            }
        }

        return minDiff;
    }
}
