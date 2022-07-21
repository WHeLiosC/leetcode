package HashTable;

import java.util.*;

/**
 * @author Lihui
 */
public class ThreeSum {
    /**
     * 15. 三数之和
     *
     * @param nums 包含 n 个整数的数组
     * @return 判断 nums 中是否存在三个元素 a，b，c，使得 a + b + c = 0。返回所有和为 0 且不重复的三元组
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        // 将元素排序，然后问题转换成在有序数组中寻找两个数的和等于目标值的问题（leetcode 167题）
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 如果第一个数比0大，那后边的数都是大于0的。这种情况下后边不会有解了。
            if (nums[i] > 0) {
                return result;
            }
            // 跳过重复的元素，避免产生重复的解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 双指针解决在有序数组中寻找两个数的和等于目标值
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] + nums[i] == 0) {
                    List<Integer> tmp = new LinkedList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(nums[k]);
                    result.add(tmp);
                    // 容易忘记！下面的代码跳过重复的元素，避免产生重复的解
                    while (j < k && nums[j + 1] == nums[j]) {
                        ++j;
                    }
                    while (j < k && nums[k - 1] == nums[k]) {
                        --k;
                    }
                    ++j;
                    --k;
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    --k;
                } else {
                    ++j;
                }
            }
        }
        return result;
    }
}
