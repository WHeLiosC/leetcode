package Tree;

import java.util.List;

/**
 * @author lihui
 */
public class TreeDepth {
    private class Node{
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 559. N 叉树的最大深度
     * @param root 根节点
     * @return 返回其最大深度
     */
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        for (Node node : root.children) {
            depth = Math.max(depth, maxDepth(node) + 1);
        }
        return depth;
    }

    // 使用迭代的方法，可以使用层序遍历
}
