package Tree;

import java.util.*;

/**
 * @author lihui
 */
public class Traversal {
    /**
     * 144. 二叉树的前序遍历 (递归)
     *
     * @param root 根节点
     * @return 返回它节点值的 前序 遍历
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        preorder(node.left, result);
        preorder(node.right, result);
    }

    /**
     * 144. 二叉树的前序遍历 (迭代)
     *
     * @param root 根节点
     * @return 返回它节点值的 前序 遍历
     */
    public List<Integer> preorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    /**
     * 94. 二叉树的中序遍历 (递归)
     *
     * @param root 根节点
     * @return 返回它的 中序 遍历
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    /**
     * 94. 二叉树的中序遍历 (迭代)
     *
     * @param root 根节点
     * @return 返回它的 中序 遍历
     */
    public List<Integer> inorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }

        return result;
    }

    /**
     * 145. 二叉树的后序遍历 (递归)
     *
     * @param root 根节点
     * @return 返回它的 后序 遍历
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        postorder(node.left, result);
        postorder(node.right, result);
        result.add(node.val);
    }

    /**
     * 145. 二叉树的后序遍历 (迭代)
     *
     * @param root 根节点
     * @return 返回它的 后序 遍历
     */
    public List<Integer> postorderTraversalIteration(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                while (!stack.isEmpty()) {
                    TreeNode tempNode = stack.peek();
                    if (tempNode.right != null && tempNode.right != pre) {
                        cur = tempNode.right;
                        break;
                    } else {
                        result.add(tempNode.val);
                        pre = tempNode;
                        stack.pop();
                    }
                }
            }
        }
        return result;
    }

    /**
     * 102. 二叉树的层序遍历
     *
     * @param root 根节点
     * @return 返回其节点值的层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode tempNode = queue.poll();
                level.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                --len;
            }
            result.add(level);
        }
        return result;
    }

    /**
     * 107. 二叉树的层序遍历 II
     *
     * @param root 根节点
     * @return 返回其节点值 自底向上的层序遍历
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            int len = queue.size();

            while (len > 0) {
                TreeNode tempNode = queue.poll();
                level.add(tempNode.val);
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                --len;
            }
            result.add(level);
        }

        Collections.reverse(result);
        return result;
    }

    /**
     * 199. 二叉树的右视图 (BFS)
     *
     * @param root 根节点
     * @return 给定一个二叉树的根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();

            for (int i = 0; i < len; i++) {
                TreeNode tempNode = queue.poll();
                if (i == len - 1) {
                    result.add(tempNode.val);
                }
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }

        return result;
    }

    private List<Integer> rightSideViewResult = new LinkedList<>();

    /**
     * 199. 二叉树的右视图 (DFS)
     *
     * @param root 根节点
     * @return 给定一个二叉树的根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
     */
    public List<Integer> rightSideViewDFS(TreeNode root) {
        rightSideViewRecursion(root, 0);
        return rightSideViewResult;
    }

    private void rightSideViewRecursion(TreeNode node, int depth) {
        if (node == null) {
            return;
        }
        if (depth == rightSideViewResult.size()) {
            rightSideViewResult.add(node.val);
        }
        ++depth;
        rightSideViewRecursion(node.right, depth);
        rightSideViewRecursion(node.left, depth);
    }

    /**
     * 637. 二叉树的层平均值
     *
     * @param root 根节点
     * @return 以数组的形式返回每一层节点的平均值
     */
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            double sum = 0;
            for (int i = 0; i < len; i++) {
                TreeNode tempNode = queue.poll();
                sum += tempNode.val;
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            result.add(sum / len);
        }
        return result;
    }

    /**
     * 515. 在每个树行中找最大值
     *
     * @param root 根节点
     * @return 找出该二叉树中每一层的最大值
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            int maxNumInLevel = Integer.MIN_VALUE;
            for (int i = 0; i < len; i++) {
                TreeNode tempNode = queue.poll();
                if (tempNode.val > maxNumInLevel) {
                    maxNumInLevel = tempNode.val;
                }
                if (tempNode.left != null) {
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
            }
            result.add(maxNumInLevel);
        }
        return result;
    }

    /**
     * 104. 二叉树的最大深度
     *
     * @param root 根节点
     * @return 返回其最大深度，根节点所在深度为 1
     */
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * 111. 二叉树的最小深度
     *
     * @param root 根节点
     * @return 返回其最小深度，根节点所在深度为 1
     */
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMinDepth = minDepth(root.left);
        int rightMinDepth = minDepth(root.right);
        // 如果左子树或右子树的深度不为 0，即存在一个子树，那么当前子树的最小深度就是该子树的深度+1
        // 如果左子树和右子树的深度都不为 0，即左右子树都存在，那么当前子树的最小深度就是它们较小值+1
        return (leftMinDepth == 0 || rightMinDepth == 0) ? leftMinDepth + rightMinDepth + 1 : Math.min(leftMinDepth, rightMinDepth) + 1;
    }
}
