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

    /**
     * 快速排序分割算法
     *
     * @param array 待分割数组
     * @param low   左边界
     * @param high  右边界
     * @return 下一次分割的索引位置
     */
    private int partition(int[] array, int low, int high) {
        // 选择最左边的元素作为轴元素
        int pivot = low;
        low = low + 1;
        while (low <= high) {
            // 从左往右寻找第一个大于轴元素的元素
            while (low <= high && array[low] < array[pivot]) {
                ++low;
            }
            // 从右往左寻找第一个小于轴元素的元素
            while (low <= high && array[high] > array[pivot]) {
                --high;
            }

            if (low < high) {
                // 交换之后 low 右移，high 左移
                swap(array, low++, high--);
            } else {
                // 不加该分支的话，当 low == high 的时候会陷入死循环
                ++low;
            }
        }
        swap(array, high, pivot);
        return high;
    }

    /**
     * 快速排序分割算法2 (挖坑法)
     *
     * @param array 待分割数组
     * @param low   左边界
     * @param high  右边界
     * @return 下一次分割的索引位置
     */
    private int partition2(int[] array, int low, int high) {
        // 选择最左边的元素作为轴元素
        int pivot = array[low];
        while (low < high) {
            // 必须先从右边开始，第一个坑属于轴元素，找第一个小于轴元素的数
            while (low < high && array[high] >= pivot) {
                --high;
            }
            // 找到后填入，然后再去左边找大于轴元素的数
            array[low] = array[high];
            // 此时，high 位置相当于是新的坑，需要从左边开始找一个大于轴元素的值填入
            while (low < high && array[low] <= pivot) {
                ++low;
            }
            array[high] = array[low];
        }
        // 最后达到的状态是 low == high
        // 所以 pivot 放的位置使用哪个索引都可以
        array[high] = pivot;
        return high;
    }

    /**
     * 快速排序分割算法3
     *
     * @param array 待分割数组
     * @param low   左边界
     * @param high  右边界
     * @return 下一次分割的索引位置
     */
    private int partition3(int[] array, int low, int high) {
        // 选择最右边的元素作为轴元素
        int pivot = array[high];
        // i 表示下一个比轴元素小的元素要放得位置
        int i = low;
        // 遍历数组把比轴元素小的元素放到左边，比轴元素大的元素放到右边
        for (int j = low; j <= high - 1; j++) {
            // 比轴元素小，就把该元素放到 i 位置
            if (array[j] < pivot) {
                swap(array, i, j);
                i++;
            }
        }
        // 最后把轴元素放到该在的位置上
        swap(array, i, high);
        return i;
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
