package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihui
 */
public class BuildTree {
    int[] pre;
    int[] post;
    Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 105. 从前序与中序遍历序列构造二叉树
     *
     * @param preorder 二叉树的先序遍历
     * @param inorder  同一棵树的中序遍历
     * @return 构造二叉树并返回其根节点
     */
    public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        pre = preorder;
        return btpi(0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode btpi(int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = pre[preStart];
        int rootIndex = memo.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = btpi(preStart + 1, preStart + rootIndex - inStart, inStart, rootIndex - 1);
        root.right = btpi(preStart + rootIndex - inStart + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }

    /**
     * 106. 从中序与后序遍历序列构造二叉树
     *
     * @param inorder   二叉树的中序遍历
     * @param postorder 同一棵树的后序遍历
     * @return 构造二叉树并返回其根节点
     */
    public TreeNode buildTreeInPost(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memo.put(inorder[i], i);
        }
        post = postorder;

        return btip(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode btip(int inStart, int inEnd, int postStart, int postEnd) {
        if (inEnd < inStart || postEnd < postStart) {
            return null;
        }

        int rootVal = post[postEnd];
        int rootIndex = memo.get(rootVal);

        TreeNode root = new TreeNode(rootVal);
        root.left = btip(inStart, rootIndex - 1, postStart, postStart + rootIndex - inStart - 1);
        root.right = btip(rootIndex + 1, inEnd, postStart + rootIndex - inStart, postEnd - 1);
        return root;
    }
}
