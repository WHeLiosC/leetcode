package Others;

import java.util.HashMap;

/**
 * @author Lihui
 */
public class LenOfLongestReqSubstr {
    /**
     * <p>微软笔试</p>
     * 给定一个长度为 n 的字符串，字符串 s 中只包含小写英文字母，任务是找到
     * s 的最长子字符串，使得子字符串中的字母都出现偶数次。
     *
     * @param s 长度为 n 的字符串
     * @return 返回符合条件的最长子字符串的长度
     */
    public static int lenOfLongestReqSubstr(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int mask = 0;
        map.put(0, -1);

        // Stores the length of the
        // longest required subString
        int ans = 0;

        // Traverse the String
        for (int i = 0; i < s.length(); i++) {
            // Stores the value of the
            // digit present at current
            // index
            int val = s.charAt(i) - 'a';

            // Bitwise XOR of the mask
            // with 1 left-shifted by val
            mask ^= (1 << val);

            // Check if the value of mask is
            // already present in map or not
            if (map.containsKey(mask)) {
                // Update the final answer
                ans = Math.max(ans, i - map.get(mask));
            } else {
                map.put(mask, i);
            }
        }

        // Return the answer
        return ans;
    }

    // Driver Code
    public static void main(String[] args) {
        String s = "bdaaadadb";
        // 符合条件的子字符串有："aa", "adad", "daaada", "aaadad" 其中最长长度为 6
        int maxLen = lenOfLongestReqSubstr(s);
        System.out.print(maxLen);
    }
}
