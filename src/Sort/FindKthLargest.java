package Sort;


/**
 * @author Lihui
 */
public class FindKthLargest {
    /**
     * 215. 数组中的第K个最大元素
     *
     * @param nums 整数数组
     * @param k    整数
     * @return 返回数组中第 k 个最大的元素
     */
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int left = 0, right = len - 1;
        int target = len - k;
        while (true) {
            int p = partition(nums, left, right);
            if (p == target) {
                return nums[p];
            } else if (p > target) {
                right = p - 1;
            } else {
                left = p + 1;
            }
        }
    }

    private int partition(int[] array, int left, int right) {
        int pivot = left;
        left = left + 1;
        while (left <= right) {
            while (left <= right && array[left] < array[pivot]) {
                ++left;
            }
            while (left <= right && array[right] > array[pivot]) {
                --right;
            }

            if (left < right) {
                swap(array, left++, right--);
            } else {
                ++left;
            }
        }
        swap(array, right, pivot);
        return right;
    }

    private void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void main(String[] args) {
        FindKthLargest fkl = new FindKthLargest();
        int num = fkl.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
        System.out.println(num);
    }
}
