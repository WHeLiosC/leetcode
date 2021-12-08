import java.util.*;

/**
 * @author lihui
 */
public class Solution {
    /**
     * 187. 重复的DNA序列 (10-08-21)
     *
     * @param s DNA 字符串
     */
    public List<String> findRepeatedDnaSequences(String s) {
        final int l = 10;
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i <= len - l; i++) {
            String target = s.substring(i, i + l);
            // map 的 getOrDefault 方法
            map.put(target, map.getOrDefault(target, 0) + 1);
            // 可以防止重复添加元素
            if (map.get(target) == 2) {
                result.add(target);
            }
        }
        return result;
    }

    /**
     * 441. 排列硬币 (10-10-21)
     *
     * @param n 枚硬币
     */
    public int arrangeCoins(int n) {
        int row = 0;
        for (int i = 1; n > 0; i++) {
            n = n - i;
            if (n < 0) {
                break;
            }
            row++;
        }
        return row;
    }

    /**
     * 869. 重新排序得到 2 的幂 (10-28-21)
     *
     * @param n 正整数
     */
    public Boolean reorderedPowerOf2(int n) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i > 0; i = i << 1) {
            set.add(numToStr(i));
        }
        return set.contains(numToStr(n));
    }

    private String numToStr(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }

    /**
     * 5916. 转化数字的最小运算数
     * 给你一个下标从 0 开始的整数数组 nums ，该数组由 互不相同 的数字组成。另给你两个整数 start 和 goal 。
     * <p>
     * 整数 x 的值最开始设为 start ，你打算执行一些运算使 x 转化为 goal 。你可以对数字 x 重复执行下述运算：
     * <p>
     * 如果 0 <= x <= 1000 ，那么，对于数组中的任一下标 i（0 <= i < nums.length），可以将 x 设为下述任一值：
     * <p>
     * x + nums[i]
     * x - nums[i]
     * x ^ nums[i]（按位异或 XOR）
     * 注意，你可以按任意顺序使用每个 nums[i] 任意次。使 x 越过 0 <= x <= 1000 范围的运算同样可以生效，但该该运算执行后将不能执行其他运算。
     * <p>
     * 返回将 x = start 转化为 goal 的最小操作数；如果无法完成转化，则返回 -1 。
     *
     * @param nums  整数数组
     * @param start 开始值
     * @param goal  目标值
     * @return 操作数
     */
    public int minimumOperations(int[] nums, int start, int goal) {
        int minOps = 0;
        Set<Integer> nodes = new HashSet<>();
        Set<Integer> allNodes = new HashSet<>();
        Set<Integer> extendNodes = new HashSet<>();
        nodes.add(start);
        while (!nodes.isEmpty()) {
            minOps += 1;
            allNodes.addAll(nodes);
            for (int node : nodes) {
                for (int num : nums) {
                    int addOpRes = node + num;
                    int minusOpRes = node - num;
                    int xorOpRes = node ^ num;
                    if (addOpRes == goal || minusOpRes == goal || xorOpRes == goal) {
                        return minOps;
                    }
                    if (addOpRes >= 0 && addOpRes <= 1000 && !allNodes.contains(addOpRes)) {
                        extendNodes.add(addOpRes);
                    }
                    if (minusOpRes >= 0 && minusOpRes <= 1000 && !allNodes.contains(minusOpRes)) {
                        extendNodes.add(minusOpRes);
                    }
                    if (xorOpRes >= 0 && xorOpRes <= 1000 && !allNodes.contains(xorOpRes)) {
                        extendNodes.add(xorOpRes);
                    }
                }
            }
            nodes.clear();
            nodes.addAll(extendNodes);
            extendNodes.clear();
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 8, 16};
        int res = solution.minimumOperations(nums, 0, 1);
        System.out.println(res);
    }
}
