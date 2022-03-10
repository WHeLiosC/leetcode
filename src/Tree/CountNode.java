package Tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author lihui
 */
public class CountNode {
    /**
     * 222. 完全二叉树的节点个数
     *
     * @param root 根节点
     * @return 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nodeNum = 0;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            ++nodeNum;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return nodeNum;
    }

    /**
     * 222. 完全二叉树的节点个数 (改进)
     *
     * @param root 根节点
     * @return 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数
     */
    public int countNodesPro(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftLevel = countLevel(root.left);
        int rightLevel = countLevel(root.right);

        if (leftLevel == rightLevel) {
            // 说明左子树一定为满二叉树，节点数为 右子树节点+（左子树节点+根节点）
            return countNodesPro(root.right) + (1 << leftLevel);
        } else {
            // 说明右子树一定为满二叉树
            return countNodesPro(root.left) + (1 << rightLevel);
        }
    }

    private int countLevel(TreeNode node) {
        // 计算一个完全二叉树的最大高度
        int level = 0;
        while (node != null) {
            ++level;
            node = node.left;
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(2 << 5);
        System.out.println(1 << 6);
    }
}
