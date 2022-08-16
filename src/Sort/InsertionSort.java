package Sort;

/**
 * 插入排序算法
 * 时间复杂度：平均 O(n^2)  最好 O(n)  最坏 O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：稳定
 *
 * @author lihui
 */
public class InsertionSort {
    public int[] insertionSort(int[] nums) {
        sort(nums);
        return nums;
    }

    private void sort(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            int temp = nums[i];

            int j = i;
            for (; j > 0 && nums[j - 1] > temp; j--) {
                nums[j] = nums[j - 1];
            }

            nums[j] = temp;
        }
    }
}
