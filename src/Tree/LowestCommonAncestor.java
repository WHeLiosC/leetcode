package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class LowestCommonAncestor {
    /**
     * 236. 二叉树的最近公共祖先
     *
     * @param root 根节点
     * @param p    树中的节点
     * @param q    树中的节点
     * @return 找到该树中两个指定节点的最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int toFindP = p.val, toFindQ = q.val;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode cur = root, pre = null;

        // 使用后序遍历
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                while (!stack.isEmpty()) {
                    TreeNode node = stack.peek();
                    // 如果两个要找的值已经一样，当前节点即是最近公共祖先
                    if (toFindP == toFindQ) {
                        return node;
                    }
                    if (node.right != null && node.right != pre) {
                        cur = node.right;
                        break;
                    } else {
                        pre = stack.pop();
                        // 如果已经找到了 p 值，但还没有找到 q 值，则问题转换为寻找 p 的父节点与 q 的最近公共祖先
                        // p 的父节点即是当前栈顶元素
                        if (node.val == toFindP) {
                            toFindP = stack.peek().val;
                        }
                        if (node.val == toFindQ) {
                            toFindQ = stack.peek().val;
                        }
                    }
                }
            }
        }
        return null;
    }

    /**
     * 236. 二叉树的最近公共祖先（递归）
     *
     * @param root 根节点
     * @param p    树中的节点
     * @param q    树中的节点
     * @return 找到该树中两个指定节点的最近公共祖先
     */
    public TreeNode lowestCommonAncestorR(TreeNode root, TreeNode p, TreeNode q) {
        // 递归结束条件
        if (root == null || root == p || root == q) {
            return root;
        }

        // 后序遍历
        TreeNode left = lowestCommonAncestorR(root.left, p, q);
        TreeNode right = lowestCommonAncestorR(root.right, p, q);

        if (left == null && right == null) {
            // 若未找到节点 p 或 q
            return null;
        } else if (left == null) {
            // 若找到一个节点
            return right;
        } else if (right == null) {
            // 若找到一个节点
            return left;
        } else { // 若找到两个节点
            return root;
        }
    }
}
