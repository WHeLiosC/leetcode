package BackTracing;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author lihui
 */
public class LetterCombinations {
    private static HashMap<Integer, String> map = new HashMap<>(8);
    private StringBuilder path = new StringBuilder();
    private ArrayList<String> res = new ArrayList<>();

    public LetterCombinations() {
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    /**
     * 17. 电话号码的字母组合
     *
     * @param digits 仅包含数字 2-9 的字符串
     * @return 返回所有它能表示的字母组合。答案可以按 任意顺序 返回
     */
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }

        // 判断异常的输入
        String regex = "[2-9]+";
        if (!Pattern.matches(regex, digits)) {
            return res;
        }

        backTracing(0, digits.length(), digits);
        return res;
    }

    private void backTracing(int index, int len, String digits) {
        if (index == len) {
            res.add(path.toString());
            return;
        }

        String str = map.get(digits.charAt(index) - '0');
        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backTracing(index + 1, len, digits);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinations lc = new LetterCombinations();
        lc.letterCombinations("*#23");
    }
}
