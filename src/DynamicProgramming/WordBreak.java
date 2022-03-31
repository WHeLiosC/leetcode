package DynamicProgramming;

import java.util.List;

/**
 * @author lihui
 */
public class WordBreak {
    /**
     * 139. 单词拆分
     *
     * @param s        字符串
     * @param wordDict 字符串列表 wordDict 作为字典
     * @return 判断是否可以利用字典中出现的单词拼接出 s，不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        // dp[0] 没有意义，但是递归的基础，需要设为 true
        dp[0] = true;
        for (int j = 1; j <= s.length(); j++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                // 只有当 dp[j] == false 的时候才需要更新
                if (j >= wordLen && !dp[j]) {
                    dp[j] = dp[j - wordLen] && s.startsWith(word, j - wordLen);
                }
            }
        }
        return dp[s.length()];
    }
}
