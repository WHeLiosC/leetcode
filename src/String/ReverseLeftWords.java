package String;

/**
 * @author lihui
 */
public class ReverseLeftWords {
    /**
     * 剑指 Offer 58 - II. 左旋转字符串
     *
     * @param s 字符串
     * @param n 整数
     * @return 把字符串前面的 n 个字符转移到字符串的尾部
     */
    public String reverseLeftWords(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }
}
