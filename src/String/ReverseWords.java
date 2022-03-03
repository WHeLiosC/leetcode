package String;

/**
 * @author lihui
 */
public class ReverseWords {
    /**
     * 151. 翻转字符串里的单词
     *
     * @param s 字符串
     * @return 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串
     */
    public String reverseWords(String s) {
        StringBuilder result = new StringBuilder();
        // 先把所有字符进行翻转
        String midResult = reverse(s.trim());
        // 再将每个单词进行翻转
        String[] words = midResult.split("\\s+");
        for (String word : words) {
            result.append(reverse(word));
            result.append(" ");
        }
        return result.toString().trim();
    }

    private String reverse(String s) {
        char[] arr = s.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            ++left;
            --right;
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "a good  example   is you ";
        String[] ss = s.split(" ");
        String[] sss = s.split("\\s+");
    }
}
