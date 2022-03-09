package Tree;

import com.sun.org.apache.xerces.internal.xs.ItemPSVI;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihui
 */
public class InvertTree {
    /**
     * 226. 翻转二叉树
     *
     * @param root 根节点
     * @return 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempTree = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(tempTree);
        return root;
    }

    /**
     * 226. 翻转二叉树 (迭代 DFS)
     *
     * @param root 根节点
     * @return 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
     */
    public TreeNode invertTreeIteration(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode tempNode = node.left;
            node.left = node.right;
            node.right = tempNode;
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return root;
    }

    /**
     * 226. 翻转二叉树 (迭代 BFS)
     *
     * @param root 根节点
     * @return 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点
     */
    public TreeNode invertTreeBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                TreeNode tempNode = node.left;
                node.left = node.right;
                node.right = tempNode;
            }
        }
        return root;
    }
}
