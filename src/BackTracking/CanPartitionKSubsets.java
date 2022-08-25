package BackTracking;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author lihui
 */
public class CanPartitionKSubsets {
    /**
     * 698. 划分为k个相等的子集
     *
     * @param nums 整数数组
     * @param k    正整数
     * @return 找出是否有可能把这个数组分成 k 个非空子集，其总和都相等
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (k > nums.length) {
            return false;
        }
        if (k == 1) {
            return true;
        }

        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        int target = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > target) {
            return false;
        }
        int[] bucket = new int[k];

        // 方法一：球选择桶
        // 排序之后从最大的元素开始处理，更容易触发剪枝条件，减少递归
        return backTracking(nums, nums.length - 1, bucket, k, target);

        // 方法二：桶选择球
        // 使用位图来替代 boolean 数组
//        int used = 0;
//        return backTracking2(nums, 0, 0, k, target, used);
    }

    /**
     * 方法一：每一个球选择不同的桶
     *
     * @param nums   数组
     * @param index  本次要处理的球
     * @param bucket 桶
     * @param k      桶的个数
     * @param target 每个桶的目标和
     * @return 是否能够划分
     */
    private boolean backTracking(int[] nums, int index, int[] bucket, int k, int target) {
        // index 为 -1，说明所有的球都处理完了，能够划分
        if (index == -1) {
            return true;
        }

        for (int i = 0; i < k; i++) {
            // 剪枝，如果当前桶和上一个桶的元素和一样，那么选择当前桶和选择上一个桶结果是一样的
            if (i > 0 && bucket[i] == bucket[i - 1]) {
                continue;
            }
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            // 选择当前桶
            bucket[i] += nums[index];
            // 处理下一个元素
            if (backTracking(nums, index - 1, bucket, k, target)) {
                return true;
            }
            // 撤销选择，回溯
            bucket[i] -= nums[index];
        }

        return false;
    }

    HashMap<Integer, Boolean> memo = new HashMap<>();

    /**
     * 方法二：每个桶选择是否装入某个球
     *
     * @param nums   数组
     * @param bucket 当前桶的和
     * @param index  开始的球的索引
     * @param k      桶的个数
     * @param target 每个桶的目标和
     * @param used   是否用过某个球，因为规定的球的个数小于 16，因此可以使用 int 代替 boolean 数组
     * @return 是否能够划分
     */
    private boolean backTracking2(int[] nums, int bucket, int index, int k, int target, int used) {
        if (k == 0) {
            return true;
        }
        if (bucket == target) {
            // 当前桶已经装满，开始下一个桶，下一个桶从索引 0 开始选择球
            boolean res = backTracking2(nums, 0, 0, k - 1, target, used);
            // 记录状态
            memo.put(used, res);
            return res;
        }

        // 避免重复计算
        if (memo.containsKey(used)) {
            return memo.get(used);
        }

        for (int i = index; i < nums.length; i++) {
            // 第 i 个球已经使用过了
            if (((used >> i) & 1) == 1) {
                continue;
            }

            if (bucket + nums[i] > target) {
                continue;
            }

            // 做选择
            bucket += nums[i];
            // 第 i 位标记为 1，位运算优先级高于 |=
            used |= 1 << i;

            if (backTracking2(nums, bucket, i + 1, k, target, used)) {
                return true;
            }

            // 恢复状态
            bucket -= nums[i];
            used ^= 1 << i;
        }
        return false;
    }
}
