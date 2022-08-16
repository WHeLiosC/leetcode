package Sort;

/**
 * 选择排序算法
 * 时间复杂度：平均 O(n^2)  最好 O(n^2)  最坏 O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author lihui
 */
public class SelectionSort {
    public int[] selectionSort(int[] nums) {
        sort(nums);
        return nums;
    }

    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }
}
