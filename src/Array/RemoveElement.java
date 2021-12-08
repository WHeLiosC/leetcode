package Array;

/**
 * @author lihui
 */
public class RemoveElement {
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

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        r.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }
}
