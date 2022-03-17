package Tree;

/**
 * @author lihui
 */
public class DeleteNodeBST {
    /**
     * 450. 删除二叉搜索树中的节点
     *
     * @param root 二叉搜索树的根节点
     * @param key  待删除的值
     * @return 返回二叉搜索树（有可能被更新）的根节点的引用
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode node = root;
        TreeNode father = null;

        // 二叉树的搜索，找到待删除的节点
        while (node != null) {
            if (node.val == key) {
                break;
            } else {
                father = node;
                node = node.val < key ? node.right : node.left;
            }
        }

        // 1. 在树中不存在 key 对应的节点
        if (node == null) {
            return root;
        }

        // 2. 存在，进行删除操作，分为三种情况
        // (1) 待删除的节点为叶子节点，直接删除
        if (node.left == null && node.right == null) {
            if (node == root) {
                return null;
            }
            if (father.val < key) {
                // 待删除的节点为右叶子结点
                father.right = null;
            } else {
                father.left = null;
            }
        }
        // (2) 待删除节点有一个子树，子承父业
        else if (node.left == null || node.right == null) {
            if (node == root) {
                return node.left == null ? node.right : node.left;
            }
            if (father.val < key) {
                // 待删除的节点为右子树的根节点
                father.right = node.left == null ? node.right : node.left;
            } else {
                father.left = node.left == null ? node.right : node.left;
            }
        }
        // (3) 待删除节点有两个子树，合并删除或者复制删除，这里用复制删除
        else {
            // 寻找被删除节点的左子树的最大值或者右子树的最小值，将该值赋给待删除节点，转化为删除该值所在的节点
            TreeNode cur = node.left;
            father = node;
            while (cur.right != null) {
                father = cur;
                cur = cur.right;
            }
            node.val = cur.val;
            // 如果左子树根节点就是最大的值
            if (father == node) {
                node.left = cur.left;
            }
            // 否则，则替死鬼的父节点的右子树改为替死鬼的左子树
            else {
                father.right = cur.left;
            }
        }

        return root;
    }
}
