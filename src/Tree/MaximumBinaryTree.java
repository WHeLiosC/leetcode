package Tree;

/**
 * @author lihui
 */
public class MaximumBinaryTree {
    private int[] nums;

    /**
     * 654. 最大二叉树
     *
     * @param nums 不重复的整数数组
     * @return 返回 nums 构建的 最大二叉树
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        this.nums = nums;
        return maximumBinaryTree(0, nums.length - 1);
    }

    private TreeNode maximumBinaryTree(int start, int end) {
        if (start > end) {
            return null;
        }

        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }

        TreeNode node = new TreeNode(nums[maxIndex]);
        node.left = maximumBinaryTree(start, maxIndex - 1);
        node.right = maximumBinaryTree(maxIndex + 1, end);
        return node;
    }
}
