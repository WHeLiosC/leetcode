package Array;

/**
 * @author lihui
 */
public class BinarySearch {
    /**
     * 704. 二分查找
     *
     * @param nums   一个 n 个元素有序的（升序）整型数组
     * @param target 目标值
     * @return 目标值存在返回下标，否则返回 -1
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            // 改进 : 防止加法数值过大溢出
            // int middle  = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 35. 搜索插入位置
     *
     * @param nums   一个 n 个元素有序的（升序）整型数组
     * @param target 目标值
     * @return 目标值存在返回下标，否则返回被按顺序插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                return middle;
            }
        }
        return left;
    }

    /**
     * 34. 在排序数组中查找元素的第一个和最后一个位置
     *
     * @param nums   按照升序排列的整数数组
     * @param target 目标值
     * @return 给定目标值在数组中的开始位置和结束位置
     */
    public int[] searchRange(int[] nums, int target) {

        // 寻找左边界
        int left = 0;
        int right = nums.length - 1;
        int leftBroader = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                right = middle - 1;
                leftBroader = middle;
            }
        }

        // 寻找右边界
        left = 0;
        right = nums.length - 1;
        int rightBroader = -1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
                rightBroader = middle;
            }
        }

        if (leftBroader != -1 && leftBroader <= rightBroader) {
            return new int[]{leftBroader, rightBroader};
        }
        return new int[]{-1, -1};
    }

    /**
     * 69. x 的平方根
     *
     * @param x 非负整数
     * @return 返回 x 的算术平方根，返回类型是整数，结果只保留整数部分，小数部分将被舍去
     * TODO: 牛顿迭代法
     */
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            // 需要注意的是要将乘积结果转换为long类型或者使用除法，否则会溢出导致结果错误！
            if ((long) middle * middle <= x) {
                left = middle;
            } else if ((long) middle * middle > x) {
                right = middle;
            }
        }

        // right 和 left 相差 1，结果一定是 left 或 right
        if ((long) right * right == x) {
            return right;
        } else {
            return left;
        }
    }

    /**
     * 367. 有效的完全平方数
     *
     * @param num 正整数
     * @return 如果 num 是一个完全平方数，则返回 true ，否则返回 false
     */
    public boolean isPerfectSquare(int num) {
        int left = 0;
        int right = num;
        while (right - left > 1) {
            int middle = left + (right - left) / 2;
            if ((long) middle * middle <= num) {
                left = middle;
            } else if ((long) middle * middle > num) {
                right = middle;
            }
        }

        return (long) right * right == num || (long) left * left == num;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        b.mySqrt(8);
    }
}
