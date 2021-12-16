package Array;

import java.util.Arrays;

/**
 * @author lihui
 */
public class DoublePointer {
    /**
     * 27. 移除元素
     *
     * @param nums 数组
     * @param val  值
     * @return 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度
     */
    public int removeElement(int[] nums, int val) {
        int head = 0;
        int tail = nums.length - 1;
        while (head <= tail) {
            if (nums[head] == val) {
                // 从数组最后边开始寻找交换位置
                while (tail >= 0 && nums[tail] == val) {
                    --tail;
                }
                // 满足条件则交换
                if (head <= tail) {
                    int tmp = nums[head];
                    nums[head] = nums[tail];
                    nums[tail] = tmp;
                    // 交换之后 tail 要减一
                    --tail;
                }
            } else {
                ++head;
            }
        }
        return head;
    }

    /**
     * 26. 删除有序数组中的重复项
     *
     * @param nums 有序数组
     * @return 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }

        int slow = 1, fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                ++fast;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }

    /**
     * 283. 移动零
     * 编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     *
     * @param nums 数组
     */
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                ++slow;
            }
            ++fast;
        }
    }

    /**
     * 844. 比较含退格的字符串
     *
     * @param s 字符串
     * @param t 字符串
     * @return 判断二者是否相等。# 代表退格字符，如果相等，返回 true ；否则，返回 false
     */
    public boolean backspaceCompare(String s, String t) {
        return backspaceString(s).equals(backspaceString(t));
    }

    private String backspaceString(String str) {
        char[] chars = str.toCharArray();
        int slow = 0;
        int fast = 0;
        while (fast < chars.length) {
            if (chars[fast] != '#') {
                chars[slow] = chars[fast];
                ++slow;
            } else if (slow != 0) {
                // 退格的处理，GOOD
                --slow;
            }
            ++fast;
        }

        return Arrays.toString(chars).substring(0, slow + 1);
    }

    /**
     * 977. 有序数组的平方
     *
     * @param nums 非递减顺序排序的整数数组
     * @return 每个数字的平方组成的新数组，要求也按非递减顺序排序
     */
    public int[] sortedSquares(int[] nums) {
        int head = 0;
        int tail = nums.length - 1;
        int[] result = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int headSquare = nums[head] * nums[head];
            int tailSquare = nums[tail] * nums[tail];
            if (headSquare >= tailSquare) {
                result[i] = headSquare;
                ++head;
            } else {
                result[i] = tailSquare;
                --tail;
            }
        }
        return result;
    }

    /**
     * 167. 两数之和 II - 输入有序数组
     *
     * @param numbers 非递减顺序排列的整数数组
     * @param target  目标数
     * @return 以长度为 2 的整数数组的形式返回这两个数的下标值，numbers 的下标从 1 开始计数。
     * 假设每个输入只对应唯一的答案，而且不可以重复使用相同的元素
     */
    public int[] twoSum(int[] numbers, int target) {
        int head = 0;
        int tail = numbers.length - 1;
        while (head < tail) {
            if (numbers[head] + numbers[tail] > target) {
                --tail;
            } else if (numbers[head] + numbers[tail] < target) {
                ++head;
            } else {
                return new int[]{head + 1, tail + 1};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * 344. 反转字符串
     *
     * @param s 字符数组
     */
    public void reverseString(char[] s) {
        int head = 0;
        int tail = s.length - 1;
        while (head <= tail) {
            char tmp = s[head];
            s[head++] = s[tail];
            s[tail--] = tmp;
        }
    }

    public static void main(String[] args) {
        DoublePointer dp = new DoublePointer();
        dp.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }


}
