package String;

/**
 * @author lihui
 */
public class StrStr {
    /**
     * 28. 实现 strStr()
     * @param haystack 字符串
     * @param needle 字符串
     * @return 在 haystack 找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1
     */
    public int strStr(String haystack, String needle) {
        // 使用 Api
        return haystack.indexOf(needle);
    }
}
