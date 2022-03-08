package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihui
 */
public class AddNextRightPointer {
    // Definition for a Node.
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    /**
     * 116. 填充每个节点的下一个右侧节点指针
     *
     * @param root 根节点
     * @return 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
     */
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node tempNode = queue.poll();
                if (i < len - 1) {
                    tempNode.next = queue.peek();
                }
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
        }
        return root;
    }

    /**
     * 116. 填充每个节点的下一个右侧节点指针
     * (因为题目给出的树是满二叉树，所以可以先连接同一父节点的左右节点；然后根据上一层的连接起来的父节点，连接相邻的右节点与左节点)
     *
     * @param root 根节点
     * @return 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
     */
    public Node connect2(Node root) {
        if (root == null) {
            return null;
        }
        // 最左边的节点
        Node mostLeft = root;

        while (mostLeft.left != null) {
            Node head = mostLeft;

            while (head != null) {
                // 连接同一父节点的左右节点
                head.left.next = head.right;
                // 根据这一层的连接起来的父节点，连接下一层相邻的右节点与左节点
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            mostLeft = mostLeft.left;
        }
        return root;
    }

    /**
     * 117. 填充每个节点的下一个右侧节点指针 II (去掉了满二叉树的条件)
     *
     * @param root 根节点
     * @return 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL
     */
    public Node connectII(Node root) {
        if (root == null) {
            return null;
        }
        Node cur = root;
        while (cur != null) {
            Node dummyHead = new Node();
            Node pre = dummyHead;
            // 为下一层建立连接
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }

            cur = dummyHead.next;
        }
        return root;
    }
}

