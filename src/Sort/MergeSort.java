package Sort;

/**
 * 归并排序算法
 * 时间复杂度：平均 O(nlogn)  最好 O(nlogn)  最坏 O(nlogn)
 * 空间复杂度：O(n)
 * 稳定性：稳定
 *
 * @author lihui
 */
public class MergeSort {
    public int[] mergeSort(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            // 排序左半区
            sort(nums, left, mid);
            // 排序右半区
            sort(nums, mid + 1, right);
            // 合并左右半区
            merge(nums, left, mid, right);
        }
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // 左半区数组长度
        int n1 = mid - left + 1;
        // 右半区数组长度
        int n2 = right - mid;

        // 创建两个临时数组
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        for (int i = 0; i < n1; i++) {
            leftArr[i] = nums[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = nums[mid + 1 + i];
        }

        int i = 0, j = 0;
        int k = left;
        // 类似合并两个有序链表的思想
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                nums[k] = leftArr[i];
                ++i;
            } else {
                nums[k] = rightArr[j];
                ++j;
            }
            ++k;
        }
        // 合并剩余元素
        while (i < n1) {
            nums[k++] = leftArr[i++];
        }
        while (j < n2) {
            nums[k++] = rightArr[j++];
        }
    }
}
