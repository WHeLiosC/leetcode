package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihui
 */
public class TwoSum {
    /**
     * 1. 两数之和
     *
     * @param nums   整数数组
     * @param target 整数目标值
     * @return 在该数组中找出和为目标值 target 的那两个整数，并返回它们的数组下标
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
