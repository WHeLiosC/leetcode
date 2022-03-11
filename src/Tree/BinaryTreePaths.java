package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihui
 */
public class BinaryTreePaths {
    private List<String> paths;

    /**
     * 257. 二叉树的所有路径
     *
     * @param root 根节点
     * @return 按任意顺序 ，返回所有从根节点到叶子节点的路径
     */
    public List<String> binaryTreePaths(TreeNode root) {
        paths = new LinkedList<>();
        if (root == null) {
            return paths;
        }
        if (root.left == null && root.right == null) {
            paths.add(String.valueOf(root.val));
            return paths;
        }
        getPath(root.left, String.valueOf(root.val));
        getPath(root.right, String.valueOf(root.val));
        return paths;
    }

    private void getPath(TreeNode node, String path) {
        if (node == null) {
            return;
        }
        path = path + "->" + node.val;
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        getPath(node.left, path);
        getPath(node.right, path);
    }

    /**
     * 257. 二叉树的所有路径 (迭代)
     *
     * @param root 根节点
     * @return 按任意顺序 ，返回所有从根节点到叶子节点的路径
     */
    public List<String> binaryTreePathsIteration(TreeNode root) {
        List<String> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<Object> stack = new LinkedList<>();
        stack.push(root);
        stack.push(String.valueOf(root.val));

        while (!stack.isEmpty()) {
            String path = (String) stack.pop();
            TreeNode node = (TreeNode) stack.pop();

            if (node.left == null && node.right == null) {
                result.add(path);
            }
            if (node.right != null) {
                stack.push(node.right);
                // 这里不能将 path 更新之后再压入，会导致 path 发生变化，下一个 if 语句中的 path 就不是原来的 path 了
                // 即不能写成 path = path + "->" + node.right.val
                stack.push(path + "->" + node.right.val);
            }
            if (node.left != null) {
                stack.push(node.left);
                stack.push(path + "->" + node.left.val);
            }
        }

        return result;
    }
}
