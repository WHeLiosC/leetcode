package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lihui
 */
public class Construct {
    /**
     * 383. 赎金信
     *
     * @param ransomNote 字符串
     * @param magazine   字符串
     * @return 判断 ransomNote 能不能由 magazine 里面的字符构成。magazine 中的每个字符只能在 ransomNote 中使用一次
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>(magazine.length());
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
}
