package BackTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihui
 */
public class Combine {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> resItem = new LinkedList<>();

    /**
     * 77. 组合
     *
     * @param n 整数
     * @param k 整数
     * @return 返回范围 [1, n] 中所有可能的 k 个数的组合
     */
    public List<List<Integer>> combine(int n, int k) {
        if (k <= 0 || k > n) {
            return res;
        }
        backTracing(n, k, 1);
        return res;
    }

    private void backTracing(int n, int k, int cur) {
        if (resItem.size() == k) {
            res.add(new ArrayList<>(resItem));
            return;
        }
        for (int i = cur; i <= n - (k - resItem.size()) + 1; i++) {
            resItem.add(i);
            backTracing(n, k, i + 1);
            resItem.removeLast();
        }
    }
}
