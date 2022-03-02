package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lihui
 */
public class Anagram {
    /**
     * 242. 有效的字母异位词
     *
     * @param s 字符串
     * @param t 字符串
     * @return 判断 t 是否是 s 的字母异位词，是则返回 true，否则返回 false
     */
    public boolean isAnagram(String s, String t) {
        // 排序
        char[] sortedS = s.toCharArray();
        char[] sortedT = t.toCharArray();
        Arrays.sort(sortedS);
        Arrays.sort(sortedT);
        return Arrays.equals(sortedS, sortedT);
    }

    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // 哈希表
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }
}
