package Sort;

/**
 * 希尔排序算法
 * 时间复杂度：O(n^4/3) O(n^2) O(n(logn)^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author lihui
 */
public class ShellSort {
    public int[] shellSort(int[] nums) {
        sort(nums);
        return nums;
    }

    private void sort(int[] nums) {
        int len = nums.length;

        for (int gap = len / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < len; i++) {
                int temp = nums[i];
                int j = i;
                for (; j >= gap && nums[j - gap] > temp; j -= gap) {
                    nums[j] = nums[j - gap];
                }
                nums[j] = temp;
            }
        }
    }
}
