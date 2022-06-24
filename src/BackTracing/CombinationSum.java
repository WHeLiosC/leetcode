package BackTracing;

import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * @author lihui
 */
public class CombinationSum {
    private List<List<Integer>> res = new LinkedList<>();
    private LinkedList<Integer> path = new LinkedList<>();

    /**
     * 39. 组合总和
     * <p>candidates 中的 同一个 数字可以 无限制重复被选取，如果至少一个数字的被选数量不同，则两种组合是不同的。</p>
     *
     * @param candidates 无重复元素 的整数数组
     * @param target     目标整数
     * @return 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);

        backTracing(candidates, target, 0, 0);
        return res;
    }

    private void backTracing(int[] candidates, int target, int curSum, int begin) {
        if (curSum == target) {
            res.add(new ArrayList<>(path));
        }

        /*
        // 因为题目说可以重复使用元素，所以这里从 0 开始考虑所有的候选数，但这样会导致结果中出现重复答案
        // 比如 [2,2,3] 和 [3,2,2]，[2,3,2] 都是同样的，因此需要去重
        for (int i = 0; i < candidates.length; i++) {
            if (curSum + candidates[i] > target){
                break;
            }
            path.add(candidates[i]);
            backTracing(candidates, target, curSum + candidates[i]);
            path.removeLast();
        }
         */

        // 通过规定搜索开始的顺序去重
        for (int i = begin; i < candidates.length; i++) {
            if (curSum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            // 每一层中后面的节点不再搜索前面的节点，由于元素可以重复使用，因此下一次开始索引是 i
            backTracing(candidates, target, curSum + candidates[i], i);
            path.removeLast();
        }
    }
}
