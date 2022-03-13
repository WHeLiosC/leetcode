package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lihui
 */
public class FindBottomLeftValue {
    /**
     * 513. 找树左下角的值
     *
     * @param root 非空二叉树的根节点
     * @return 找出该二叉树的 最底层 最左边 节点的值
     */
    public int findBottomLeftValue(TreeNode root) {
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                if (i == 0){
                    result = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
