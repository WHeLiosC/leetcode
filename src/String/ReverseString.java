package String;

import java.util.Arrays;

/**
 * @author lihui
 */
public class ReverseString {
    /**
     * 541. 反转字符串 II
     *
     * @param s 字符串
     * @param k 整数
     * @return 从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            reverse(chars, i, Math.min(i + k, s.length()) - 1);
        }
        return new String(chars);
    }

    private void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            ++left;
            --right;
        }
    }

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        rs.reverseStr("abcdefg", 2);
    }
}
