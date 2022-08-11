package Sort;

import java.util.Random;

/**
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
