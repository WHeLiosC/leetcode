package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Lihui
 */
public class FourSum {
    /**
     * 18. 四数之和
     *
     * @param nums   整数数组
     * @param target 目标值
     * @return 找出并返回满足nums[a] + nums[b] + nums[c] + nums[d] == target且不重复的四元组（a、b、c 和 d 互不相同）
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // 思路同三数之和（leetcode 15题）
        // 三数之和判断第一层循环中的数大于0就退出，是因为目标值为0；
        // 而本题的目标值为任意数，如果还用这种判断，会导致错误，因此要修改剪枝条件
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 适当剪枝
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[length - 1] + nums[length - 2] + nums[length - 3] < target) {
                continue;
            }
            // 去重，避免重复解
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                // 适当剪枝
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[j] + nums[length - 1] + nums[length - 2] < target) {
                    continue;
                }
                // 去重，避免重复解
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int l = nums.length - 1;
                while (k < l) {
                    if ((long) nums[k] + nums[l] + nums[i] + nums[j] == target) {
                        List<Integer> tmp = new LinkedList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add(nums[l]);
                        result.add(tmp);
                        while (k < l && nums[k] == nums[k + 1]) {
                            ++k;
                        }
                        while (k < l & nums[l] == nums[l - 1]) {
                            --l;
                        }
                        ++k;
                        --l;
                    } else if ((long) nums[k] + nums[l] + nums[i] + nums[j] > target) {
                        --l;
                    } else {
                        ++k;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] test = new int[]{1, -2, -5, -4, -3, 3, 3, 5};
        FourSum fs = new FourSum();
        fs.fourSum(test, -11);
    }
}
