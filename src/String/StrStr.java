package String;

import java.util.Arrays;

/**
 * @author lihui
 */
public class StrStr {
    /**
     * 28. 实现 strStr()
     *
     * @param haystack 字符串
     * @param needle   字符串
     * @return 在 haystack 找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1
     */
    public int strStr(String haystack, String needle) {
        // 使用 Api
        return haystack.indexOf(needle);
    }

    /**
     * KMP 算法
     */
    public int KMPSearch(String pat, String txt) {
        if (pat.length() == 0) {
            return 0;
        }
        int m = pat.length();
        int n = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int[] lps = new int[m];
        // index for pat[]
        int j = 0;

        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat, m, lps);

        // index for txt[]
        int i = 0;
        while (i < n) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == m) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                return i - j;
                // 如果要寻找每一个匹配模式串的索引，则用下面的语句
                // j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < n && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 计算最长前缀后缀数组
     *
     * @param pat 模式串
     * @param m   模式串的长度
     * @param lps longest prefix suffix
     */
    public void computeLPSArray(String pat, int m, int[] lps) {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        // lps[0] is always 0
        lps[0] = 0;

        // the loop calculates lps[i] for i = 1 to M-1
        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar
                // to search step.
                if (len != 0) {
                    len = lps[len - 1];
                    // https://www.bilibili.com/video/BV16X4y137qw?from=search&seid=3627435847359559113&spm_id_from=333.337.0.0
                    // Also, note that we do not increment
                    // i here
                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
        System.out.println(Arrays.toString(lps));
    }

    public static void main(String[] args) {
        StrStr ss = new StrStr();
        ss.computeLPSArray("abaabcac", 8, new int[8]);
        ss.KMPSearch("coco", "cococola");
    }
}
