package DynamicProgramming;

/**
 * @author lihui
 */
public class CountSubstrings {
    /**
     * 647. 回文子串
     *
     * @param s 字符串
     * @return 统计并返回这个字符串中 回文子串 的数目
     */
    public int countSubstrings(String s) {
        int n = s.length();
        // dp[i][j] 从 i 开始到 j 结束的子字符串是否是回文串
        boolean[][] dp = new boolean[n][n];

        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 因为是从 i 到 j 的子字符串，所以 i <= j
                // 这个子字符串是否是回文串有两个条件：1 是首尾字符相同；2 是出去首尾之外的子字符串是回文串
                if (i <= j && s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        ++count;
                    }
                }
            }
        }

        return count;
    }

    // 中心拓展法
    public int countSubstringsPro(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) {
            return 0;
        }
        // 如果回文串是奇数，我们把回文串中心的那个字符叫做中心点，如果回文串是偶数我们就把中间的那两个字符叫做中心点
        // 总共有2 * len - 1个中心点
        // 对于一个长度为 len 的字符串，我们可以用它的任意一个字符当做中心点，所以中心点的个数是 len
        // 还可以用它任意挨着的两个字符当做中心点，所以中心点是 len - 1，总的中心点就是 2 * len - 1
        for (int i = 0; i < 2 * len - 1; i++) {
            // 通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            // 有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                // 如果当前是一个回文串，则记录数量
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}
