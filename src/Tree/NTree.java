package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lihui
 */
public class NTree {
    // Definition for a Node.
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    /**
     * 429. N 叉树的层序遍历
     *
     * @param root 根节点
     * @return 给定一个 N 叉树，返回其节点值的层序遍历
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tempNode = queue.poll();
                level.add(tempNode.val);
                // N 叉树的子节点形成一个链表，可以直接使用 addAll()方法，不需要像二叉树那样进行左右节点的判断
                queue.addAll(tempNode.children);
            }
            result.add(level);
        }
        return result;
    }
}


