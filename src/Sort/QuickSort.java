package Sort;

import java.util.Random;

/**
 * 快速排序算法
 * 时间复杂度：平均 O(nlogn)  最好 O(nlogn)  最坏 O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author lihui
 */
public class QuickSort {
    private final Random RANDOM = new Random();

    public int[] quickSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int index = partition(nums, begin, end);
        sort(nums, begin, index - 1);
        sort(nums, index + 1, end);
    }

    private int partition(int[] nums, int low, int high) {
        int randomIndex = RANDOM.nextInt(high - low + 1) + low;
        swap(nums, low, randomIndex);

        int pivot = low;
        while (true) {
            while (low <= high && nums[low] < pivot) {
                ++low;
            }
            while (low <= high && nums[high] > pivot) {
                --high;
            }
            if (low < high) {
                swap(nums, low, high);
                ++low;
                --high;
            } else {
                break;
            }
        }
        swap(nums, pivot, high);
        return high;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
