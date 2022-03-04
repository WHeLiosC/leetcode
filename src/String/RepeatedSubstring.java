package String;

/**
 * @author Lihui
 */
public class RepeatedSubstring {
    /**
     * 459. 重复的子字符串
     *
     * @param s 字符串
     * @return 返回是否可以通过由它的一个子串重复多次构成
     */
    public boolean repeatedSubstringPattern(String s) {
        // 找最长前缀后缀
        int n = s.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int j = 1;
        int len = 0;
        while (j < n) {
            if (s.charAt(j) == s.charAt(len)) {
                ++len;
                lps[j] = len;
                ++j;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[j] = len;
                    ++j;
                }
            }
        }
        int nlps = lps[n - 1];
        // 字符串除去最长公共前缀后缀后，就剩下一个周期的子串
        return nlps > 0 && n % (n - nlps) == 0;
    }

    // 暴力解法
    public boolean repeatedSubstringPattern2(String s) {
        int n = s.length();
        // i 是尝试的周期子串长度
        for (int i = 1; i * 2 <= n; i++) {
            if (n % i == 0) {
                boolean isMatch = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    return true;
                }
            }
        }
        return false;
    }

    // 拼接法（如果一个字符串是周期串，那么掐头去尾拼接在一起后一定包含原串）
    public boolean repeatedSubstringPattern3(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }

    // 方法解析：https://writings.sh/post/algorithm-repeated-string-pattern
}
