package Sort;

/**
 * 冒泡排序算法
 * 时间复杂度：平均 O(n^2)  最好 O(n)  最坏 O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author lihui
 */
public class BubbleSort {
    public int[] bubbleSort(int[] nums) {
        sort(nums);
        return nums;
    }

    private void sort(int[] nums) {
        int len = nums.length;

        for (int i = 1; i < len; i++) {
            boolean isSorted = true;
            for (int j = 0; j < len - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    isSorted = false;
                }
            }
            if (isSorted) {
                break;
            }
        }
    }
}
