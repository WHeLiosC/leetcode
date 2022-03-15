package Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihui
 */
public class FindMode {
    /**
     * 501. 二叉搜索树中的众数
     *
     * @param root 二叉搜索树（BST）的根节点
     * @return 找出并返回 BST 中的所有众数（即，出现频率最高的元素）
     */
    public int[] findMode(TreeNode root) {
        Queue<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        int count = 0;
        int maxCount = 1;
        int curNum = Integer.MIN_VALUE;

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                // 对值的处理部分
                if (cur.val == curNum) {
                    ++count;
                } else {
                    count = 1;
                    curNum = cur.val;
                }

                if (count == maxCount) {
                    result.offer(curNum);
                } else if (count > maxCount) {
                    result.clear();
                    result.offer(curNum);
                    maxCount = count;
                }
                cur = cur.right;
            }
        }

        int size = result.size();
        int[] ans = new int[size];
        for (int i = 0; i < size; i++) {
            ans[i] = result.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        FindMode fm = new FindMode();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        fm.findMode(root);
    }
}
