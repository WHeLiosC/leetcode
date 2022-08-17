package Sort;

/**
 * 堆排序算法
 * 时间复杂度：O(nlogn)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 *
 * @author lihui
 */
public class HeapSort {
    public int[] heapSort(int[] nums) {
        sort(nums);
        return nums;
    }

    private void sort(int[] nums) {
        int len = nums.length;

        // 建堆
        // len / 2 - 1 是维护堆性质的第一个元素，即堆中的索引最大的非叶子节点
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(nums, len, i);
        }

        // 排序
        // 排序是将堆顶元素与堆末尾元素交换，然后将堆末尾元素从堆中去掉，从堆顶开始维护堆的性质
        for (int i = len - 1; i > 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    /**
     * 维护最大堆的性质
     *
     * @param nums 存储堆的数组
     * @param n    堆中的元素个数
     * @param i    待维护的节点索引
     */
    private void heapify(int[] nums, int n, int i) {
        int largest = i;
        // 左孩子下标
        int l = i * 2 + 1;
        // 右孩子下标
        int r = i * 2 + 2;

        // 找到三个节点中最大的节点
        if (l < n && nums[l] > nums[largest]) {
            largest = l;
        }
        if (r < n && nums[r] > nums[largest]) {
            largest = r;
        }

        if (largest != i) {
            swap(nums, largest, i);
            // 递归维护堆的性质
            heapify(nums, n, largest);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
