package BackTracing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author lihui
 */
public class CombinationSum3 {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> resItem = new LinkedList<>();

    /**
     * 216. 组合总和 III
     *
     * @param k 使用 k 个数
     * @param n 和为 n
     * @return 只使用数字 1 到 9，每个数字最多使用一次，返回所有可能的有效组合的列表，不能包含相同的组合两次
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracing(k, n, 1);
        return res;
    }

    private void backTracing(int k, int n, int next) {
        if (n < 0) {
            return;
        }

        if (n == 0 && k == 0) {
            if (!res.contains(resItem)) {
                // 要重新创建一个列表！不能直接添加 resItem!
                res.add(new ArrayList<>(resItem));
            }
            return;
        }

        for (int i = next; i < 10 && n >= i; i++) {
            resItem.add(i);
            backTracing(k - 1, n - i, i + 1);
            resItem.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum3 c = new CombinationSum3();
        c.combinationSum3(3, 9);
    }
}
