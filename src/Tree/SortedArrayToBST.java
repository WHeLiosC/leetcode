package Tree;

/**
 * @author Lihui
 */
public class SortedArrayToBST {
    private int[] sortedArray;

    /**
     * 108. 将有序数组转换为二叉搜索树
     *
     * @param nums 严格递增的整数数组
     * @return 将其转换为一棵 高度平衡 二叉搜索树，返回其根节点
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        sortedArray = nums;
        return helper(0, nums.length - 1);
    }

    private TreeNode helper(int start, int end) {
        if (start > end){
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedArray[mid]);
        node.left = helper(start, mid - 1);
        node.right = helper(mid + 1, end);
        return node;
    }
}
